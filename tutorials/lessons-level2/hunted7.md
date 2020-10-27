<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 7 - loading images and sounds off the web

This activity has the following desired goals:
* Loading images from the web (**A, M**)
* Loading sounds from the web (**A, M**)
* Applying the above ideas to the hunted game (**M, T**)

---

### Step 0

Transfer the assets from the previous lesson to some location on the web/internet/cloud. A good place for this is netlify.com.

For the purpose of this lesson, the assets have been transferred to `https://kojofiles.netlify.app/hunted7`

---

### Step 1
Type in following code and run it:

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

**Q1a.** Does the code above do the same thing as the code in `step 1` of the previous lesson? If so, what has changed?

---

### Explanation

Command/Function description:

As you just saw, the one significant difference between the version of the game in this lesson and the previous lesson is that the `asssetDir` changed from being a local folder to a remote one.

It's important to keep in mind that loading a file from a remote location can take substantially longer than loading it locally. So, the program above also preloads the sounds and images needed for the game, so that the game does not pause when any sound or image is accessed for the first time and is loaded off the web. 

The following commands are used for preloading:
* `preloadImage(imageFileLocation)` - loads and caches the image file from the given location.
* `preloadImage(soundFileLocation)` - loads and caches the sound file from the given location.

---

### Exercise

Using the ideas above, load sounds and images off the web in the version of hunted from the previous lesson .