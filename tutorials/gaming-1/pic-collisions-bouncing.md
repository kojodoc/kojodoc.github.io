<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
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
// #exec template /picgaming

cleari()
drawStage(cm.black)
val cb = canvasBounds

val pic1 = Picture.rectangle(50, 50)
pic1.setPosition(cb.x + 20, 0)
pic1.setFillColor(cm.khaki)
pic1.setPenColor(cm.khaki)
var vel1 = Vector2D(100, 0)

val pic2 = Picture.rectangle(100, 100)
pic2.setPosition(cb.x + cb.width - 100, 0)
pic2.setFillColor(cm.khaki)
pic2.setPenColor(cm.khaki)
var vel2 = -vel1

draw(pic1, pic2)
animate {
    val dt = frameDeltaTime
    pic1.translate(vel1 * dt)
    pic2.translate(vel2 * dt)

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

<div style="margin-top: 20px;margin-bottom: 20px;text-align:center">
    <iframe frameborder="0" width="640" height="360" src="https://player.vimeo.com/video/480783794" allow="autoplay"></iframe>
</div>
