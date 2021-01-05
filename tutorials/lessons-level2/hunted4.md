<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
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
cleari()
drawStage(black)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"
val pic = Picture.image(s"$assetsDir/player_run1.png")
draw(pic)

var vel = Vector2D(1, 2)
animate {
    pic.translate(vel)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicOffStage(pic, vel)
    }
}
```

**Q1a.** What does the above code do?

**Q1b.** Is there anything that looks a little off when you run the above program?

---

### Step 2
Type in the following code and run it:

```scala
cleari()
drawStage(black)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"
val picEnvelope = Picture {
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
drawAndHide(picEnvelope)

val pic = Picture.image(s"$assetsDir/player_run1.png", picEnvelope)
draw(pic)

var vel = Vector2D(1, 2)
animate {
    pic.translate(vel)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicOffStage(pic, vel)
    }
}
```

**Q2a.** Does the code in `Step 2` work better than the code in `Step 1` with regard to the previously identified problem? If so, why?

**Q2b** What do you think is a picture envelope? Give it some thought and move to the next step.

---

### Step 3
Type in the following code and run it:

```scala
cleari()

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/hunted3-assets"
val pic = Picture.image(s"$assetsDir/player_run1.png")
draw(pic)

val picEnvelope = Picture {
    setSpeed(medium)
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
draw(picEnvelope)
```

**Q3a** What do you think is a picture envelope?

---

### Explanation
Function descriptions:
* `Picture.image(fname, envelope)` - Creates a picture with the image in the given file, and with the given envelope for the picture's (collision) geometry.
* `drawAndHide(picture)` - draws and then hides the picture, to make it ready for collision detection without being visible.

---

### Exercise

1. Using the code in Step 3, improve the picture envelope for the code in step 2 so that collisions for the character with the stage border are better (on the top and left side).

2. Use the improved picture envelope to improve the version of hunted from the previous lesson.