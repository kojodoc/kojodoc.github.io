<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Game refinement project 1 - Dino

This activity has the following desired goals:
* Learning to understand a given game and refine it using images and sounds (**M, T**).
* Practice with exporting a game as a web-app (**M, T**).

---

### Steps to be followed:
1. Understand the game below.
1. Refine the game-play (add birds, increase obstacle speed as time passes, etc).
1. Add background and character images to the game to make it more attractive.
1. Add sounds to the game to make it more attractive.
1. Implement any other ideas for improvement that you can come up with.

---

### Game starter code

The code for the game is shown below. Study it to fully understand how the game works.

```scala
// #exec template /picgaming

cleari()
drawStage(white)
val cb = canvasBounds

val us = Picture.rectangle(30, 60)
us.setPosition(cb.x + 150, cb.y + 0)

draw(us)
def ob = {
    val obe = Picture.rectangle(40, 50)
    obe.setPosition(cb.x + cb.width - 40, cb.y)
    obe
}

val obsticles = HashSet.empty[Picture]

timer(1000) {
    val obs = ob
    obs.draw
    obsticles.add(obs)
}


var jump = Vector2D(0, 0)
val gravity = Vector2D(0, -1500)
var ovel = Vector2D(-400, 0)

val ground = stageBot

animate {
    val dt = frameDeltaTime
    jump = (jump + gravity * dt)
    us.translate(jump * dt)
    if (us.collidesWith(ground)) {
        us.setPosition(us.position.x, ground.position.y)
        if (isKeyPressed(Kc.VK_SPACE)) {
            jump = Vector2D(0, 500)
        }
    }
    repeatFor(obsticles) { o =>
        o.translate(ovel * dt)
        if (o.collidesWith(us)) {
            stopAnimation()
        }
        if (o.collidesWith(stageLeft)) {
            o.erase()
            obsticles.remove(o)
        }

    }
}

activateCanvas()
```

