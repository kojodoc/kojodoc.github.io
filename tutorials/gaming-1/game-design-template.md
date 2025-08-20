<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

*Note -- this page is a work in progress...*

## One-Page Game Design Template Items

1. Description — One sentence “elevator pitch.”
1. Experience / Aesthetics / Pillars — Three short, player-promise bullets.
1. Nouns (Entities) — six or less key objects (player, enemy types, obstacles, etc).
1. Verbs (Actions) — five or less core actions (move, dash, shoot, interact, etc).
1. Core Loop — “Do → Earn → Unlock → So that …” in one line.
1. Win/Lose — Win + Fail conditions + session length (e.g., 60–90 s).
1. Tuning — Five or less named knobs with safe ranges to tune gameplay.
1. Progression — How the game progresses (across levels, for example).
1. Success checks — Two to three measurable tests.

## A minimal process you can run
* Write a one-page design.
* Greybox prototype in 3–7 days (no art): test control feel + loop.
* Vertical slice: 5–10 min of final-quality gameplay proving a pillar.
* Content ramp: build 3 levels; add UX polish.
* External playtests every 1–2 weeks; cut features that don’t move KPIs or pillars.
* Lock content, focus on perf, bugs, onboarding, and accessibility.

---

## One-Page Game Design — Example for "Hunted"

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
**Do** precise dodges → **earn** survival seconds → **unlock** harder presets **so that** you beat your best run.

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
- Enhancement ideas

---

### 9) Success Checks (make it testable)
- First-win target: ≤ 5 tries (novice).  
- Fairness/readability: “unfair deaths” < 5% (post-run prompt).  
- Pace: median run 60–90 s; time-to-retry < 2 s; ≥ 3 runs/session.

