<div class="nav">
  <a href="../index.html">Home</a>
</div>

## An introduction to grid based generative art

Generative art is art that is generated via an interaction between a computer program and a human being.  
[*Todo*]

In this tutorial, you will play with generative art in the context of a grid. Here is what you will do:
* Make a grid of squares using turtle graphics.
* Switch to using pictures instead of turtle graphics to enable more flexibility in the drawing.
* Start using the setup, draw scheme for interactive designs (and more performant drawing).
  * Squares with scaling and opacity changes (and maybe rotation).
  * Square spiral in the above.
  * Random colors for the cells (but the same color for each cell).
  * Random colors from a palette (but the same color for each cell).
  * More compex shapes in each cell (introduce recursion?)
* Irregular grid.
* Shape palette.
* Stacking multiple grids.

### Turtle graphics grid
To get going, you will make a grid of squares on the canvas. For this, you will use the [shape/block idea](https://litan.github.io/kojodoc/art/shape-block.html) that you are familiar with:
* The shape for the pattern is a square
* The block positions the turtle at the bottom left of every grid cell, and then makes the shape.

**Quick Reference:**
* `size(w, h)` [*command*] - sets the size of the canvas to the given width and height.
* `cwidth` [*query*] - returns the current width of the canvas.
* `cheight` [*query*] - returns the current height of the canvas.
* `originBottomLeft()` [*command*] - situates the origin at the bottom left of the canvas.
* `rangeTill(from, untill, step)` [*function*] - returns a range that starts from `from`, goes until (but excluding) `until`, and steps up by `step`. See examples below:
```scala
rangeTill(4, 10, 2).toArray //> res16: Array[Int] = Array(4, 6, 8)
rangeTill(4, 11.5, 2.5).toArray //> res17: Array[BigDecimal] = Array(4.0, 6.5, 9.0)
```

Type in the code below and run it. Look at the output. Make sure you understand how the output is generated.

---

```scala
size(600, 600)
cleari()
originBottomLeft()
setSpeed(superFast)
setBackground(white)
setPenColor(black)

val tileCount = 10
val tileSize = cwidth / tileCount

def shape() {
    repeat(4) {
        forward(tileSize)
        right(90)
    }
}

def block(posX: Double, posY: Double) {
    setPosition(posX, posY)
    shape()
}

repeatFor(rangeTill(0, cheight, tileSize)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileSize)) { posX =>
        block(posX, posY)
    }
}
```

![gena-turtle-grid](gena-turtle-grid.png)

---

### Picture grid
Now, you will make the exact same grid as above, but using Pictures. The one big change here is that `shape` is no longer a command. Earlier the `block` command used to position the turtle appropriately and call the `shape` command. Now the `block` command creates a shape via the `shape` function, positions it appropriately, and then draws it.

```scala
size(600, 600)
cleari()
originBottomLeft()
setBackground(white)

val tileCount = 10
val tileSize = cwidth / tileCount

def shape = Picture.rectangle(tileSize, tileSize)

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    pic.setPenColor(black)
    draw(pic)
}

repeatFor(rangeTill(0, cheight, tileSize)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileSize)) { posX =>
        block(posX, posY)
    }
}
```

#### Exercise
Try out different picture shapes in the grid.

### Dynamic Picture Grid

For the next set of patterns, you will make the grid dynamic. Here, *dynamic* means that as you move the mouse over the grid, the grid-pattern will change. 

There are many ways to make a grid dynamic, but you will work with the following approach:

For every picture in the grid:
* note the position (posX, posY) of the picture.
* determine its distance from the mouse position (mouseX, mouseY).
* determine its angle from the mouse position.
* use the distance to scale and fade out the picture.
* use the angle to rotate the picture.

**Quick Reference:**
* `setup { drawing code }` - calls the drawing code once at the beginning of your program.
* `draw { drawing code }` - calls the drawing code at the default refresh rate, which is 50 times a second.
* `setRefreshRate(n)` - sets the refresh rate to `n` times per second. The next time a `clear()` is done, the refresh rate is reset to its default value of 50.
* `erasePictures()` - erases all the pictures in the canvas.
* `mathx.map(value, low1, high1, low2, high2)` - maps the given value from the range `(low1, high1)` to the range `(low2, high2)`
* `mathx.distance(x1, y1, x2, y2)` - calculates the distance between (x1, y1) and (x2, y2).
* `mathx.angle(x1, y1, x2, y2)` - calculates the angle in degrees between the line from (x1, y1) to (x2, y2) and the horizontal.

In this first *dynamic* example, you will work with a simple shape (a rectangle), and make the grid-pattern dynamic by (only) scaling the pictures in it.

Type in the code below and run it. Look at the output. Make sure you understand how the output is generated.

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape = Picture.rectangle(tileWidth, tileHeight)

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    pic.setPenColor(black)
    val d = mathx.distance(posX, posY, mouseX, mouseY)
    val f = mathx.map(d, 0, 500, 0.3, .9)
    pic.scale(f)
    draw(pic)
}

