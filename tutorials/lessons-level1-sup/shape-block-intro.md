<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## The shape-block method for design

This activity has the following desired goals:
* Learning the shape-block design method (**A, M**).
* Learning to apply the shape-block method to make pleasing drawings (**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
def shape() {
    repeat(5) {
        forward(100)
        right(360 / 5)
    }
}

def block() {
    setFillColor(randomColor.fadeOut(0.7))
    shape()
    right(20)
}

clear()
setSpeed(fast)
setBackground(white)
setPenColor(cm.darkSlateGray)
repeat(18) {
    block()
}
```

**Q1a** What does the `shape` command do in the above code?

**Q1b** What does the `block` command do in the above code?

**Q1c** How are `shape` and `block` combined to make the final figure?

---

### Explanation

The shape/block method builds upon the ideas in the forty-patterns section at the end of the [Getting Started](http://wiki.kogics.net/kojo-codeactive-books#getting-started) book. 

In that section you focused on analysing a given pattern, determining the shape and the block present in the pattern, and then drawing the pattern in a structured and systematic way using the shape/block method.

Here, you will investigate the use of the shape/block method to *design new patterns*.

**Quick Recap**
* In any pattern, the **shape** is the core shape that makes up the pattern.
* The **block** draws the shape and then moves/turns the turtle so that it's ready to draw the next shape.
  * Note - after the turtle draws a shape, its position and heading should be the same as they were before drawing the shape - so that the block can easily combine multiple shapes. The `savePosHe()` and `restorePosHe()` commands can be used at the beginning and the end respectively of the `shape()` command to help accomplish this.
* Once the shape and the block are in place, the pattern is drawn by repeating the block the desired number of times.

To implement the above ideas, it's good to know [how defs work](../../reference/turtle.html#def).

---

### Exercise

Draw a design using the shape-block method.