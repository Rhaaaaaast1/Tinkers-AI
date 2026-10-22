# Tinkers' Addition

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

## 功能一：怪物身上的匠魂装备

怪物生成（`EntityJoinLevelEvent`，此时原版与匠魂自己的装备都已完成 roll）时：

1. **剥离原版装备**：从六个装备槽中移除木/石/铁/金/钻石/下界合金的工具与武器、皮革/锁链/铁/金/钻石/下界合金的护甲，以及盾牌、弓、弩、剪刀、打火石。
   - 只影响「怪物身上刷出来的装备」，不改原版/匠魂战利品表，也不影响玩家死亡掉落、实体拾取、交易等机制；三叉戟、重锤、海龟壳等特殊装备保留。
2. **补齐匠魂装备**：按生物类型 roll 武器/副手/护甲，每件装备的各部件材料**独立随机**。

| 生物 | 主手 | 副手 | 护甲 |
| --- | --- | --- | --- |
| 骷髅 / 流浪者 / 沼骸 | 长弓 100% | – | 板甲 30% |
| 凋灵骷髅 | 剑/劈刀 100% | – | 板甲 50% |
| 掠夺者 | 弩 100% | – | – |
| 卫道士 | 手斧/板斧 100% | – | 板甲 30% |
| 幻术师 | 长弓 100% | – | – |
| 恼鬼 | 匕首/剑 100% | – | – |
| 猪灵 | 弩/剑 100% | – | 板甲 35% |
| 猪灵蛮兵 | 手斧/板斧 100% | – | 板甲 20% |
| 僵尸猪灵 | 剑 100% | – | 板甲 25% |
| 僵尸 / 尸壳 | – | – | 旅行者护甲 25% |
| 僵尸村民 | – | – | 板甲 30% |
| 溺尸 | – | 匠魂匕首（随机） | 旅行者护甲 25% |

武器对齐原版：空手的生物（僵尸、唤魔者、女巫、劫掠兽等）不会凭空拿到武器，只可能获得护甲。

### 材料等级权重

每个部件先在 tier 0–4 中按权重抽一个等级，再在该等级里随机取材料（某等级没有可用材料时向外就近找）。默认值等价于 **tier 0+1 = 50%、tier 2 = 30%、tier 3 = 17%、tier 4 = 3%**：

```toml
# config/tinkersaddition-common.toml
[materialTierWeights]
	tier0 = 25.0
	tier1 = 25.0
	tier2 = 30.0
	tier3 = 17.0
	tier4 = 3.0
```

权重是**相对值**，不需要加起来等于 100（`25/25/30/17/3` 与 `0.25/0.25/0.30/0.17/0.03` 等价）；全部改成 0 会回退到默认分布。修改后下次进入世界生效。

**关于翻译**：Forge 的配置文件本身（`.toml`）不支持翻译，写进文件里的 `comment` 只能是英文。可以翻译的是**游戏内配置界面**显示的选项名——它读取语言文件 `assets/tinkersaddition/lang/*.json` 里的键 `tinkersaddition.configuration.material_tier_weights.tierN`（已提供 `en_us` 与 `zh_cn`）。要加别的语言，复制 `zh_cn.json` 改文件名即可。

### 远古工具

怪物身上的匠魂装备**不会**出现远古工具（battlesign / swasher / war_pick / melting_pan / minotaur_axe，即 `tconstruct:modifiable/ancient` 标签）；匠魂自己原有的怪物装备表保持不变。

## 功能二：匠魂远程武器的怪物 AI

原版 `RangedBowAttackGoal` 用 `item instanceof BowItem` 判断武器，匠魂的长弓/弩是 `ModifiableLauncherItem`，永远识别不到。本模组为手持匠魂发射器的怪物加装自己的 `TinkersRangedAttackGoal`：

- 复刻原版弓 AI 的走位/侧移/视线判断；蓄力时间按 `DRAW_SPEED` 换算（弩更慢）。
- 弓：蓄满后调用 `releaseUsing`，由匠魂自己完成放箭。
- 弩：先 `releaseUsing` 上膛，再调用 `ModifiableCrossbowItem.fireCrossbow` 发射。
- 弹药：通过 `LivingGetProjectileEvent` 给手持匠魂发射器的怪物提供箭（无限箭）；玩家的弹药物理不受影响。
- 拾取到匠魂弓/弩的怪物同样会获得该 AI（进入世界时按手持物重新挂接，读档后也不会丢）。

## 构建

需要 JDK 17：

```bash
./gradlew build
```

产物在 `build/libs/tinkersaddition-1.0.jar`。开发环境运行服务端：

```bash
./gradlew runServer
```

`run/mods/` 中需要放置 `Mantle-1.20.1-1.11.124.jar` 与 `TConstruct-1.20.1-3.12.1.237.jar`（已在 `build.gradle` 中以 `fg.deobf` 依赖，开发环境会自动带上）。
