<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## ArrayBuffer, HashMap, and HashSet for gaming

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

var vhunter1 = Vector2D(-3, -3)
var vhunter2 = Vector2D(4, 5)
var speedplayer = 10

animate {
    hunter1.translate(vhunter1)
    hunter2.translate(vhunter2)
    if (hunter1.collidesWith(stageBorder)) {
        vhunter1 = bouncePicOffStage(hunter1, vhunter1)
    }

    if (hunter2.collidesWith(stageBorder)) {
        vhunter2 = bouncePicOffStage(hunter2, vhunter2)
    }

    if (player.collidesWith(hunter1)) {
        drawCenteredMessage("YOU LOSE", red, 40)
        stopAnimation()
    }

    if (player.collidesWith(hunter2)) {
        drawCenteredMessage("YOU LOSE", red, 40)
        stopAnimation()
    }

    if (player.collidesWith(stageBorder)) {
        drawCenteredMessage("YOU LOSE", red, 40)
        stopAnimation()
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

showGameTime(10, "YOU WIN", green, 25)
activateCanvas()
```

**Q1a.** Which lines in the above code are used to set up the game stage?

**Q1b.** Which lines in the above code are used to move the hunters around on the stage?

**Q1c.** Which lines in the above code are used to move the player around on the stage?

**Q1d.** Which lines in the above code are used to check if the player has lost the game?

**Q1e.** Which lines in the above code are used to check if the player has won the game?

**Exercise 1a.** Add a third hunter to the code above

### Step 2

Read about [ArrayBuffers](../../reference/abuffer-hmap-hset.html).

**Q2a.** What is an ArrayBuffer?

**Q2b.** What operations can you do with an ArrayBuffer?

**Exercise 2a.** Put the three hunters in the code from `Exercise 1a` inside an ArrayBuffer. Remove the code for the bouncing of the hunters off the stage. We are just interested in moving the hunters around for now.

**Q2c.** Why would we want to put the hunters inside an ArrayBuffer?

### Step 3

Read about [HashMaps](../../reference/abuffer-hmap-hset.html#hashmap).

**Q3a.** What is a HashMap?

**Q3b.** What operations can you do with a HashMap?

**Exercise 3a.** In the code from `Exercise 2a`, make the hunters bounce off the stage.
