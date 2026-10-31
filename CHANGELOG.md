# Tinkers' AI — Changelog / 更新日志 (1.20.1 / Forge)

## 1.1.1 — 2026-10-31

### TOML config / TOML 配置

**English**

- Mob gear rules are now TOML under `config/tinkersai/mob_gear/`.
- Layout: `common.toml`, `minecraft/*.toml`, and an empty `compat/`.
- First launch writes 14 vanilla mob files (1.20.1 has no bogged); existing files are never overwritten.
- `/reload` reloads the TOML rules.
- The old JSON config format is no longer read.

**中文**

- 怪物装备配置改为 `config/tinkersai/mob_gear/` 下的 TOML。
- 结构：`common.toml`、`minecraft/*.toml` 和空的 `compat/`。
- 首次启动写入 14 个原版怪物文件（1.20.1 没有 bogged）；已有文件不会被覆盖。
- `/reload` 重新读取 TOML 规则。
- 不再读取旧 JSON 配置。

### Not included / 未同步内容

**English:** The 1.21.1 primitive-survival features are not included in 1.20.1: pebbles, flint pebbles, shards, plant fiber/cord, crude axes, plank gating, and the empty-hand tree rule.

**中文：** 1.21.1 的原始生存功能不会同步到 1.20.1：石子、燧石石子、碎片、植物纤维/植物绳、简陋斧、木板限制、禁止空手撸树。

### Behavior / 行为

**English**

- No vanilla or Tinkers' loot table changes.
- Vanilla equipment is removed only from newly spawned monsters' equipment slots, controlled by `#tinkersai:stripped_monster_gear`.
- Tinkers' own mob equipment tables are preserved; only empty slots are filled.

**中文**

- 不修改原版或匠魂战利品表。
- 只从新生成怪物的装备槽移除原版装备，范围由 `#tinkersai:stripped_monster_gear` 控制。
- 匠魂自带的怪物装备表会保留，只填充空槽。

### File / 文件

| Item | Value |
|---|---|
| Jar | `tinkers-ai-1.20.1-1.1.1.jar` |
| Internal name | `tinkersai-1.1.1.jar` |
| Size | 61,176 bytes (TOML build) |
| SHA-256 | `3781E951BA19AF525A05BEBE9C15045673CCB1DB0497D232EA1DCCA0F8EB4B04` |
| Loader | Forge 47.4.x |
| Optional | Tinkers' Construct 3.12.1.237, Mantle 1.11.124 |

---

## 1.1.0 — Base release / 基础版本

**English**

- Newly spawned monsters receive Tinkers' Construct tools/armor.
- Each tool part rolls its material independently; tier weights are configurable.
- Ranged AI for Tinkers' bows, crossbows, and throwing weapons.
- Mobs have infinite arrows; thrown weapons are not consumed and lose no durability.

**中文**

- 新生成怪物获得匠魂工具/护甲。
- 每件工具的各部位材料独立随机；材料等级权重可配置。
- 匠魂弓、弩、投掷武器的怪物远程 AI。
- 怪物无限箭；投掷武器不消耗、不扣耐久。
