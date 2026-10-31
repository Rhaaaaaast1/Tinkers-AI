# Tinkers' AI — 1.20.1 / Forge

**Monster equipment and ranged combat AI for Tinkers' Construct.**
**为匠魂（Tinkers' Construct）添加怪物装备与远程战斗 AI。**

- GitHub: https://github.com/Rhaaaaaast1/Tinkers-AI
- License: MIT
- Version: **1.1.1**
- Minecraft: **1.20.1**
- Loader: **Forge 47.4.x**
- Optional: **Tinkers' Construct 3.12.1.237**, **Mantle 1.11.124**

> The 1.21.1 branch contains additional primitive-survival content. It is **not** included in 1.20.1.
> 1.21.1 分支包含额外的原始生存内容，**不会**同步到 1.20.1。

---

## Features / 功能

### Monster equipment / 怪物装备

- Newly spawned monsters receive Tinkers' Construct tools, weapons, and armor from config rules.
- Vanilla gear is removed only from the six equipment slots, controlled by `#tinkersai:stripped_monster_gear`.
- Tinkers' own mob equipment is preserved; only empty slots are filled.
- Each tool part rolls its material independently.

- 新生成怪物按配置获得匠魂工具、武器和护甲。
- 只从六个装备槽移除 `#tinkersai:stripped_monster_gear` 里的原版装备。
- 匠魂自带的怪物装备会保留，只填充空槽。
- 每件工具的各部位材料独立随机。

### Ranged AI / 远程 AI

- Bows charge and fire through Tinkers' Construct.
- Crossbows load first, then fire through Tinkers' Construct.
- Throwing weapons use a `ThrownTool` projectile; they are not consumed and lose no durability.
- Mob launchers receive infinite arrows.

- 弓通过匠魂蓄力并发射。
- 弩先上弦，再通过匠魂发射。
- 投掷武器使用 `ThrownTool` 弹射物，不消耗、不扣耐久。
- 怪物发射器获得无限箭。

### No loot changes / 不修改战利品表

This version does **not** edit vanilla or Tinkers' loot tables. Chest, dungeon, stronghold, shipwreck, and Nether fortress loot is untouched.

本版本**不修改**原版或匠魂战利品表。箱子、地牢、要塞、沉船、下界要塞的战利品都不受影响。

---

## Config / 配置

Path:

```text
config/tinkersai/mob_gear/
├── common.toml
├── minecraft/
│   ├── skeleton.toml
│   └── ... 14 files (1.20.1 has no bogged)
└── compat/          (empty by default)
```

First launch creates `common.toml`, 14 vanilla mob files, and an empty `compat/`. Existing files are never overwritten. `/reload` reloads the rules.

首次启动创建 `common.toml`、14 个原版怪物文件和空的 `compat/`。已有文件不会被覆盖，`/reload` 重载规则。

`common.toml`:

```toml
enabled = true
log_unknown_items = true
```

One mob file:

```toml
priority = 0
mobs = ["minecraft:skeleton", "#minecraft:skeletons"]

[mainhand]
chance = 1.0

[[mainhand.items]]
item = "tconstruct:longbow"
weight = 85

[[mainhand.items]]
item = "tconstruct:sword"
weight = 2

[offhand]
chance = 0.1

[[offhand.items]]
item = "tconstruct:plate_shield"
weight = 1

[armor]
chance = 0.1

[[armor.sets]]
set = "travelers"
weight = 3

[[armor.sets]]
set = "plate"
weight = 1
```

`mainhand`, `offhand`, and `armor` are optional. `set` is `plate`, `travelers`, or `none`.

`mainhand`、`offhand`、`armor` 都是可选的。`set` 可选 `plate`、`travelers` 或 `none`。

### Material tier weights / 材料等级权重

```text
config/tinkersai-common.toml
```

```toml
[materialTierWeights]
tier0 = 25.0
tier1 = 25.0
tier2 = 30.0
tier3 = 17.0
tier4 = 3.0
```

---

## Requirements / 环境

| Component | Version |
|---|---|
| Minecraft | 1.20.1 |
| Forge | 47.4.x |
| Java | 17 |
| Tinkers' Construct (optional) | 3.12.1.237 |
| Mantle (optional) | 1.11.124 |

Install on both client and server.

---

## Build / 构建

```bash
./gradlew build
```

Output:

```text
build/libs/tinkersai-1.1.1.jar
```

---

## License / 许可

MIT
