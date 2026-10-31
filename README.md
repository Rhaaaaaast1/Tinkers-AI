# Tinkers' AI

**Monster gear and ranged combat AI for Tinkers' Construct.**  
**为匠魂（Tinkers' Construct）添加怪物装备与远程战斗 AI。**

[![GitHub](https://img.shields.io/badge/GitHub-Tinkers--AI-181717?logo=github)](https://github.com/Rhaaaaaast1/Tinkers-AI)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](#license--许可证)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.20.1-62B47A)](#requirements--环境)
[![Forge](https://img.shields.io/badge/Forge-47.x-DFA86A)](#requirements--环境)

Tinkers' AI is a lightweight, data-driven addon for **Minecraft 1.20.1 / Forge**. It gives newly spawned monsters Tinkers' Construct equipment and teaches them to use Tinkers' bows, crossbows, and throwing weapons. Tinkers' Construct and Mantle are optional dependencies: without them the mod loads normally and simply does nothing.

Tinkers' AI 是一个面向 **Minecraft 1.20.1 / Forge** 的轻量、数据驱动的匠魂附属模组。它会让新生成的怪物装备匠魂工具与护甲，并让怪物学会使用匠魂的弓、弩和投掷武器。匠魂与 Mantle 是可选依赖：未安装时模组仍可正常加载，只是不会启用相关功能。

> This README is bilingual. Each section contains English first, followed by Simplified Chinese.  
> 本文档为中英对照，每节先英文、后简体中文。

---

## Overview / 概述

Tinkers' AI has two independent features:

1. **Monster equipment** — replaces only the vanilla gear listed in `#tinkersai:stripped_monster_gear` with Tinkers' Construct tools and armor, following config rules.
2. **Ranged AI** — gives monsters holding Tinkers' launchers or throwing weapons a custom ranged attack goal, because vanilla AI only recognises `BowItem` and `CrossbowItem`.

Tinkers' AI 有两个独立功能：

1. **怪物装备**：按照配置文件，把 `#tinkersai:stripped_monster_gear` 中列出的原版装备替换为匠魂工具与护甲。
2. **远程 AI**：让手持匠魂发射器或投掷武器的怪物获得自定义远程攻击 AI，因为原版 AI 只识别 `BowItem` 和 `CrossbowItem`。

The mod does **not** edit vanilla or Tinkers' loot tables, does **not** change player drops, and does **not** touch Tinkers' own monster equipment tables.

本模组**不会**修改原版或匠魂的战利品表，**不会**改变玩家掉落，也**不会**改动匠魂自带的怪物装备表。

---

## Features / 功能

### 1. Monster equipment / 怪物装备

**English**

- Runs when a mob joins the level, after vanilla and Tinkers' Construct have rolled their own equipment.
- Removes only the vanilla tools, weapons, and armor listed in `#tinkersai:stripped_monster_gear` from the six equipment slots.
- Rolls Tinkers' gear from config rules and fills **empty slots only**, so Tinkers' own mob equipment is preserved.
- Rolls the material of **each tool part independently**.
- The bundled rules do not contain ancient tools (`#tconstruct:modifiable/ancient`); a config file can add them intentionally.
- Supports any item ID in the rules, not only Tinkers' items; unknown IDs are skipped with a warning.

**中文**

- 在怪物进入世界时执行，此时原版与匠魂都已经完成各自装备的随机。
- 只从六个装备槽中移除 `#tinkersai:stripped_monster_gear` 里列出的原版工具、武器和护甲。
- 按配置文件随机匠魂装备，并且**只填充空槽**，因此匠魂自带的怪物装备会被保留。
- 每件工具的各部件材料**独立随机**。
- 内置规则不包含远古工具（`#tconstruct:modifiable/ancient`）；配置文件可以有意加入它们。
- 规则里可以写任意物品 ID，不限于匠魂物品；未知 ID 会跳过并在日志中警告。

### 2. Ranged combat AI / 远程战斗 AI

**English**

- **Bows:** the mob charges the bow, then releases it; Tinkers' Construct fires the arrow.
- **Crossbows:** the mob loads the crossbow first, then fires it through Tinkers' Construct.
- **Throwing weapons** (`javelin` and other tools with the `throwing` modifier): the mob raises and throws a `ThrownTool`, similar to a trident. The weapon is **not consumed**, does not lose durability, and the projectile cannot be picked up.
- Mobs holding a Tinkers' launcher receive **infinite arrows** when they shoot; player ammunition is unaffected.
- The AI is attached when the mob joins the world; items picked up later do not add a new goal.

**中文**

- **弓**：怪物拉弓，蓄满后释放，由匠魂负责发射箭。
- **弩**：怪物先上膛，再通过匠魂发射。
- **投掷武器**（`javelin` 以及其他带 `throwing` 词条的工具）：怪物举起并投出 `ThrownTool`，类似三叉戟。武器**不会被消耗**，不扣耐久，投出的实体不可拾取。
- 手持匠魂发射器的怪物射击时会获得**无限箭**；玩家的箭矢不受影响。
- AI 在怪物进入世界时挂载；之后捡起物品不会新增 AI。
- 怪物之后捡起匠魂发射器时，也会自动挂上该 AI。

### 3. Data-driven rules / 数据驱动规则

**English**

- Define which mobs receive which weapons, offhand items, and armor sets.
- Use entity IDs or entity tags.
- Add compatibility rules for modded mobs without writing Java.
- Rules are reloaded with `/reload` and only affect mobs spawned afterwards.

**中文**

- 可以定义哪些怪物获得哪些主手武器、副手物品和护甲套装。
- 支持实体 ID 或实体标签。
- 不需要写 Java 就能为模组怪物添加兼容规则。
- 规则通过 `/reload` 重载，只影响之后生成的怪物。

---

## Requirements / 环境

| Component / 组件 | Version / 版本 | Required / 必需 |
| --- | --- | --- |
| Minecraft | **1.20.1** | Yes / 是 |
| Forge | **47.x** (built with 47.4.28) | Yes / 是 |
| Java | **17** | Yes / 是 |
| Tinkers' Construct | **3.12.1+** | Optional / 可选 |
| Mantle | **1.11+** | Optional / 可选 |

**English:** Tinkers' Construct and Mantle are optional. Without them, the mod loads but registers no equipment or AI behaviour. Install the mod on both the client and the server.

**中文：** 匠魂与 Mantle 是可选依赖。未安装时模组可以加载，但不会注册装备或 AI 功能。客户端和服务端都需要安装本模组。

---

## Installation / 安装

**English**

1. Install **Minecraft 1.20.1** and **Forge 47.x**.
2. Put `tinkers-ai-1.1.0.jar` into the `mods` folder.
3. Optionally install **Tinkers' Construct 3.12.1+** and **Mantle 1.11+**.
4. Launch the game. The mod works on both single-player and dedicated servers.

**中文**

1. 安装 **Minecraft 1.20.1** 与 **Forge 47.x**。
2. 将 `tinkers-ai-1.1.0.jar` 放入 `mods` 文件夹。
3. 可选安装 **Tinkers' Construct 3.12.1+** 与 **Mantle 1.11+**。
4. 启动游戏。单人游戏与专用服务器均可使用。

---

## How it works / 工作原理

**English**

- Equipment replacement runs on `EntityJoinLevelEvent`, after `Mob#finalizeSpawn` has finished rolling vanilla and Tinkers' equipment.
- The handler strips only the items in the `#tinkersai:stripped_monster_gear` item tag, then rolls the matching config rule.
- A small Mixin on Tinkers' `ModifiableItem` supplies the active-use animation needed by the ranged goal; it only touches Tinkers' own class.
- A `LivingGetProjectileEvent` hook supplies arrows to mobs holding Tinkers' launchers.

**中文**

- 装备替换在 `EntityJoinLevelEvent` 中执行，此时 `Mob#finalizeSpawn` 已经完成原版与匠魂装备的随机。
- 处理器只移除 `#tinkersai:stripped_monster_gear` 物品标签中的物品，然后按匹配到的配置随机装备。
- 一个作用于匠魂 `ModifiableItem` 的小型 Mixin 提供远程 AI 所需的主动使用动画；只涉及匠魂自己的类。
- 通过 `LivingGetProjectileEvent` 为手持匠魂发射器的怪物提供箭。

---

## Config rules / 配置文件规则

### Where to put rules / 规则放在哪里

**English**

- Vanilla mobs: `config/tinkersai/mob_gear/minecraft/` (auto-generated on first launch)
- Modded mobs: `config/tinkersai/mob_gear/compat/<modid>/`

The file name can be anything; every `.json` in these folders is loaded.

**中文**

- 原版怪物：`config/tinkersai/mob_gear/minecraft/`（首次启动自动生成）
- 模组怪物：`config/tinkersai/mob_gear/compat/<模组 ID>/`

文件名任意；这些目录下的每个 `.json` 都会被加载，修改后用 `/reload` 重读。

### Example / 示例

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
  "offhand": {
    "chance": 0.05,
    "items": [
      { "item": "tconstruct:plate_shield", "weight": 1 }
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

### Fields / 字段

| Field / 字段 | Type / 类型 | Description / 说明 |
| --- | --- | --- |
| `priority` | integer | Higher priority wins when several rules match the same mob. 多条规则命中同一怪物时，优先级高的生效。 |
| `mobs` | string array | Entity IDs or `#` entity tags. 实体 ID 或 `#` 实体标签。 |
| `mainhand` / `offhand` | object | `chance` (0–1) and weighted `items`. `chance` 为触发概率（0–1），`items` 按 `weight` 加权。 |
| `armor` | object | `chance` and weighted `sets`. `chance` 为触发概率，`sets` 按 `weight` 加权。 |
| `sets[].set` | string | `plate` (plate armor) or `travelers` (travelers' gear). `plate`（板甲）或 `travelers`（旅行者护甲）。 |

**English**

- Rules only fill empty slots, so a mob that already has Tinkers' gear keeps it.
- Each armor piece has a small chance to be skipped, so partial sets are possible.
- `mainhand` and `offhand` can use any item ID, including non-Tinkers items.
- After editing, run `/reload`. Existing mobs are not retrofitted.

**中文**

- 规则只填充空槽，已经有匠魂装备的怪物会保留原装备。
- 每件护甲有少量概率被跳过，因此可能只生成部分套装。
- `mainhand` 与 `offhand` 可以写任意物品 ID，包括非匠魂物品。
- 修改后执行 `/reload`；已经生成的怪物不会被追溯修改。

---

## Configuration / 配置

**English**

The material tier weights are stored in `config/tinkersai-common.toml`:

```toml
[materialTierWeights]
	tier0 = 25.0
	tier1 = 25.0
	tier2 = 30.0
	tier3 = 17.0
	tier4 = 3.0
```

- Each tool part first rolls a tier, then picks a random material within that tier.
- Weights are **relative**; they do not need to add up to 100.
- Defaults: tier 0 + tier 1 = 50%, tier 2 = 30%, tier 3 = 17%, tier 4 = 3%.
- Setting every weight to `0` falls back to the default distribution.
- Changes apply on the next config load / world join.

**中文**

材料等级权重位于 `config/tinkersai-common.toml`：

```toml
[materialTierWeights]
	tier0 = 25.0
	tier1 = 25.0
	tier2 = 30.0
	tier3 = 17.0
	tier4 = 3.0
```

- 每个工具部件先抽取等级，再在该等级内随机材料。
- 权重是**相对值**，不需要加起来等于 100。
- 默认分布：tier 0 + tier 1 = 50%，tier 2 = 30%，tier 3 = 17%，tier 4 = 3%。
- 所有值都设为 `0` 时会回退到默认分布。
- 修改后下次加载配置/进入世界生效。

> The generated `.toml` comments are English only. In-game option names are translated through `assets/tinkersai/lang/*.json`.  
> 生成的 `.toml` 注释只有英文；游戏内配置界面的选项名通过 `assets/tinkersai/lang/*.json` 翻译。

---

## Compatibility and limitations / 兼容性与限制

**English**

- **Tinkers' Construct is optional.** Without it, no Tinkers' equipment or ranged AI is registered.
- **No loot table edits.** Vanilla and Tinkers' loot tables, player drops, trades, and chest loot are untouched.
- **Ancient tools are opt-in.** The bundled rules exclude Tinkers' `#tconstruct:modifiable/ancient` tools; a config file can add them.
- **Only new mobs.** Mobs already in the world are not retrofitted; only their ranged AI may be reattached when they are loaded.
- **Other mods may override gear.** If another mod replaces a mob's equipment after it joins the level, that mod's result wins.
- **Client and server.** Install on both sides; the server controls equipment and AI.
- This is an **unofficial addon**. It is not affiliated with or endorsed by the Tinkers' Construct team.

**中文**

- **匠魂是可选依赖。** 未安装时不会注册匠魂装备或远程 AI。
- **不修改战利品表。** 原版与匠魂的战利品表、玩家掉落、交易和箱子战利品都不会被改动。
- **远古工具需手动加入。** 内置规则排除了 `#tconstruct:modifiable/ancient` 中的匠魂工具；配置文件可以加入它们。
- **只影响新怪物。** 已经生成的怪物不会被追溯修改；只会在加载时尝试重新挂载远程 AI。
- **可能被其他模组覆盖。** 如果其他模组在怪物进入世界后替换装备，以那个模组的结果为准。
- **客户端与服务端都要装。** 服务端负责装备与 AI。
- 这是**非官方附属模组**，与匠魂官方团队无关，也未获得其背书。

---

## Build / 构建

**English**

Requires **JDK 17**:

```bash
./gradlew build
```

The output jar is:

```text
build/libs/tinkers-ai-1.1.0.jar
```

For a development server:

```bash
./gradlew runServer
```

Put `Mantle-1.20.1-1.11.124.jar` and `TConstruct-1.20.1-3.12.1.237.jar` into `run/mods/`; the development dependencies are already declared in `build.gradle`.

**中文**

需要 **JDK 17**：

```bash
./gradlew build
```

输出文件：

```text
build/libs/tinkers-ai-1.1.0.jar
```

启动开发服务器：

```bash
./gradlew runServer
```

将 `Mantle-1.20.1-1.11.124.jar` 与 `TConstruct-1.20.1-3.12.1.237.jar` 放入 `run/mods/`；开发依赖已在 `build.gradle` 中声明。

---

## License / 许可证

**English:** This project is licensed under the [MIT License](LICENSE).

**中文：** 本项目使用 [MIT 许可证](LICENSE)。

---

## Links / 链接

- GitHub: https://github.com/Rhaaaaaast1/Tinkers-AI
- Issues: https://github.com/Rhaaaaaast1/Tinkers-AI/issues
- Tinkers' Construct: https://github.com/SlimeKnights/TinkersConstruct
- Mantle: https://github.com/SlimeKnights/Mantle

---

**English:** If you find a bug, please include the Minecraft version, Forge version, Tinkers' Construct version, and `latest.log` in the issue.

**中文：** 反馈问题时请附上 Minecraft 版本、Forge 版本、匠魂版本和 `latest.log`。
