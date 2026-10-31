# Tinkers' AI — Changelog / 更新日志 (1.20.1 / Forge)

## 1.1.1 — 2026-10-31

### Config-folder migration / 配置文件迁移

**English**

- Mob gear rules moved from datapacks to `config/tinkersai/mob_gear/`.
- First launch generates 14 vanilla mob configs (1.20.1 has no bogged).
- `minecraft/` holds vanilla mobs; `compat/` holds modded mobs.
- Existing files are never overwritten; use `/reload` after editing.
- The old `data/<namespace>/tinkersai/mob_gear/` is no longer read.
- Version: `1.1.0` → `1.1.1`.

**中文**

- 怪物装备规则从数据包迁移到 `config/tinkersai/mob_gear/`。
- 首次启动自动生成 14 个原版怪物配置（1.20.1 没有 bogged）。
- `minecraft/` 放原版怪物，`compat/` 放其他模组怪物。
- 已有文件不会被覆盖；修改后用 `/reload` 重载。
- 旧的 `data/<namespace>/tinkersai/mob_gear/` 不再读取。
- 版本：`1.1.0` → `1.1.1`。

### Behavior / 行为确认

**English**

- No vanilla or Tinkers' loot table changes.
- Chest, dungeon, stronghold, and shipwreck loot is untouched.
- Only newly spawned monsters' equipment slots are cleared,
  controlled by `#tinkersai:stripped_monster_gear`.
- Tinkers' own mob equipment tables are preserved; only empty slots are filled.

**中文**

- 不修改原版或匠魂战利品表。
- 箱子、地牢、要塞、沉船等战利品不受影响。
- 只清空新生成怪物的装备槽，
  范围由 `#tinkersai:stripped_monster_gear` 控制。
- 匠魂自己的怪物装备表会被保留；只填充空槽。

### File / 文件

| Item / 项目 | Value / 值 |
|---|---|
| Jar | `tinkers-ai-1.20.1-1.1.1.jar` |
| Internal name / 内部文件名 | `tinkersai-1.1.1.jar` |
| Size / 大小 | 70,623 bytes |
| SHA-256 | `7c6e4a39739170c853ae806347ccce7a8f67c8caca5ccb66b77680ae29108573` |
| Loader / 加载器 | Forge 47.4.x |
| Optional / 可选依赖 | Tinkers' Construct 3.12.1.237, Mantle 1.11.124 |

### Not included / 未同步内容

**English:** The 1.21.1 survival features are not included and will not be synced to 1.20.1: pebbles/flint pebbles, plant fiber/string, crude stone/flint axes, empty-hand tree-punching prevention.

**中文：** 1.21.1 的生存功能不会同步到 1.20.1：石子/燧石石子、植物纤维/植物绳、简陋石斧/燧石斧、禁止空手撸树。

---

## 1.1.0 — Base release / 基础版本

**English**

- Newly spawned monsters receive Tinkers' Construct tools/armor.
- Each tool part rolls its material independently; tier weights are configurable.
- Ranged AI for Tinkers' bows, crossbows, and throwing weapons.
- Mobs have infinite arrows; thrown weapons are not consumed and lose no durability.
- Rules were datapack-driven in 1.1.0 (moved to config files in 1.1.1).

**中文**

- 新生成怪物获得匠魂工具/护甲。
- 每件工具的各部件材料独立随机；材料等级权重可配置。
- 匠魂弓、弩、投掷武器的怪物远程 AI。
- 怪物无限箭矢；投掷武器不消耗、不扣耐久。
- 1.1.0 的规则由数据包驱动（1.1.1 起改为配置文件）。

---

## Compatibility / 兼容性

**English:** Tinkers' Construct / Mantle are optional; without them the mod loads but does nothing. Only new mobs are affected. Install on client and server.

**中文：** 匠魂/Mantle 是可选依赖；未安装时模组正常加载但不启用功能。只影响新怪物。客户端与服务端都需要安装。
