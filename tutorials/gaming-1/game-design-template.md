<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

Here's a one-page template for helping you design games:

## One-Page Game Design Template Items

1. Description — 1 sentence “elevator pitch.”
1. Experience / Aesthetics / Pillars — 3 short, player-promise bullets.
1. Nouns (Entities) — ≤6 key objects (player, enemy types, obstacles, items).
1. Verbs (Actions) — ≤5 core actions (move, dash, shoot, interact…).
1. Core Loop — “Do → Earn → Unlock → So that …” in one line.
1. Win/Lose — Win + fail states + session length (e.g., 60–90 s).
1. Tuning — 5 named knobs with safe ranges (e.g., hunterSpeedMax 120–220).
1. Progression — Short (run) / Mid (meta) / Long (mastery) in one line.
1. Success checks — 2–3 measurable tests (e.g., “first win ≤5 tries; unfair-death reports <5%”).

## One-Page Game Design — Example (Kojo: Avoid the Hunters)

*Pre-filled example of the Grade 10 one-page template using the Kojo hunted game.*

---

### 1) Description (Elevator Pitch)
- **In one sentence:** Minute-long arcade dodger: weave through bouncing hunters and survive 60 seconds.  
- **Genre/Subgenre:** Action → Arcade → Avoider (time-survival)  
- **Platform:** Desktop (Kojo/Scala)

---

### 2) Experience / Aesthetics / Pillars (3 player promises)
- I win by mastering dodge control, not grinding stats.  
- I can read danger—hunter bounces are predictable and fair.  
- I can finish a satisfying run in about a minute, with instant retries.

---

### 3) Nouns / Characters / Entities (≤ 6)

| Name                     | Role (threat/ally/object)        | Readability notes (shape/color/size)                               |
|---|---|---|
| Player (square 40×40)    | Self/agent                        | Yellow fill, black outline; clear 40×40 hitbox                     |
| Hunter (square 40×40)    | Threat                            | Light-blue fill; constant velocity; bounces on walls               |
| Stage Border             | Obstacle / Lose on contact        | Dark green background; high-contrast edges                         |
| Timer UI                 | Goal/feedback                     | Visible countdown to 60 s; centered or top-left                    |
| Arena obstacles (Pillars)| Object (optional later)           | Static pillars create bounce lanes (readable shapes)               |

---

### 4) Verbs / Actions (≤ 5)
- **Primary verbs:** Move, Weave, Bait  
- **Inputs:** Arrow keys (Up/Down/Left/Right)

---

### 5) Core Loop (one line)
**Do** precise dodges → **earn** survival seconds → **unlock** harder presets/arenas **so that** you beat your best run.

---

### 6) Win / Lose Conditions
- **Win:** Survive 60 s.  
- **Lose:** Collide with a hunter or the stage border.  
- **Session target:** 60–90 s runs; time-to-retry < 2 s.

---

### 7) Tuning (knobs students can change)

| Knob              | What it changes                                   | Default | Safe range |
|---|---|---:|---|
| `nh` (hunterCount) | Crowd pressure: number of hunters on screen       | 5       | 3–8        |
| `hunterSpeedMax`   | Peak threat speed / late-run chaos                | 200     | 120–240    |
| `hunterSpeedMin`   | Baseline pressure / early-run pace                | 50      | 30–120     |
| `playerSpeed`      | Control headroom and escape ability               | 200     | 160–240    |
| `survivalWinTime`  | Run length target                                 | 60      | 45–90      |

*Tip: Change one knob at a time. Predict → Play → Observe → Explain.*

---

### 8) Progression (short / mid / long)
- **Short (in a run/level):** Survive bounce waves; learn readable lanes; no upgrades.  
- **Mid (over sessions):** Unlock difficulty presets (Breeze/Default/Storm) and arenas (Open Field → Pillars → Corridors).  
- **Long (mastery/collection/story):** Optimize paths, increase near-misses, chase personal bests.

---

### 9) Success Checks (make it testable)
- First-win target: ≤ 5 tries (novice).  
- Fairness/readability: “unfair deaths” < 5% (post-run prompt).  
- Pace: median run 60–90 s; time-to-retry < 2 s; ≥ 3 runs/session.

