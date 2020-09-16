<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## The shape-block method - blocks move around circle

### Step 1

Type in the following code and run it:

```scala
def shape() {
    savePosHe()
    left(45)
    right(90, 100)
    right(90)
    right(90, 100)
    restorePosHe()
}

def block() {
    setFillColor(randomColor.fadeOut(0.7))
    shape()
    penUp()
    // rotate around circle of radius 200
    right(20, 200)
    penDown()
}

clear()
setSpeed(fast)
setPenColor(cm.darkSlateGray)
repeat(18) {
    block()
}
```

**Q1a** Why does the `shape` command have a `savePosHe` at the beginning and a `restorePosHe` at the end.

**Q1b** In the above design, what's the shape?

**Q1c** In the above design, what's the block?

**Q1d** How many times is the block repeated to make the above design?

---

### Explanation

Here's how designs are made using this method:
* You define a shape.
* You define a block.
  * The block calls the shape, picks the pen up, moves the turtle along a circle, and then puts the pen down, to be ready to make the next shape.
* You repeat the block the desired number of times to make the pattern.

### Exercise

Use the above idea to make a design.


