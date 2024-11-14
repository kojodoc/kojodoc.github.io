<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Pictures - responding to the keyboard, joystick, and mouse clicks

This activity has the following desired goals:
* Learning how to make a picture respond to keyboard key-presses (**A, M**).
* Learning how to make a picture respond to mouse clicks (**A, M**).
* Learning how to make a picture respond to the joystick (**A, M**).
* Learning to apply the above ideas to interact with a picture (**M, T**).

---


### Step 1
Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()

val pic = Picture.rectangle(50, 50)
draw(pic)

val speed = 100
animate {
    val dt = frameDeltaTime
    if (isKeyPressed(Kc.VK_RIGHT)) {
        pic.translate(speed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        pic.translate(-speed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        pic.translate(0, speed * dt)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        pic.translate(0, -speed * dt)
    }
}
activateCanvas()
```

**Q1a.** What does the above program do?

**Q1b.** What information does the `Kc` (short for key-code) object contain? Use code completion to find out

**Q1c** What do you think the `isKeyPressed` query does? What input does it take? What result does it return?

---

### Explanation

* Every time you press a key on the keyboard, a key-press event is sent to the window on your screen that has the *focus*.
* The drawing canvas gets the focus if you either (a) click on it or (b) run the activateCanvas() command.
* Every key has a key-code associated with it (to identify it).
* The `isKeyPressed(keyCode)` function takes a key-code as input and returns true if that key is currently pressed. Otherwise it returns false. 
* All possible key-codes are defined in the `Kc` object.
* Based on the above ideas, the code in `Step 1` gives you the ability to control the movement of a rectangle on the screen with the help of the arrow keys. This is how you might control a player in a game that you write.

---

### Step 2

Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()
disablePanAndZoom()

val pic = Picture.rectangle(50, 50)
draw(pic)

val speed = 100
animate {
    val dt = frameDeltaTime

    if (isMousePressed) {
        val mp = mousePosition
        val p = pic.position
        val delta = mp - p
        val direction = Vector2D(delta.x, delta.y).normalize
        val velocity = direction * speed
        pic.translate(velocity * dt)
    }
}
activateCanvas()
```

**Q2a.** What does the above program do?

**Q2b.** What does the `mousePosition` query return?

**Q2c.** What does the line `val direction = Vector2D(delta.x, delta.y).normalize` calculate?

**Q2d.** How does the above program make the rectangle move towards the mouse? What is the speed of this movement?


---

### Explanation

* `mousePosition` - returns the position of the mouse.
* `pic.position` - returns the position of the rectangle.
* The difference between these two positions helps you determine the direction of the mouse relative to the rectangle.
* `vec.normalize` - normalizes a vector and returns a unit vector that represents only a direction (as the magnitude of a unit vector is 1).
* The above ideas can help you to move the rectangle towards the mouse.

---

### Exercise

Write a program that does the following:
* Creates a rectangular picture.
* Allows the user to control the picture via the arrow keys.
* Allows the user to increase the size of the picture by clicking above it.
* Allows the user to decrease the size of the picture by clicking below it.

You can use the following command in your solution:
* `pic.scale(f)` - changes the size of `pic`. If the given `f` is greater than 1, the size of the picture increases. If `f` is less than 1, the size decreases.
