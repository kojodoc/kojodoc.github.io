<div class="nav">
  <a href="../index.html">Home</a>
</div>

## An introduction to generative art using Kojo

Generative art is art that is generated via an interaction between a computer program and a human being.  
Todo

In this tutorial, you will play with generative art in the context of a grid. Here is what you will do:
* Revisit the [grid section](../art/shape-block.html#block-moves-around-grid) from the [shape-block method page](../art/shape-block.html).
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
```scala
size(600, 600)
cleari()
setSpeed(superFast)
setBackground(white)
originBottomLeft()

val tileCount = 10
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape() {
    repeat(2) {
        forward(tileHeight)
        right(90)
        forward(tileWidth)
        right(90)
    }
}

def block(posX: Double, posY: Double) {
    setPosition(posX, posY)
    setPenColor(black)
    shape()
}

repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
        block(posX, posY)
    }
}
```

### Picture grid
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
    draw(pic)
}

repeatFor(rangeTill(0, cheight, tileHeight)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileWidth)) { posX =>
        block(posX, posY)
    }
}
```

### Dynamic Picture Grid
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
    val d = distance(posX, posY, mouseX, mouseY)
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

```scala
size(600, 600)
cleari()
setBackground(white)
originBottomLeft()

val tileCount = 20
val tileWidth = cwidth / tileCount
val tileHeight = cheight / tileCount

def shape = Picture {
    repeatFor(30 to 60) { n =>
        forward(n)
        right(91)
    }
}

def block(posX: Double, posY: Double) {
    val pic = shape
    pic.setPosition(posX, posY)
    pic.setPenThickness(1)
    val d = distance(posX, posY, mouseX, mouseY)
    val f = mathx.map(d, 0, 500, 0.2, .9)
    pic.setPenColor(black.fadeOut(f))
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