draw {
    erasePictures()
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            block(posX, posY)
        }
    }
}
```

#### Exercise
* Try out different picture shapes in the grid.
* Experiment with differernt scaling schemes.

In the second *dynamic* example, you will also fade out grid pictures as the mouse moves over the grid.

Type in the code below and run it. Look at the output. Make sure you understand how the output is generated.

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape = Picture.rectangle(tileWidth, tileHeight)

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    val d = mathx.distance(posX, posY, mouseX, mouseY)
    val f = mathx.map(d, 0, 500, 0.2, .7)
    pic.scale(f)
    pic.setPenColor(black.fadeOut(f))
    draw(pic)
}

draw {
    erasePictures()
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            block(posX, posY)
        }
    }
}
```

In the third and final *dynamic* example, you will also rotate the grid pictures as the mouse moves over the grid. Plus you will use a square-spiral shape instead of a rectangle for a nicer effect.

Type in the code below and run it. Look at the output. Make sure you understand how the output is generated.

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 20
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape = Picture {
    repeatFor(30 to 70) { n =>
        forward(n)
        right(91)
    }
}

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    val angle = mathx.angle(posX, posY, mouseX, mouseY)
    val dist = mathx.distance(posX, posY, mouseX, mouseY)
    val f = mathx.map(dist, 0, 500, 0.2, 0.8)
    pic.scale(f)
    pic.setPenColor(black.fadeOut(f))
    pic.setPenThickness(1)
    pic.rotate(angle)
    draw(pic)
}

draw {
    erasePictures()
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            block(posX, posY)
        }
    }
}
```

To better understand how the picture rotation works, play with the following code:

```scala
cleari()

draw {
    erasePictures()
    val pic = Picture.rectangle(100, 10)
    draw(pic)
    val pos = pic.position
    val a = math.atan2(mouseY - pos.y, mouseX - pos.x)
    pic.rotate(a.toDegrees)
}
```

#### Exercise
* Try out different picture shapes in the grid.
* Experiment with differernt scaling, fading, and rotation schemes.

### Irregular Grid
```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = Picture.ellipse(w / 2, h / 2)

case class Block(x: Double, y: Double, w: Double, h: Double)
val blocks = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight)
    blocks.append(block)
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(2)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 500, 0.2, .9)
    pic.setPenColor(black.fadeOut(f))
    pic.scale(f)
    draw(pic)
}

setup {
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
}

draw {
    erasePictures()
    repeatFor(blocks) { b =>
        drawBlock(b)
    }
}
```

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 20
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = trans(w / 2, h / 2) -> Picture.ellipse(w / 2, h / 2)

case class Block(x: Double, y: Double, w: Double, h: Double)
val blocks = ArrayBuffer.empty[Block]
val blocks2 = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight)
    blocks.append(block)
}

def splitSomeBlocks() {
    blocks2.clear()
    var idx = 0
    repeatFor(blocks) { b =>
        if (randomDouble(1) < 0.1) {
            val newBlocks = Array(
                Block(b.x, b.y, b.w / 2, b.h / 2),
                Block(b.x, b.y + b.h / 2, b.w / 2, b.h / 2),
                Block(b.x + b.w / 2, b.y, b.w / 2, b.h / 2),
                Block(b.x + b.w / 2, b.y + b.h / 2, b.w / 2, b.h / 2)
            )
            blocks2.appendAll(newBlocks)
        }
        else {
            blocks2.append(b)
        }
        idx += 1
    }
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(2)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 700, 0.2, 0.9)
    pic.setPenColor(black.fadeOut(f))
    pic.scale(f)
    draw(pic)
}

setup {
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
    splitSomeBlocks()
}

draw {
    erasePictures()
    repeatFor(blocks2) { b =>
        drawBlock(b)
    }
}
```
```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 20
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = trans(w / 2, h / 2) -> Picture.ellipse(w / 2, h / 2)

case class Block(x: Double, y: Double, w: Double, h: Double, c: Color)
val blocks = ArrayBuffer.empty[Block]
val blocks2 = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight, randomColor)
    blocks.append(block)
}

def splitSomeBlocks() {
    blocks2.clear()
    var idx = 0
    repeatFor(blocks) { b =>
        if (randomDouble(1) < 0.1) {
            val newBlocks = Array(
                Block(b.x, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x, b.y + b.h / 2, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y + b.h / 2, b.w / 2, b.h / 2, b.c)
            )
            blocks2.appendAll(newBlocks)
        }
        else {
            blocks2.append(b)
        }
        idx += 1
    }
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(1)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 250, 0.2, 0.9)
    pic.setPenColor(cm.gray)
    pic.setFillColor(b.c.fadeOut(f/2))
    pic.scale(f)
    draw(pic)
}

setup {
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
    splitSomeBlocks()
}

draw {
    erasePictures()
    repeatFor(blocks2) { b =>
        drawBlock(b)
    }
}
```
```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 20
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = Picture {
    repeatFor(1 to w.toInt) { n =>
        forward(n)
        right(91)
    }
}

case class Block(x: Double, y: Double, w: Double, h: Double, c: Color)
val blocks = ArrayBuffer.empty[Block]
val blocks2 = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight, randomColor)
    blocks.append(block)
}

def splitSomeBlocks() {
    blocks2.clear()
    var idx = 0
    repeatFor(blocks) { b =>
        if (randomDouble(1) < 0.3) {
            val newBlocks = Array(
                Block(b.x, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x, b.y + b.h / 2, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y + b.h / 2, b.w / 2, b.h / 2, b.c)
            )
            blocks2.appendAll(newBlocks)
        }
        else {
            blocks2.append(b)
        }
        idx += 1
    }
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(0.6)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 250, 0.4, 0.9)
    val a = math.atan2(mouseY - b.y, mouseX - b.y)
    pic.setPenColor(cm.gray)
    pic.setFillColor(b.c.fadeOut(f / 3))
    pic.rotate(a.toDegrees)
    pic.scale(f)
    draw(pic)
}

setup {
    repeatFor(rangeTill(tileHeight / 2, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(tileWidth / 2, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
    splitSomeBlocks()
}

draw {
    erasePictures()
    repeatFor(blocks2) { b =>
        drawBlock(b)
    }
}
```

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = Picture {
    val nums = 5
    def size(n: Int) = w / nums * n

    def squares(n: Int, dir: Int) {
        val len = size(n)
        repeat(4) {
            forward(len)
            right(90)
        }
        if (n > 1) {
            val len2 = size(n - 1)
            val delta = (len - len2) / 2
            hop(delta)
            right(90)
            hop(delta)
            left(90)
            dir match {
                case 1 =>
                    right(90); hop(delta / 2); left(90)
                case _ =>
            }
            squares(n - 1, dir)
        }
    }

    squares(nums, 1)
}

