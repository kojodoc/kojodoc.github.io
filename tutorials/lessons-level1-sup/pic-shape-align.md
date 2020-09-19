<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Pictures for shape and text alignment

### Step 1

Type in the following code and run it:

```scala
cleari()
setBackground(white)
def square(len: Int, color: Color) {
    setFillColor(color)
    setPenColor(color)
    repeat(4) {
        forward(len)
        right(90)
    }
}

val pic1 = Picture {
    square(100, cm.blue)
}

val pic2 = Picture {
    square(50, cm.lightBlue)
}

val pic3 = Picture {
    setPenFontSize(25)
    setPenColor(cm.black)
    write("Picture Power!")
}

val pic12 = picStackCentered(pic1, pic2)

val pic123 = picColCentered(pic3, Picture.vgap(10), pic12)

drawCentered(pic123)
```

**Q1a** What do you think the `picStackCentered` function does?

**Q1b** What do you think the `picColCentered` function does?

**Q1c** What do you think the `Picture.vgap` function does?

**Q1d** What does the above program do? How does it do it?

---

### Explanation

The basic idea with pictures is simple:
* You put a turtle drawing inside a picture.
* Now you can do many things with this picture drawing:
  * You can draw it (of course).
  * You can align it with other pictures.
  * You can translate, scale, or rotate it.
  * You can change its transparency.
  * You can apply effects to it.
  * You can animate it.
  * You can detect collisions with other pictures
  
In this activity, we are only interested in the drawing and the alignment part.

Function descriptions:

* `picStackCentered(pic1, pic2, ...)` - creates a new picture that stacks `pic1, pic2, ...` one over the other, with `pic1` underneath, `pic2` over it, and so on.
* `picColCentered(pic1, pic2, ...)` - creates a new picture that puts `pic1, pic2, ...` in a column from bottom to top, with `pic1` at the bottom, `pic2` next, and so on.
* `Picture.vgap(height)` - Creates an invisible picture with the given height. This can be used during picture layout - to provide vertical spacing.

---

### Step 2

Type in the following code and run it:

```scala
cleari()
setBackground(white)
def square(len: Int, color: Color) {
    setFillColor(color)
    setPenColor(color)
    repeat(4) {
        forward(len)
        right(90)
    }
}

val pic1 = Picture {
    square(100, cm.blue)
}

val pic2 = Picture {
    square(50, cm.lightBlue)
}

val pic3 = Picture {
    setPenFontSize(25)
    setPenColor(cm.black)
    write("Picture Power!")
}

val pic12 = picStackCentered(pic1, pic2)

val pic123 = picRowCentered(pic12, Picture.hgap(10), pic3)

drawCentered(pic123)
```

**Q2a** What do you think the `picRowCentered` function does?

**Q2b** What do you think the `Picture.hgap` function does?

**Q2c** What does the above program do? How does it do it?

---

### Explanation

Function descriptions:

* `picRowCentered(pic1, pic2, ...)` - creates a new picture that puts `pic1, pic2, ...` in a row from left to right, with `pic1` at the extreme left, `pic2` next, and so on.
* `Picture.hgap(width)` - Creates an invisible picture with the given width. This can be used during picture layout - to provide horizontal spacing.

---

### Step 3

Type in the following code and run it:

```scala
cleari()
setBackground(black)
val pic1 = Picture {
    setPenColor(cm.coral)
    setPenThickness(6)
    setFillColor(cm.cornSilk)
    repeat(6) {
        forward(100)
        right(60)
    }
}

// make the second picture and give it the name pic2
val pic2 = Picture {
    setPenColor(cm.brown)
    setPenThickness(4)
    right(360, 50)
}

// make a text picture and give it the name pic3
val pic3 = Picture {
    setPenFontSize(25)
    setPenColor(cm.lightSalmon)
    write("Picture Power!")
}

// stack pic1 and pic2 on top of each other and center them
val pic12 = picStackCentered(pic1, pic2)

// put pic3, the gap, and the stacked picture in a vertical centered colum
val pic123 = picColCentered(pic3, Picture.vgap(10), pic12)

// draw the column of pictures
drawCentered(pic123)
```

**Q3a** What does the above program do? How does it do it?

---

### Exercise

Use the above ideas to make a design.

