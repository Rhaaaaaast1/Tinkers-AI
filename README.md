# Tinkers' AI

为 **Tinkers' Construct（匠魂）** 增加两个功能：**怪物生成时的匠魂装备** 与 **匠魂远程武器的怪物 AI**。
本目录是 **1.20.1 Forge** 版本（1.21.1 NeoForge 版本在同仓库的根目录）。

## 环境

| 项目 | 版本 |
| --- | --- |
| Minecraft | 1.20.1 |
| Forge | 47.4.28 |
| Tinkers' Construct | 3.12.1.237（可选依赖） |
| Mantle | 1.11.124（可选依赖） |
| Java | 17 |

匠魂不是硬性前置：未安装时模组正常加载，只是不会注册装备与 AI 逻辑（启动日志会说明）。

## 功能一：怪物身上的匠魂装备（数据包驱动）

怪物生成（`EntityJoinLevelEvent`，此时原版与匠魂自己的装备都已完成 roll）时：

1. **剥离原版装备**：物品标签 `#tinkersai:stripped_monster_gear` 中的物品（木/石/铁/金/钻石/下界合金的工具与武器、皮/锁链/铁/金/钻石/下界合金护甲、盾牌、弓、弩、剪刀、打火石）会被从六个装备槽移除。
   - 只影响「怪物身上刷出来的装备」，不改原版/匠魂战利品表，也不影响玩家死亡掉落、实体拾取、交易等机制；三叉戟、重锤、海龟壳等特殊装备保留。
2. **补齐匠魂装备**：按数据包规则 roll 主手/副手/护甲，每件装备的各部件材料**独立随机**。

### 数据包：适配别的模组

规则放在 `data/<命名空间>/tinkersai/mob_gear/minecraft/`（原版怪物）或 `.../compat/<模组 id>/`（模组怪物）：

```json
{
  "priority": 5,
  "mobs": ["minecraft:zombie"],
  "mainhand": {
    "chance": 0.02,
    "items": [
      { "item": "tconstruct:sword", "weight": 5 },
      { "item": "tconstruct:pickaxe", "weight": 7 }
    ]
  },
  "armor": {
    "chance": 0.08,
    "sets": [
      { "set": "travelers", "weight": 3 },
      { "set": "plate", "weight": 1 }
    ]
  }
}
```

- `mobs`：实体 id 或 `#`+实体标签；`priority` 越大越优先，命中的第一条生效。
- `mainhand`/`offhand`：`chance` 是触发概率，`items` 按 `weight` 加权；只填空槽，所以匠魂自己的怪物装备不会被覆盖。
- `armor`：`chance` 是触发概率，整只怪只抽一套；`sets` 里写 `plate`（板甲）或 `travelers`（旅行者护甲）。
- 任何物品 id 都可以写（不只是匠魂物品）；未知 id 只跳过并警告。改完 `/reload` 生效，只影响之后生成的怪物。

### 材料等级权重

每个部件先在 tier 0–4 中按权重抽一个等级，再在该等级里随机取材料（某等级没有可用材料时向外就近找）。默认值等价于 **tier 0+1 = 50%、tier 2 = 30%、tier 3 = 17%、tier 4 = 3%**：

```toml
# config/tinkersai-common.toml
[materialTierWeights]
	tier0 = 25.0
	tier1 = 25.0
	tier2 = 30.0
	tier3 = 17.0
	tier4 = 3.0
```

权重是**相对值**，不需要加起来等于 100；全部改成 0 会回退到默认分布。修改后下次进入世界生效。

**关于翻译**：`.toml` 里的 `comment` 只能是英文；游戏内配置界面的选项名来自 `assets/tinkersai/lang/*.json` 的 `tinkersai.configuration.material_tier_weights.tierN`（已提供 `en_us` 与 `zh_cn`）。

### 远古工具

怪物身上的匠魂装备**不会**出现远古工具（battlesign / swasher / war_pick / melting_pan / minotaur_axe，即 `tconstruct:modifiable/ancient` 标签）；匠魂自己原有的怪物装备表保持不变。

## 功能二：匠魂远程武器的怪物 AI

原版 `RangedBowAttackGoal` 用 `item instanceof BowItem` 判断武器，匠魂的弓/弩是 `ModifiableLauncherItem`，永远识别不到。本模组给手持匠魂发射器的怪物挂上自己的 `TinkersRangedAttackGoal`：

- 复刻原版弓 AI 的走位/侧移/视线判断；蓄力时间按 `DRAW_SPEED` 换算。
- 弓：蓄满后 `releaseUsingItem`，由匠魂自己放箭。
- 弩：先 `releaseUsingItem` 上膛，再调用 `ModifiableCrossbowItem.fireCrossbow` 发射。
- 矛（`tconstruct:javelin` 等带 `throwing` 词条的工具）：像三叉戟一样举起蓄力，然后投出 `ThrownTool`；**不消耗**（不扣耐久、不从手上移除），投射物不可拾取。
- 弹药：`LivingGetProjectileEvent` 给手持匠魂发射器的怪物提供箭（无限箭）；玩家的弹药物理不受影响。
- 拾取到匠魂弓/弩/矛的怪物同样会获得该 AI（进入世界时按手持物挂接，读档不丢）。

蓄力动作需要 `ModifiableItem` 主动词条，所以引入了一个 Mixin（`mixin/ModifiableItemUseMixin`，只作用于匠魂自己的类，不涉及 SRG 映射问题）。
## 构建

需要 JDK 17：

```bash
./gradlew build
```

产物在 `build/libs/tinkersai-1.0.jar`。开发环境运行服务端：

```bash
./gradlew runServer
```

`run/mods/` 中需要放置 `Mantle-1.20.1-1.11.124.jar` 与 `TConstruct-1.20.1-3.12.1.237.jar`（已在 `build.gradle` 中以 `fg.deobf` 依赖，开发环境会自动带上）。
