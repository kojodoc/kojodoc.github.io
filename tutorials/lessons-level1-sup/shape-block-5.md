<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## The shape-block method - blocks moves along grid

### Step 1

Type in the following code and run it:

```scala
clear()
setBackground(white)
setSpeed(superFast)
setPenColor(cm.gray)

val nx = 20
val ny = 20
val cb = canvasBounds
val dx = cb.width / nx
val dy = cb.height / ny

def shape() {
    savePosHe()
    right(random(-5, 5))
    val len = dy / 2 + randomDouble(dx)
    repeat(4) {
        forward(len)
        right(90)
    }
    restorePosHe()
}

def posx(gx: Int) = cb.x + gx * dx
def posy(gy: Int) = cb.y + gy * dy

def block(gx: Int, gy: Int) {
    setPosition(posx(gx), posy(gy))
    setFillColor(randomColor.fadeOut(0.2))
    shape()
}

repeatFor(0 until nx) { x =>
    repeatFor(0 until ny) { y =>
        block(x, y)
    }
}
```

**Q1a** In the above design, what's the shape?

**Q1b** In the above design, what's the block? Why does the block command take two inputs?

**Q1c** How many times is the block repeated to make the above design?

**Q1d** Are `posx` and `posy` commands or functions? What do they do? How are they used?

---

### Explanation

Here's how designs are made using this method:
* You define a shape.
* You define a block.
  * The block calls the shape, picks the pen up, moves the turtle along a grid, and then puts the pen down, to be ready to make the next shape.
* You repeat the block the desired number of times to make the pattern.

### Exercise

Use the above idea to make a design.


