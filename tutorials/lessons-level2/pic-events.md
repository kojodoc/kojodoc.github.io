<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

> <img src="../../man-at-work.png"/> <br/> *This section of the website is currently under development*.


## Pictures - responding to the keyboard, joystick, and mouse clicks

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

**Q1b.** What information does the Kc (short for key-code) object contain? Use code completion to find out

**Q1c** What do you think the isKeyPressed query does? What input does it take? What result does it return?

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
