<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## The shape-block method - blocks moves along spiral

### Step 1

Type in the following code and run it:

```scala
clear()
setSpeed(fast)
setPenColor(darkGray)

def shape() {
    circle(10)
}

def block(n: Int) {
    setFillColor(randomColor.fadeOut(0.2))
    shape()
    penUp()
    right(15, n*2)
    penDown()
}

repeatFor(1 to 150) { n =>
    block(n)
}
```

**Q1a** In the above design, what's the shape?

**Q1b** In the above design, what's the block? Why does the block command take an input?

**Q1c** How many times is the block repeated to make the above design?

---

### Explanation

Here's how designs are made using this method:
* You define a shape.
* You define a block.
  * The block calls the shape, picks the pen up, moves the turtle along a spiral, and then puts the pen down, to be ready to make the next shape.
* You repeat the block the desired number of times to make the pattern.

### Exercise

Use the above idea to make a design.


