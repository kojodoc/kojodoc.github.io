<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Exporting *Hunted 8* as a web-app that can run standalone on personal computers and on mobile phones

This activity has the following desired goals:
* Learning to export a game as a web-app that can run on PCs and mobiles (**A, M**).
* Applying the above ideas to the `Hunted` game from the previous lessons (**M, T**).

---

### Steps to be followed:
1. Use the *File -> Export Script as Web-App* menu item to export the game code in the script editor as a web-app. 
This step will put your webapp under `~/kojo-export/webapp`.
2. Transfer the webapp folder to a static hosting site. A good site for this is netlify.com.
This step will put your game on the web at whatever url you set up on the static hosting site. Let's assume that the game url is abc.netlify.app
3. Go to abc.netlify.app via your internet browser on your PC. Enjoy the game!
4. Go to abc.netlify.app via your internet browser on your mobile. Enjoy the game! In Chrome on Android, you can go to settings and do a *Add to Home Screen* to add the game to your home screen for easy launching.

---

### Published game

A slightly enhanced (from the previous lesson) version of `Hunted` is live at [https://hunted.netlify.app](https://hunted.netlify.app). Check it out.

The code for the published game is shown below. Study it to fully understand how the game works.

```scala
cleari()
initRandomGenerator(34)

val assetsDir = "https://kojofiles.netlify.app/hunted7"
preloadImage(s"$assetsDir/player_run_sheet.png")
preloadImage(s"$assetsDir/robot_walk_sheet.png")
preloadMp3(s"$assetsDir/Cave.mp3")
preloadMp3(s"$assetsDir/DrumBeats.mp3")
preloadImage(s"$assetsDir/bg-patch.jpg")

var fullScreen = false

def tileImageOnCanvas(imgFile: String, iw: Int, ih: Int) {
    val cb = canvasBounds
    val numx = cb.width.toInt / iw + 1
    val numy = cb.height.toInt / ih + 1
    repeatFor(0 until numx) { gx =>
        repeatFor(0 until numy) { gy =>
            val patch = Picture.image(imgFile)
            patch.setPosition(cb.x + gx * iw, cb.y + gy * ih)
            draw(patch)
        }
    }
}

class Game {
    drawStage(ColorMaker.hsl(120, 1.00, 0.05))
    val cb = canvasBounds

    val scaleFactor = if (cb.width < 500 || cb.height < 500) 0.5 else 1.0

    playMp3Loop(s"$assetsDir/Cave.mp3")

    if (fullScreen) {
        tileImageOnCanvas(s"$assetsDir/bg-patch.jpg", 128, 128)
    }

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
        hop(30)
        left(90 + 40)
        forward(45)
        right(90)
        forward(40)
        left(55)
        forward(30)
        right(75)
        forward(55)
        right(90)
        forward(23)
        right(47)
        forward(22)
        left(70)
        forward(5)
        right(30)
        forward(40)
        right(45)
        forward(30)
        right(60)
        forward(47)
    }
    drawAndHide(playerEnvelope)

    val player = pictureFromImages(playerImages, playerEnvelope)
    player.setPosition(cb.x + cb.width / 2, cb.y + cb.height / 2 - 100)
    player.scale(scaleFactor)
    draw(player)

    val nh = 5
    val hunters = ArrayBuffer.empty[Picture]
    val huntersVel = HashMap.empty[Picture, Vector2D]

    val hunterEnvelope = Picture {
        right(90)
        hop(25)
        left(90 + 45)
        forward(35)
        right(90)
        forward(35)
        left(90)
        forward(10)
        right(70)
        forward(38)
        right(65)
        forward(30)
        right(55)
        forward(25)
        right(30)
        forward(50)
        right(30)
        forward(23)
        right(65)
        forward(48)
    }
    drawAndHide(hunterEnvelope)

    val picImages = sheetImages(s"$assetsDir/robot_walk_sheet.png", 8, 96, 128)

    repeatFor(1 to nh) { n =>
        val pic = pictureFromImages(picImages, hunterEnvelope)
        pic.setPosition(cb.x + cb.width / (nh + 2) * n, cb.y + 100 + randomDouble(0, cb.height - 200))
        pic.scale(scaleFactor)
        hunters.append(pic)
        val hv = Vector2D(random(1, 4), random(1, 4))
        huntersVel(pic) = hv
        draw(pic)
    }

    def gameLost() {
        stopAnimation()
        drawCenteredMessage("You Lost", red, 30)
    }

    val jsRad = 70 * scaleFactor
    val js = joystick(jsRad)
    val delta = if (cb.width < cb.height) cb.width / 10 else cb.height / 10
    js.setPostiion(cb.x + cb.width - jsRad - delta, cb.y + jsRad + delta)
    js.setPerimeterColor(ColorMaker.rgb(120, 120, 120).fadeOut(0.2))
    js.setPerimeterPenColor(black)
    js.setControlColor(white.fadeOut(0.2))
    js.draw()

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
        else {
            js.movePlayer(player, 0.2 * scaleFactor)
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
    showGameTime(60, "You Won", white, 15)
    showFps(white, 15)
    activateCanvas()
}

val instructions = penColor(black) -> Picture.text("Evade the hunters for 60 seconds to win!", 20)

val startButton = fillColor(ColorMaker.hsl(0, 1.00, 0.70)) -> Picture.rectangle(100, 100)
val msg = penColor(black) -> Picture.text("Begin", 20)
val pic1 = picColCentered(msg, Picture.vgap(10), startButton)

val startButton2 = fillColor(ColorMaker.hsl(0, 1.00, 0.30)) -> Picture.rectangle(100, 100)
val msg2 = penColor(black) -> Picture.text("Begin Fullscreen", 20)
val pic2 = picColCentered(msg2, Picture.vgap(10), startButton2)

val pic = picColCentered(
    picRowCentered(pic1, Picture.hgap(100), pic2),
    Picture.vgap(50),
    instructions
)

drawCentered(pic)
pic1.onMouseClick { (x, y) =>
    pic.erase()
    schedule(1.0) {
        new Game
    }
}

pic2.onMouseClick { (x, y) =>
    pic.erase()
    toggleFullScreenCanvas()
    fullScreen = true
    schedule(1.0) {
        new Game
    }
}
```
---

### Exercise

Publish your version of `Hunted` at a location of your choice on the web.
