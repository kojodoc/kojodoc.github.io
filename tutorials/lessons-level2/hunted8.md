<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 8 - using a joystick to make the game mobile friendly

This activity has the following desired goals:
* Using a joystick to make games mobile friendly (**A, M**)
* Applying the above ideas to the hunted game (**M, T**)

---

### Step 1
Type in the following code and run it:

```scala
cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds

val env = Picture {
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
drawAndHide(env)

val assetsDir = "https://kojofiles.netlify.app/hunted7"

preloadImage(s"$assetsDir/player_run_sheet.png")
preloadMp3(s"$assetsDir/Cave.mp3")
preloadMp3(s"$assetsDir/DrumBeats.mp3")

playMp3Loop(s"$assetsDir/Cave.mp3")

val sheet = SpriteSheet(s"$assetsDir/player_run_sheet.png", 96, 128)
val pic1 = Picture.image(sheet.imageAt(0, 0), env)
val pic2 = Picture.image(sheet.imageAt(1, 0), env)
val pic3 = Picture.image(sheet.imageAt(2, 0), env)

val player = picBatch(pic1, pic2, pic3)
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
draw(player)

val js = joystick(25)
js.setPostiion(cb.x + cb.width / 2, cb.y + 25 + 10)
js.setPerimeterColor(ColorMaker.hsl(120, 1.00, 0.68).fadeOut(0.2))
js.setPerimeterPenColor(white.fadeOut(0.5))
js.setControlColor(black.fadeOut(0.2))
js.draw()

val speed = 5
animate {
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
        js.movePlayer(player, 1)
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
    
}
activateCanvas()
```

**Q1a.** How does the above code use a joystick to move the player? Does the code also support keyboard input in addition to joystick input to control the player?

**Q1b** Why does the above game use both keyboard and joystick for player control?

---

### Exercise

Using the ideas above, use a joystick in the version of hunted from the previous lesson.