case class Block(x: Double, y: Double, w: Double, h: Double, c: Color)
val blocks = ArrayBuffer.empty[Block]
val blocks2 = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight, randomColor)
    blocks.append(block)
}

def splitSomeBlocks() {
    blocks2.clear()
    var idx = 0
    repeatFor(blocks) { b =>
        if (randomDouble(1) < 0.1) {
            val newBlocks = Array(
                Block(b.x, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x, b.y + b.h / 2, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y + b.h / 2, b.w / 2, b.h / 2, b.c)
            )
            blocks2.appendAll(newBlocks)
        }
        else {
            blocks2.append(b)
        }
        idx += 1
    }
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(0.5)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 250, 0.2, 0.9)
    pic.setPenColor(cm.gray)
    pic.setFillColor(b.c.fadeOut(f / 2))
//    pic.scale(f)
    draw(pic)
}

setup {
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
    splitSomeBlocks()
}

draw {
    erasePictures()
    repeatFor(blocks2) { b =>
        drawBlock(b)
    }
}
```
```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape(w: Double, h: Double) = Picture {
    val nums = 5
    def size(n: Int) = w / nums * n

    def squares(n: Int, dir: Int) {
        val len = size(n)
        repeat(4) {
            forward(len)
            right(90)
        }
        if (n > 1) {
            val len2 = size(n - 1)
            val delta = (len - len2) / 2
            hop(delta)
            right(90)
            hop(delta)
            left(90)
            dir match {
                case 1 =>
                    right(90); hop(delta / 2); left(90)
                case _ =>
            }
            squares(n - 1, dir)
        }
    }

    squares(nums, 1)
}

case class Block(x: Double, y: Double, w: Double, h: Double, c: Color)
val blocks = ArrayBuffer.empty[Block]
val blocks2 = ArrayBuffer.empty[Block]

def makeBlock(posX: Double, posY: Double) {
    val block = Block(posX, posY, tileWidth, tileHeight, randomColor)
    blocks.append(block)
}

def splitSomeBlocks() {
    blocks2.clear()
    var idx = 0
    repeatFor(blocks) { b =>
        if (randomDouble(1) < 0.1) {
            val newBlocks = Array(
                Block(b.x, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x, b.y + b.h / 2, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y, b.w / 2, b.h / 2, b.c),
                Block(b.x + b.w / 2, b.y + b.h / 2, b.w / 2, b.h / 2, b.c)
            )
            blocks2.appendAll(newBlocks)
        }
        else {
            blocks2.append(b)
        }
        idx += 1
    }
}

def drawBlock(b: Block) {
    val pic = shape(b.w, b.h)
    pic.setPosition(b.x, b.y)
    pic.setPenThickness(0.5)
    val d = distance(b.x, b.y, mouseX, mouseY)
    val f = mathx.map(d, 0, 250, 0.2, 0.9)
    val a = math.atan2(mouseY - b.y, mouseX - b.x)
    pic.setPenColor(cm.gray)
    pic.setFillColor(b.c.fadeOut(f / 2))
    pic.scale(mathx.constrain(f, 0.6, 1.3))
    pic.rotate(a.toDegrees)
    draw(pic)
}

setup {
    repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
        repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
            makeBlock(posX, posY)
        }
    }
    splitSomeBlocks()
}

draw {
    erasePictures()
    repeatFor(blocks2) { b =>
        drawBlock(b)
    }
}
```
