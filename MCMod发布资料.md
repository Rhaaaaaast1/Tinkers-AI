# Tinkers' AI — MC百科发布资料

## 基本信息

| 项目 | 内容 |
| --- | --- |
| 中文名 | 匠魂 AI |
| 英文名 | Tinkers' AI |
| 模组 ID | `tinkersai` |
| 版本 | 1.1.0 |
| Minecraft | 1.20.1 |
| 加载器 | Forge 47.4.28 |
| 客户端/服务端 | 双端 |
| 许可证 | MIT |
| 作者 | rhaaaaaast1 |
| 仓库 | https://github.com/Rhaaaaaast1/Tinkers-AI |
| 发布文件 | `build/libs/tinkers-ai-1.1.0.jar` |
| SHA-256 | `FE8FD30010E1941807DB76EAF3AFD49147844A534BAA02529CDE78AFC379E5A7` |
| 文件大小 | 62,622 字节 |

## 一句话简介

让怪物按数据包规则装备匠魂工具与护甲，并让骷髅、掠夺者等怪物真正会用匠魂弓、弩和投掷武器。

## 详细描述

Tinkers' AI 是 Tinkers' Construct（匠魂）的轻量扩展，不新增物品或方块，专注于两件事：

1. **怪物生成时的匠魂装备**
   - 怪物生成时，按数据包规则移除原版工具/武器/护甲，并替换为匠魂装备。
   - 支持主手、副手、头盔、胸甲、护腿、靴子六个槽位。
   - 每件装备的每个部件材料独立随机，材料等级权重可在配置中调整。
   - 不会覆盖匠魂自己生成的怪物装备；远古工具不会出现在怪物身上。
   - 默认只影响新生成的怪物，不修改战利品表。

2. **匠魂远程武器的怪物 AI**
   - 原版骷髅只认 `BowItem`，掠夺者只认 `CrossbowItem`，匠魂的弓/弩继承的是 `ProjectileWeaponItem`，所以原版 AI 不会使用。
   - 本模组为手持匠魂发射器的怪物挂载自定义远程攻击 AI：
     - 弓：蓄力后由匠魂自身发射。
     - 弩：上膛后调用匠魂弩的发射逻辑。
     - 标枪等带投掷词条的工具：举起蓄力后投出，不消耗耐久、不移除手持物品。
   - 怪物无限箭矢；玩家箭矢逻辑不受影响。
   - 已生成的怪物重新捡起匠魂远程武器时也会获得对应 AI。

## 数据包与配置

怪物装备规则位于：

```
data/<命名空间>/tinkersai/mob_gear/minecraft/
data/<命名空间>/tinkersai/mob_gear/compat/<模组id>/
```

示例：

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

材料等级权重位于 `config/tinkersai-common.toml` 的 `[materialTierWeights]`；修改后下次进入世界生效。

## 依赖

- **必需**：Forge 47.x、Minecraft 1.20.1。
- **可选**：Tinkers' Construct 3.12.1.237、Mantle 1.11.124。
- 未安装匠魂时模组仍可加载，只是不启用装备与远程 AI 逻辑。

## 安装

1. 安装 Minecraft 1.20.1 + Forge 47.4.28（或同系列 47.x）。
2. 将 `tinkers-ai-1.1.0.jar` 放入 `mods`。
3. 可选：同时安装 Tinkers' Construct 与 Mantle。
4. 启动游戏。

## 备注

- 本模组不包含自定义纹理或模型。
- 服务端与客户端都需要安装。
- 数据包规则可用 `/reload` 重载，只影响之后生成的怪物。

## MC百科标签建议

`Forge`、`1.20.1`、`辅助`、`战斗`、`怪物`、`装备`、`AI`、`Tinkers' Construct`、`匠魂`、`服务端`、`客户端`
