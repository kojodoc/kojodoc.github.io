<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 6 - adding sound

This activity has the following desired goals:
* Using mp3 files to add background music (**A, M**)
* Using mp3 files to add action music (**A, M**)
* Applying the above ideas to the hunted game (**M, T**)

---

### Step 0

Download the zip file with the image assets for this lesson - [hunted6-assets.zip](hunted6-assets.zip). This zip file contains the following image files:
```
player_run0.png
player_run1.png
player_run2.png
player_run_sheet.png
robot_walk_sheet.png
Cave.mp3
DrumBeats.mp3
```

Uncompress this zip-file and put it under any folder on your computer. Let's call this folder `full/path/to/assets`.

So now the above images will be in the folder `full/path/to/assets/hunted6-assets`.

---

### Step 1
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds

val picBoundary = Array(35.2, 3.1, 4.0, 30.1, 26.4, 87.2, 76.9, 103.7, 87.7, 25.5, 49.9, 2.0, 35.2, 3.1)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted6-assets"

playMp3Loop(s"$assetsDir/Cave.mp3")

val sheet = SpriteSheet(s"$assetsDir/player_run_sheet.png", 96, 128)
val pic1 = Picture.image(sheet.imageAt(0, 0), picBoundary)
val pic2 = Picture.image(sheet.imageAt(1, 0), picBoundary)
val pic3 = Picture.image(sheet.imageAt(2, 0), picBoundary)

val player = picBatch(pic1, pic2, pic3)
draw(player)

val speed = 200
animate {
    val dt = frameDeltaTime
    if (isKeyPressed(Kc.VK_RIGHT)) {
        player.translate(speed * dt, 0)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        player.translate(-speed * dt, 0)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        player.translate(0, speed * dt)
        player.showNext(200)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        player.translate(0, -speed * dt)
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

**Q1a.** Which line in the above code plays the background music?

**Q1b.** Which lines in the above code play and stop the action music?

---

### Explanation

Command/Function description:
* `pic1.distanceTo(pic2)` - tells you the distance between `pic1` and `pic2`.
* `playMp3Loop(music.mp3)` - plays the given `music.mp3` in a loop. This command is used for playing background music.
* `playMp3(sound.mp3)` - plays the given sound once.
* `stopMp3()` - stops a sound played with `playMp3`.
* `isMp3Playing` - tells you whether a sound played with `playMp3` is currently playing.


---

### Exercise

Use the ideas above to improve the version of hunted from the previous lesson.