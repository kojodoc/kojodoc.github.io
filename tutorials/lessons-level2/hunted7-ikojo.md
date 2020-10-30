<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 7 - running in iKojo

This activity has the following desired goals:
* Testing a game (that loads assets off the web) within iKojo - as we prepare to convert the game to a web-app (**A, M**).

---

### Step 1
Open up the following code in iKojo (ikojo.in) and run it:

```scala
cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds
val assetsDir = "https://kojofiles.netlify.app/hunted7"

preloadImage(s"$assetsDir/bg.png")
preloadImage(s"$assetsDir/player_run_sheet.png")
preloadMp3(s"$assetsDir/Cave.mp3")
preloadMp3(s"$assetsDir/DrumBeats.mp3")

playMp3Loop(s"$assetsDir/Cave.mp3")

val bg = Picture.image(s"$assetsDir/bg.png")
bg.setPosition(cb.x, cb.y)
draw(bg)

def pictureFromImages(images: ArrayBuffer[Image], env: Picture) = {
    val pics = ArrayBuffer.empty[Picture]
    repeatFor(images) { img =>
        pics.append(Picture.image(img, env))
    }
    picBatch(pics)
}

// works for a spritesheet with images in one row
def sheetImages(fname: String, numImages: Int, imgWidth: Int, imgHeight: Int): ArrayBuffer[Image] = {
    val sheet = SpriteSheet(fname, imgWidth, imgHeight)
    val images = ArrayBuffer.empty[Image]
    repeatFor(rangeTill(0, numImages)) { n =>
        images.append(sheet.imageAt(n, 0))
    }
    images
}

val playerImages = sheetImages(s"$assetsDir/player_run_sheet.png", 3, 96, 128)

val playerEnvelope = Picture {
    right(90)
    hop(10)
    left(90)
    forward(100)
    right(90)
    forward(80)
    right(90)
    forward(100)
    right(90)
    forward(80)
}
drawAndHide(playerEnvelope)

val player = pictureFromImages(playerImages, playerEnvelope)
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
draw(player)

val nh = 5
val hunters = ArrayBuffer.empty[Picture]
val huntersVel = HashMap.empty[Picture, Vector2D]

val hunterEnvelope = Picture {
    right(90)
    hop(10)
    left(90)
    forward(95)
    right(90)
    forward(75)
    right(90)
    forward(95)
    right(90)
    forward(75)
}
drawAndHide(hunterEnvelope)

val picImages = sheetImages(s"$assetsDir/robot_walk_sheet.png", 8, 96, 128)

repeatFor(1 to nh) { n =>
    val pic = pictureFromImages(picImages, hunterEnvelope)
    pic.setPosition(cb.x + cb.width / (nh + 2) * n, cb.y + 100 + randomDouble(0, cb.height - 200))
    hunters.append(pic)
    val hv = Vector2D(random(1, 4), random(1, 4))
    huntersVel(pic) = hv
    draw(pic)
}

def gameLost() {
    stopAnimation()
    drawCenteredMessage("You Lost", red, 30)
}

val speed = 5
animate {
    repeatFor(hunters) { h =>
        var hv = huntersVel(h)
        h.translate(hv)
        h.showNext(200)

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
        player.translate(speed, 0)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        player.translate(-speed, 0)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        player.translate(0, speed)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        player.translate(0, -speed)
        player.showNext(200)
    }

    if (player.distanceTo(stageBorder) < 50) {
        if (!isMp3Playing) {
            playMp3(s"$assetsDir/DrumBeats.mp3")
        }
    }
    else {
        stopMp3()
    }

    if (player.collidesWith(stageBorder)) {
        gameLost()
    }
}
activateCanvas()
```

The code above brings together a lot of the ideas from the previous few lessons. Make sure you fully understand it.

---

### Explanation

To be able to export games written in Kojo as web-apps and mobile apps, we need to first make sure that they run fine in a web environment. iKojo is the place where you can test your game to make sure it works well within a browser.