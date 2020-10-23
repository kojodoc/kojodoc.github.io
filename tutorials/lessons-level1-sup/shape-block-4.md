<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## The shape-block method - blocks move along ellipse

### Step 1

Type in the following code and run it:

```scala
clear()
setBackground(white)
setSpeed(fast)
setPenColor(cm.gray)

val nx = 20
val ny = 20
val cb = canvasBounds
val dx = cb.width / nx
val dy = cb.height / ny

def shape() {
    circle(10)
}

// the radii of the ellipse
val r1 = 200
val r2 = 100

// x and y are calculated based on the parametric form of the equation of an ellipse
def posx(a: Int) = r1 * math.cos(a.toRadians)
def posy(a: Int) = r2 * math.sin(a.toRadians)

def block(a: Int) {
    setPosition(posx(a), posy(a))
    setFillColor(randomColor.fadeOut(0.2))
    shape()
}

repeatFor(rangeTill(0, 360, 10)) { a =>
    block(a)
}

// viewRotate(45)
```

**Q1a** In the above design, what's the shape?

**Q1b** In the above design, what's the block? Why does the block command take an input?

**Q1c** How many times is the block repeated to make the above design?

**Q1d** Are `posx` and `posy` commands or functions? What do they do? How are they used?

**Q1e** How can you center the ellipse used by the block at `(100, 50)` instead of `(0, 0)`

**Q1f** How can you align the ellipse used by the block at an angle of 45 degrees to the horizontal?

---

### Explanation

Here's how designs are made using this method:
* You define a shape.
* You define a block.
  * The block calls the shape, picks the pen up, moves the turtle along an ellipse, and then puts the pen down, to be ready to make the next shape.
* You repeat the block the desired number of times to make the pattern.

**Command Description**

* `viewRotate(angle)` - rotates the contents of the drawing canvas by the given angle.

### Exercise

Use the above idea to make a design.
