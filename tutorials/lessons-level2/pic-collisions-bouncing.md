<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Picture collisions and bouncing

This activity has the following desired goals:
* Learning to check for picture collisions (**A, M**).
* Learning to bounce colliding pictures off each other (**A, M**).
* Using the above ideas to animate multiple objects while: (**M, T**)
  * keeping them within the stage area.
  * making them bounce off each other.

---

### Step 1

Type in the following code and run it:

```scala
clear()
drawStage(cm.black)
val cb = canvasBounds

val pic1 = Picture {
    right(45)
    val n = 6
    repeat(n) {
        forward(50)
        right(360.0 / n)
    }
}
pic1.setPosition(cb.x + 20, 0)
pic1.setFillColor(cm.khaki)
pic1.setPenColor(cm.khaki)
var vel1 = Vector2D(4, 0)

val pic2 = Picture {
    val n = 5
    repeat(n) {
        forward(50)
        right(360.0 / n)
    }
}
pic2.setPosition(cb.x + cb.width - 40 - 20, 0)
pic2.setFillColor(cm.khaki)
pic2.setPenColor(cm.khaki)
var vel2 = -vel1

draw(pic1, pic2)
animate {
    pic1.translate(vel1)
    pic2.translate(vel2)

    if (pic1.collidesWith(pic2)) {
        vel1 = bouncePicOffPic(pic1, vel1, pic2)
        vel2 = -vel1
    }
}
```

**Q1a.** Read through the code above and try to understand what it does. Then explain to a friend.

**Q1b.**  What do you think `pic1.collidesWith(pic2)` does? Is this a command or a function? What are its inputs and outputs?

**Q1c.**  What do you think `bouncePicOffPic(pic1, vel1, pic2)` does? Is this a command or a function? What are its inputs and outputs?

---

### Explanation

Function descriptions:

* `pic.collidesWith(other: Picture)` - returns true if `pic` has collided with `other`.
* `bouncePicOffPic(pic: Picture, vel: Vector2D, obstacle: Picture)`- for a picture `pic` moving with velocity `vel` - this function returns the velocity after bouncing off `obstacle`.

---

### Exercise

Write a program that does the following:
* Draws four non-overlapping rectangles in the center region of the stage.
* Moves the rectangles towards the four corners of the stage.
* Keeps the rectangles within the stage borders (by making them bounce off the borders).
* Makes the rectangles bounce off each other (so that whenever any two collide, they bounce off each other).
