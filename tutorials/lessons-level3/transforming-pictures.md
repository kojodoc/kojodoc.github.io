<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 3 Index</a> | <a href="/modules/modules-index.html">Modules</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Transforming Pictures

This activity has the following desired goals:
* Learning to transform pictures (**A, M**).

### Step 1

Type in the following code and run it:

```scala
cleari()
showAxes()
val pic = trans(100, 0) * rot(45) * penColor(blue) -> Picture.rectangle(100, 50)
draw(pic)
```

**Q1a.** What does the above code do? Explain to a friend.

---

### Step 2

Type in the following code and run it:

```scala
cleari()
showAxes()
val pic = Picture.rectangle(100, 50)
pic.translate(100, 0)
pic.rotate(45)
pic.setPenColor(blue)
draw(pic)
```

**Q2a.** What does the above code do? How is it different from the code in step 1? Explain to a friend.

---

### Explanation

You can transform pictures in the following main ways (via a tranformation object/function or a transformation method/command):

| Transformation | Object/function | Method/command |
| :--- | :--- | :--- |
| rotate | `rot(angle) -> pic` | `pic.rotate(angle)` |
| scale (to make bigger or smaller) | `scale(f) -> pic` | `pic.scale(f)` |
| translate (in its local coordinate system) | `trans(x, y) -> pic` | `pic.translate(x, y)` |
| translate (in its parent's coordinate system) | `offset(x, y) -> pic` | `pic.offset(x, y)` |
| change pen color | `penColor(color) -> pic` | `pic.setPenColor(color)` |
| change pen thickness | `penThickness(t) -> pic` | `pic.setPenThickness(t)` |
| set no pen | `noPen -> pic` | `pic.setNoPen()` | 
| change fill color | `fillColor(color) -> pic` | `pic.setFillColor(color)` |
| set opacity | `opac(o) -> pic` | `pic.setOpacity(o)` | 
| position at a given location | | `pic.setPosition(x, y)` |
| rotate to a particular heading | | `pic.setRotation(angle)` |
| rotate to a particular heading (alternative way) | | `pic.setHeading(angle)` |
| scale to a particular size | | `pic.setScale(scale)` |

As shown above, there are two distinct ways of doing picture transformations:
* The object/function way, e.g., `trans(100, 0) -> pic` - which is useful while doing functional/compositional graphics. This way of doing transformations can be used only before a picture is drawn (and these transformations are applied when the picture is drawn).
* The method/command way, e.g.. `pic.translate(100, 0)` - which is useful while doing generative art or gaming. This way of doing transformations can be used before and after a picture is drawn.


Multiple transformations can be combined in the following ways:
* tranformation objects/functions are combined using `*`, e.g., `trans(100, 0) * rot(45) -> pic`
* transformation methods/commands are combined by sequential calls, e.g., `pic.translate(100, 0); pic.rotate(45)`

---

### Step 3

Type in the following code and run it

```scala
clear()
setSpeed(superFast)

def square(n: Int) {
    repeat(4) {
        forward(100)
        right(90)
    }
}

setFillColor(blue)
square(100)

right(90)
hop(100)
left(90)

square(100)
```

**Q3a.** How can you make the second square not blue?

Now type in the following code and run it:

```scala
cleari()

def sq = Picture.rectangle(100, 100)

val pic1 = fillColor(blue) -> sq
val pic2 = sq

val pics = picStack(pic1, trans(100, 0) -> pic2)

draw(pics)
```

**Q3b.** What do you think the picStack instruction does? Is it a command or function?

**Q3c.** How is the second piece of code (which is picture-graphics based) in this section different from the first piece of code (which is turtle-graphics based)?  
*Hint.* Think in terms of expression vs command oriented instructions.

---

#### Exercise

Use all the picture transfomation functions listed above to create and transform one or more rectangles.
