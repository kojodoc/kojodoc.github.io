<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## MDA framework

* Mechanics → Entities, actions, and rules (what you (i.e. entities) can do)
* Dynamics → Player behavior & system response (what happens)
* Aesthetics → Feelings & experiences (how it feels)

## One-Page Game Design Template Items

1. Description — One sentence “elevator pitch.”
1. Game Layout Sketch — A rough sketch of what the game looks like.
1. Experience — Three short things we want the player to experience (player-promises). (Aesthetics)
1. Nouns (Entities) — six or less key "Things" (player, enemy types, obstacles, etc). (Mechanics)
1. Verbs (Actions) — five or less core "Actions" (move, dash, shoot, interact, etc). (Mechanics)
1. Core Loop — “Do → Earn → Unlock → So that …”. (Dynamics, caused by Mechanics)
1. Win/Lose — Win + Fail conditions. (Mechanics)
1. Session length target (e.g., 60–90 s). (Dynamic/Aesthetic outcome)
1. Tuning — Five or less named knobs with safe ranges to tune gameplay. (Mechanics (parameters) → Dynamics)
1. Progression — How the game progresses (across levels, for example). (Mechanics → Dynamics)
1. Success checks — Two to three measurable tests. (Valildate Aesthetics)

## A minimal process you can run
* Write a one-page design.
* Greybox prototype in quick time (no art): test control feel plus core-loop.
* Vertical slice: A playable version of final-quality gameplay proving a success criteria.
* Content ramp: build three levels; add visual polish.
* External playtests every 1–2 weeks; cut features that don’t impact success criteria.
* Lock content, focus on stability, performance, bugs, and, onboarding.

---

## One-Page Game Design — Example for "Hunted"

---

### 1) Description (Elevator Pitch)
- **In one sentence:** Minute-long arcade dodger: weave through bouncing hunters and survive 60 seconds.  
- **Genre/Subgenre:** Action → Arcade → Avoider (time-survival)  
- **Platform:** Desktop (Kojo/Scala)

---

### 2) Experience
- I win by mastering dodge control.  
- I can read danger — hunter bounces are predictable and fair.  
- I can finish a satisfying run in about a minute, with instant retries.

---

### 3) Nouns (Entities) (≤ 6)

| Name                     | Role (threat/ally/object)        | Readability notes (shape/color/size)                               |
|---|---|---|
| Player (square 40×40)    | Self/agent                        | Yellow fill, black outline; clear 40×40 hitbox                     |
| Hunter (square 40×40)    | Threat                            | Light-blue fill; constant velocity; bounces on walls               |
| Stage Border             | Obstacle / Lose on contact        | Dark green background; high-contrast edges                         |
| Timer UI                 | Goal/feedback                     | Visible countdown to 60 s; centered or top-left                    |
| Arena obstacles (Pillars)| Object (optional later)           | Static pillars create bounce lanes (readable shapes)               |

---

### 4) Verbs / Actions (≤ 5)
- **Primary verbs:** Move, Weave
- **Inputs:** Arrow keys (Up/Down/Left/Right)

---

### 5) Core Loop (one line)
**Do** precise dodges → **earn** survival seconds → **so that** you can survive till the end and win.

---

### 6) Win / Lose Conditions
- **Win:** Survive 60 s.  
- **Lose:** Collide with a hunter or the stage border.  
- **Session target:** 60s run; time-to-retry < 2 s.

---

### 7) Tuning (knobs you can change)

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
- First-win target: <= 5 tries (novice).  
- Fairness/readability: No unfair deaths.  
- Pace: median run 40s; time-to-retry < 2 s

