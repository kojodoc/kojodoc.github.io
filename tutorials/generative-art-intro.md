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