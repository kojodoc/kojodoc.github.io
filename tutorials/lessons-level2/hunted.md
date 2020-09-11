<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Making a game - Hunted

This activity has the following desired goals:
* Learning to apply the ideas from the previous few lessons to make a game (**M, T**).

---

### Step 1
Type in following code and run it:

```scala
clear()
drawStage(cm.black)

val player = Picture.rectangle(50, 50)
player.setFillColor(green)
player.setPenColor(green)

val hunter1 = Picture.rectangle(50, 50)
hunter1.setFillColor(red)
hunter1.setPosition(250, 200)

val hunter2 = Picture.rectangle(50, 50)
hunter2.setFillColor(red)
hunter2.setPosition(-250, -200)

draw(player, hunter1, hunter2)

var vel1 = Vector2D(-3, -3)
var vel2 = Vector2D(4, 5)
var speedplayer = 10

def gameLost() {
    drawCenteredMessage("You Lose", cm.pink, 40)
    stopAnimation()
}

animate {
    hunter1.translate(vel1)
    hunter2.translate(vel2)
    if (hunter1.collidesWith(stageBorder)) {
        vel1 = bouncePicOffStage(hunter1, vel1)
    }

    if (hunter2.collidesWith(stageBorder)) {
        vel2 = bouncePicOffStage(hunter2, vel2)
    }

    if (player.collidesWith(hunter1)) {
        gameLost()
    }

    if (player.collidesWith(hunter2)) {
        gameLost()
    }

    if (player.collidesWith(stageBorder)) {
        gameLost()
    }

    if (isKeyPressed(Kc.VK_RIGHT)) {
        player.translate(speedplayer, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        player.translate(-speedplayer, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        player.translate(0, speedplayer)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        player.translate(0, -speedplayer)
    }
}

showGameTime(10, "You Win", green, 25)
activateCanvas()
```

**Q1a.** Which lines in the above code are used to set up the game stage?

**Q1b.** Which lines in the above code are used to move the hunters around on the stage?

**Q1c.** Which lines in the above code are used to move the player around on the stage?

**Q1d.** Which lines in the above code are used to check if the player has lost the game?

**Q1e.** Which lines in the above code are used to check if the player has won the game?

---

### Exercise

Add a third hunter to the code above.
