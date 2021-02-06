<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 3 Index</a> | <a href="/modules/modules-index.html">Modules</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Rectangular grids - choosing colors from an image

This activity has the following desired goals:
* Learning to color a rectangular grid using colors from an image (**A, M**).
* Making interesting grid based designs (**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
size(600, 600)
cleari()
originBottomLeft()
val offWhite = cm.hex(0xF2F5F1)
setBackground(offWhite)

val tileCount = 100
val tileSize = cwidth / tileCount

val img = image("some-image.png")
def colorFromImage(x: Double, y: Double) = {
    val nx = mathx.map(x, 0, cwidth, 0, img.getWidth).toInt
    val ny = mathx.map(y, 0, cheight, 0, img.getHeight).toInt
    getImagePixel(img, nx, ny)
}

def cellColor(x: Double, y: Double) = colorFromImage(x, y)

def shape = Picture.rectangle(tileSize, tileSize)

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    pic.setPenColor(cm.tomato)
    pic.rotate(random(-5, 5))
    pic.scale(randomDouble(0.95, 1.1))
    pic.setFillColor(cellColor(posX, posY))
    pic.setPenThickness(0)
//    pic.setPenColor(offWhite)
    draw(pic)
}

repeatFor(rangeTill(0, cheight, tileSize)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileSize)) { posX =>
        block(posX, posY)
    }
}
```

**Q1a.** Read through the code above and try to understand what it does. What does the above code do? How does it do it?

### Explanation

The key idea for getting the color for a grid position from an image is shown in the following code:

```scala
val img = image("some-image.png")
def imgColor(x: Double, y: Double) = {
    val nx = mathx.map(x, 0, cwidth, 0, img.getWidth).toInt
    val ny = mathx.map(y, 0, cheight, 0, img.getHeight).toInt
    getImagePixel(img, nx, ny)
}
```

For any grid position, the color from the corresponding position in the image can be obtained via the imgColor function defined above. This function makes use of `mathx.map(value, low1, high1, low2, high2)` to do its work. `mathx.map` maps the given value from the range `(low1, high1)` to the range `(low2, high2)`.

---

### Exercise

Write a program to make a design using the above ideas.
