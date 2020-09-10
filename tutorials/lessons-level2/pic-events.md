<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

> <img src="../../man-at-work.png"/> <br/> *This section of the website is currently under development*.


## Pictures - responding to the keyboard, joystick, and mouse clicks

This activity has the following desired goals:
* Learning how to make a picture respond to keyboard key-presses (**A, M**).
* Learning how to make a picture respond to mouse clicks (**A, M**).
* Learning how to make a picture respond to the joystick (**A, M**).
* Learning to apply the above ideas to interact with a picture (**M, T**).

---


### Step 1
Type in following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)
draw(pic)

val speed = 5
animate {
    if (isKeyPressed(Kc.VK_RIGHT)) {
        pic.translate(speed, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        pic.translate(-speed, 0)
    }
    if (isKeyPressed(Kc.VK_UP)) {
        pic.translate(0, speed)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        pic.translate(0, -speed)
    }
}
activateCanvas()
```

**Q1a.** What does the above program do?

**Q1b.** What information does the `Kc` (short for key-code) object contain? Use code completion to find out

**Q1c** What do you think the `isKeyPressed` query does? What input does it take? What result does it return?

---

### Explanation

* Every time you press a key on the keyboard, a key-press event is sent to the window on your screen that has the focus.
* The drawing canvas gets the focus if you either (a) click on it or (b) run the activateCanvas() command.
* Every key-press event has a key-code associated with it (to identify it).
* All possible key-codes are defined in the `Kc` object.
* The `isKeyPressed(keyCode)` function takes a key-code as input and returns true if that key is currently pressed. Otherwise it returns false. 

---

### Step 2

Type in following code and run it:

```scala
clear()
setBackground(cm.black)
val cb = canvasBounds

val pic = fillColor(red) -> Picture.rectangle(400, 400)
drawCentered(pic)

pic.onMouseClick { (x, y) =>
    pic.erase()
    val msg = Picture.text("Done", 30)
    draw(msg)
}
```

**Q2a.** What does the above program do?

**Q2b.** Replace the onMouseClick with onMousePress in the code above. How does that change the functioning of the program?

**Q2c.** Replace the onMouseClick with onMouseRelease in the code above. How does that change the functioning of the program?

---

### Explanation

Command descriptions:

* `pic.onMouseClick { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is clicked inside the picture.
* `pic.onMousePress { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is pressed inside the picture.
* `pic.onMouseRelease { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is released inside the picture.
* `pic.onMouseMove { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse moves inside the picture.
* `pic.onMouseDrag { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is dragged inside the picture.
* `pic.onMouseEnter { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse enters the picture.
* `pic.onMouseExit { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse exits the picture.

---

### Step 3

Type in following code and run it:


```scala
cleari()
drawStage(black)
val pic = Picture.rectangle(50, 50)
draw(pic)

val js = joystick(25)
val cb = canvasBounds
js.setPostiion(cb.x + cb.width / 2, cb.y + 25 + 10)
js.draw()

animate {
    js.movePlayer(pic, 1)
}
```

**Q3a.** What does the above program do?

**Q3b** What does the joystick function do?

**Q3c** How does the joystick help you to move/control the picture?

**Q3d** What does the second input to `js.movePlayer` do? Find out by changing the value from 1 to 0.5 and then 2.

---

### Explanation

Command/Function descriptions:

* `joystick(radius)` - creates a joystick control with the given radius.
* `js.currentVector` - tells you the current vector for the joystick `js`. This vector is defined by two points - the center of the joystick control, and the center of the moveable joystick circle.
* `js.movePlayer(pic, scaleFactor)` - for the joystick `js`, moves the player based on the movement of the joystick circle, as per the `currentVector` defined above. You can scale the currentVector by using `scaleFactor` to make the movement faster (`scaleFactor` > `1`) or slower (`scaleFactor` < `1`).

---

### Exercise

Write a program that does the following:
* Creates a rectangular picture.
* Allows the user to control the picture via a joystick poisitoned at the bottom right of the stage.
* Allows the user to increase the size of the picture by pressing the up arrow.
* Allows the user to decrease the size of the picture by clicking on it.

