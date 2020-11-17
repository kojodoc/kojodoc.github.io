<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Keeping Pictures within the stage area

This activity has the following desired goals:
* Learning to draw the stage (**A**).
* Learning about Vectors (**A, M**).
* Learning to check for collisions with the stage border (**A, M**).
* Learning to bounce off the stage border (**A, M**).
* Using the above ideas to animate multiple objects and keeping them within the stage area (**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
cleari()
drawStage(black)
```

Then zoom out the canvas a little.

**Q1a.** Do you see the stage area?

**Q1b.** What do you think is the use of the stage area?

---

### Explanation

The stage provides a backdrop on which you can have characters in an animation or game. The stage also enables collision detection and bouncing off its borders, thus making it easy to keep these characters within a confined area.

---

### Step 2

Type in the following code and run it:

```scala
cleari()
drawStage(black)

val pic = Picture.rectangle(50, 50)
draw(pic)

var vel = Vector2D(1, 2)
animate {
    pic.translate(vel)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicOffStage(pic, vel)
    }
}
```

**Q2a.** What do you think is a `Vector2D`? How is it used in the code above?

**Q2b.** What do you think the `collidesWith` function does? What inputs does it take? What value does it return?

**Q2c.** What do you think the `bouncePicOffStage` function does? What inputs does it take? What value does it return?

**Q2d.** Can you explain the above code?

---

### Explanation

A vector can be defined in the following ways:
* As a quantity with a magnitude and a direction.
* As a multi-dimensional quantity.

In contrast to a vector, a scalar is a quantity with only a magnitude (and is one dimensional).

An example of a vector is velocity. An example of a scalar is speed.

Vectors in Kojo are two-dimensional (as they work with the 2-D canvas). Each vector has an `x` component, and a `y` component. These components give every vector a magnitude (`math.sqrt(x*x + y*y)`) and direction (`math.atan2(y/x)`). When you want to move a picture `pic` around on the screen, you can use `pic.translate(someVector)`. This will move `pic` by this given `x` and `y`. If the `pic.translate(someVector)` happens inside an animate loop, it will happen ~50 times per second.

Function description:

* `Vector2D(x, y)` - constructs a Vector2D value with the given `x` and `y`. Note that here Vector2D is both the name of the function and the type of the data value that is created/returned by the function.
* `pic.collidesWith(stageBorder)` - returns true if pic has collided with the stage border. bouncing off the stage.
* `bouncePicOffStage(pic, vel)` - for a picture `pic` moving with velocity `vel` - this function returns the velocity after bouncing off the stage.

---

### Exercise

Write a program that does the following:
* Draws four rectangles at the center of the stage.
* Moves the rectangles towards the four corners of the stage.
* Keeps the rectangles within the stage borders as they move around.

<div style="margin-top: 20px;margin-bottom: 20px;text-align:center">
    <iframe frameborder="0" width="640" height="360" src="https://player.vimeo.com/video/480240170" allow="autoplay"></iframe>
</div>
