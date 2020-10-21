<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Using multiple images per character for richer animation.

This activity has the following desired goals:
* Using multiple separate images to animate a character (**A, M**)
* Using multiple images in a sprite-sheet to animate a character (**A, M**)

---

### Step 0

Download the zip file with the image assets for this lesson - [multi-image-assets.zip](multi-image-assets.zip). This zip file contains the following image files:
```
player_run0.png
player_run1.png
player_run2.png
player_run_sheet.png
```

Uncompress this zip-file and put it under any folder on your computer. Let's call this folder `full/path/to/assets`.

So now the above images will be in the folder `full/path/to/assets/multi-image-assets`.

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

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/multi-image-assets"
val pic1 = Picture.image(s"$assetsDir/player_run0.png", env)
val pic2 = Picture.image(s"$assetsDir/player_run1.png", env)
val pic3 = Picture.image(s"$assetsDir/player_run2.png", env)

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
}
activateCanvas()
```

**Q1a.** Which lines in the above code load the multiple images for the character?

**Q1b.** Which lines in the above code draw the multiple images for the character?

---

### Explanation

Function description:
* `picBatch(pics)` - let's you create a batch of pictures. This batch behaves like a single picture, and after the batch is drawn, only one of the pictures in the batch (called the current picture) is shown on the screen at any given time. You can change the current picture by calling showNext() on the batch picture.
* `batchPic.showNext()` - changes the current picture to be the next picture in the sequence of pictures making up the batch. The new current picture is then shown on the screen.
* `batchPic.showNext(minimumTime)` - changes the current picture to be the next picture in the sequence of pictures making up the batch, but only if more then `minimumTime` has elapsed since the last picture change. If the current picture is changed, the new current picture is shown on the screen.

---

### Step 2
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

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/multi-image-assets"
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
}
activateCanvas()
```

**Q2a.** Does the code above do the same thing as the code in Step 1?

**Q2a.** How does the above code differ from the code in Step 1?

---

### Explanation

You have seen that a picture batch is made up of a sequence of pictures. In `step 1`, each of the pictures in the batch was loaded separately from a different image. That works fine on a desktop computer, but when you load images off the cloud/internet, the multiple round-trips to load the different images can take a lot of time. To work around this issue, you can put all related images inside a sprite-sheet.

Function descriptions:
* `SpriteSheet(fileName, width, height)` - creates a sprite-sheet from the given sprite-sheet image. Each image in the sprite-sheet is assumed to have the given `width` and `height`.
* `sheet.imageAt(x, y)` - returns the image at the given `x` and `y` in the sprites-sheet. `x` is the column and `y` is the row in the sprite-sheet, starting at the top-left of the sheet.

---

### Exercise

Download a sprite sheet off the internet and use it to animate the player from `Step 2` above.