<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Hunted 4 - putting an envelope around character images for better collision detection

This activity has the following desired goals:
* Learning to put an envelope around character images for better collision detection (**A, M**)
* Using the above idea to improve the game from the previous lesson  (**M, T**).


In this lesson, we will use the images from the previous lesson located in the folder `full/path/to/assets/hunted3-assets`.

---

### Step 1
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
drawStage(black)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"
val pic = Picture.image(s"$assetsDir/player_run1.png")
draw(pic)

var vel = Vector2D(50, 100)
animate {
    val dt = frameDeltaTime
    pic.translate(vel * dt)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicOffStage(pic, vel)
    }
}

cleari()
drawStage(black)
```

**Q1a.** What does the above code do?

**Q1b.** Is there anything that looks a little off when you run the above program?

---

### Step 2
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
drawStage(black)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"

// The following boundary polygon was made using the "Sprite Boundary Maker" tool from the Tools menu
val picBoundary = Array(35.2, 3.1, 4.0, 30.1, 26.4, 87.2, 76.9, 103.7, 87.7, 25.5, 49.9, 2.0, 35.2, 3.1)

val pic = Picture.image(s"$assetsDir/player_run1.png", picBoundary)
draw(pic)

var vel = Vector2D(50, 100)
animate {
    val dt = frameDeltaTime
    pic.translate(vel * dt)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicOffStage(pic, vel)
    }
}
```

**Q2a.** Does the code in `Step 2` work better than the code in `Step 1` with regard to the previously identified problem? If so, why?

**Q2b** What do you think is the picture boundary polygon? Give it some thought and move to the next step.

---

### Step 3
Type in the following code and run it:

```scala
cleari()

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"

val pic = Picture.image(s"$assetsDir/player_run1.png")
draw(pic)

val picBoundary = Array(35.2, 3.1, 4.0, 30.1, 26.4, 87.2, 76.9, 103.7, 87.7, 25.5, 49.9, 2.0, 35.2, 3.1)

val boundaryPic = Picture.fromVertexShape { s =>
    val boundary = picBoundary.grouped(2)
    s.beginShape()
    while (boundary.hasNext) {
        val pts = boundary.next
        s.vertex(pts(0), pts(1))
    }
    s.endShape()
}
draw(boundaryPic)
```

**Q3a** What do you think is the picture boundary polygon?

---

### Explanation

Function descriptions:

* `Picture.image(fname, boundary)` - Creates a picture with the image in the given file, and with the given boundary polygon for the picture's (collision) geometry.

---

### Exercise

1. Make your own (more accurate) boundary polygon for the code in step 2 - using the "Sprite Boundary Maker" tool from the Tools menu.

2. Use boundary polygons to improve the version of hunted from the previous lesson.