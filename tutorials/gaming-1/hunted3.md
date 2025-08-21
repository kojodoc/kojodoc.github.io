<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 3 - adding background and character images

This activity has the following desired goals:
* Learning to use images for richer characters and background (**A, M**)
* Using the above idea to give the game your own look and feel (**M, T**).

---

### Step 0

Download the zip file with the image assets for the game - [hunted3-assets.zip](hunted3-assets.zip). This zip file contains the following image files:
```
bg.png
player_run1.png
robot_walk4.png
```

Uncompress this zip-file under any folder on your computer. You should now have a folder called `hunted3-assets` inside this folder.

---

### Step 1
Take the following code and save it in a .kojo file inside the `hunted3-assets` folder described above. Then run the code.

```scala
// #exec template /picgaming

cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds

val bg = Picture.image("bg.png")
bg.setPosition(cb.x, cb.y)
draw(bg)

val player = Picture.image("player_run1.png")
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
draw(player)

val nh = 5
val hunters = ArrayBuffer.empty[Picture]
val huntersVel = HashMap.empty[Picture, Vector2D]

repeatFor(1 to nh) { n =>
    val pic = Picture.image("robot_walk4.png")
    pic.setPosition(cb.x + cb.width / (nh + 2) * n, cb.y + 150 + randomDouble(0, cb.height - 300))
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

        repeatFor(hunters) { h2 =>
            if (h.collidesWith(h2)) {
                hv = bouncePicOffPic(h, hv, h2)
                huntersVel(h) = hv
            }
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
activateCanvas()
```

**Q1a.** Which lines in the above code make the hunters bounce off each other?

**Q1b.** Which line in the above code loads the image for the player? Which line draws this image?

**Q1c.** Which line in the above code loads the image for the hunters? Which line draws this image?

**Q1d.** Which line in the above code loads the background image? Which line draws this image?


---

### Exercise

Extend the above game by using your own assets. You will need three images for this - one for the player, one for the hunters, and one for the background. Some possible sources for these images are the following:
- Images that you create yourself in a tool like GIMP.
- Images that you create with the help of AI tools (like DALL-E, Stable Diffusion, ChatGPT, etc).
- Images that you get off the internet (just to play with for this exercise).

