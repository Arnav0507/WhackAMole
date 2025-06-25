# 🐹 Whacking Moles Game (Football Edition)

An Android game where you tap on randomly appearing footballs (moles!) as fast as you can to score points. Watch out — not all moles are helpful! Some are golden and worth more, some are referees that take time away. The game ends after 60 seconds with your final score.

---

## 🎮 Gameplay

- 9 mole slots randomly display one of:
  - 🏈 **Football** — tap to score +1
  - 🏆 **Golden Football** — tap to score +5
  - ❌ **Referee** — tap and lose 5 seconds
- Moles appear and disappear at random intervals
- Tap quickly before they disappear!
- Each tap also adds the image to a dynamic grid trail on screen
- Game lasts for 60 seconds, and displays your final score at the end

---

## 🛠 Tech Stack

- **Java** (Android)
- `AppCompatActivity`, `ConstraintLayout`
- `Timer` + `TimerTask` (multi-threaded mole logic)
- `ScaleAnimation` for entry/exit effects
- `Intent` for passing score between Activities
- `ConstraintSet` for dynamically adding tapped mole images

---

## 🧠 Features

- Clean Activity flow: `MainActivity` → `GameActivity` → `FinishActivity`
- Responsive UI with animations
- Dynamic layout updates using ConstraintLayout
- Probability logic for randomized mole types
- Simple and fun feedback loop

---

## 🚀 Getting Started

### 📦 Requirements

- Android Studio (Arctic Fox or newer recommended)
- Android SDK 30+

### ▶️ Run It Locally

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/WhackingMolesGame.git
