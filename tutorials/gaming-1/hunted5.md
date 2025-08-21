<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 5 - using multiple images per character for richer animation

This activity has the following desired goals:
* Using multiple separate images to animate a character (**A, M**)
* Using multiple images in a sprite-sheet to animate a character (**A, M**)
* Applying the above idea to the hunted game (**M, T**)

---

### Step 0

Download the zip file with the image assets for this lesson - [hunted5-assets.zip](hunted5-assets.zip). This zip file contains the following image files:
```
player_run0.png
player_run1.png
player_run2.png
player_run_sheet.png
robot_walk_sheet.png
```

Uncompress this zip-file under any folder on your computer. You should now have a folder called `hunted5-assets` inside this folder.

---

### Step 1
Take the following code and save it in a .kojo file inside the `hunted5-assets` folder described above. Then run the code.

```scala
// #exec template /picgaming

cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds

val picBoundary = Array(35.2, 3.1, 4.0, 30.1, 26.4, 87.2, 76.9, 103.7, 87.7, 25.5, 49.9, 2.0, 35.2, 3.1)

val pic1 = Picture.image("player_run0.png", picBoundary)
val pic2 = Picture.image("player_run1.png", picBoundary)
val pic3 = Picture.image("player_run2.png", picBoundary)

val player = picBatch(pic1, pic2, pic3)
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
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
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
drawStage(ColorMaker.hsl(120, 1.00, 0.08))
val cb = canvasBounds

val picBoundary = Array(35.2, 3.1, 4.0, 30.1, 26.4, 87.2, 76.9, 103.7, 87.7, 25.5, 49.9, 2.0, 35.2, 3.1)

val sheet = SpriteSheet("player_run_sheet.png", 96, 128)
val pic1 = Picture.image(sheet.imageAt(0, 0), picBoundary)
val pic2 = Picture.image(sheet.imageAt(1, 0), picBoundary)
val pic3 = Picture.image(sheet.imageAt(2, 0), picBoundary)

val player = picBatch(pic1, pic2, pic3)
player.setPosition(cb.x + cb.width / 2, cb.y + 20)
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
}
activateCanvas()
```

**Q2a.** Does the code above do the same thing as the code in Step 1?

**Q2b.** How does the above code differ from the code in Step 1?

---

### Explanation

You have seen that a picture batch is made up of a sequence of pictures. In `step 1`, each of the pictures in the batch was loaded separately from a different image. That works fine, but for multiple images, it's more performant and easier to manage if all the images are part of one larger image called a sprite sheet.

Function descriptions:
* `SpriteSheet(fileName, width, height)` - creates a sprite-sheet from the given sprite-sheet image. Each image in the sprite-sheet is assumed to have the given `width` and `height`.
* `sheet.imageAt(x, y)` - returns the image at the given `x` and `y` in the sprites-sheet. `x` is the column and `y` is the row number (beginning from 0) in the sprite-sheet, starting at the top-left of the sheet.

---

### Exercise

Use the ideas above to improve the version of hunted from the previous lesson, by implementing character animation for both the player and the hunters.