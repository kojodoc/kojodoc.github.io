<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 2 - increasing the number of hunters without any code change

This activity has the following desired goals:
* Further practice with using ArrayBuffers and HashMaps in a game (**M, T**).
* Learning to use ArrayBuffers and HashMaps in a game (**M, T**).

---

### Step 1
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
drawStage(cm.darkGreen)
val cb = canvasBounds

val player = Picture.rectangle(40, 40)
player.setFillColor(cm.yellow)
player.setPenColor(black)
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
draw(player)

val nh = 10
val hunters = ArrayBuffer.empty[Picture]
val huntersVel = HashMap.empty[Picture, Vector2D]
repeatFor(1 to nh) { n =>
    val pic = Picture.rectangle(40, 40)
    pic.setFillColor(cm.lightBlue)
    pic.setPenColor(black)
    pic.setPosition(cb.x + cb.width / (nh + 2) * n, cb.y + randomDouble(100, cb.height - 200))
    hunters.append(pic)
    val hv = Vector2D(random(50, 200), random(50, 200))
    huntersVel(pic) = hv
    draw(pic)
}

def gameLost() {
    stopAnimation()
    drawCenteredMessage("You Lost", red, 30)
}

val speed = 200
animate {
    val dt = frameDeltaTime
    repeatFor(hunters) { h =>
        var hv = huntersVel(h)
        h.translate(hv * dt)
        if (h.collidesWith(stageBorder)) {
            hv = bouncePicOffStage(h, hv)
            huntersVel(h) = hv
        }

        if (h.collidesWith(player)) {
            gameLost()
        }
    }

    if (isKeyPressed(Kc.VK_RIGHT)) {
        player.translate(speed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        player.translate(-speed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        player.translate(0, speed * dt)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        player.translate(0, -speed * dt)
    }

    if (player.collidesWith(stageBorder)) {
        gameLost()
    }
}
showGameTime(10, "You Win", black, 25)
activateCanvas()
```

**Q1a.** How does the above code move all the hunters around on the stage? How is every hunter translated in the animation loop?

**Q1b.** How does the above code make all the hunters buonce off the stage border? How is a hunters velocity updated after colliding with the stage border?

---

### Exercise

Extend the above game to make the hunters bounce off each other.
