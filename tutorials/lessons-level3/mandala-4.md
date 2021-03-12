<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 3 Index</a> | <a href="/modules/modules-index.html">Modules</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Sample Mandala 4

This activity has the following desired goals:
* Learning how the pre-defined mandala building blocks can be brought together to create a Mandala (**A, M**).
* Learn to refine a given piece of artistic code to make it visually more pleasing.

### Setup

*If not already done*, download the [mandala-shapes.kojo](mandala-shapes.kojo) file and save it at a known location on your computer. 

This file contains definitions for all the pre-defined mandala building-block shapes that you played with in the [Mandala building blocks](mandala-building-blocks.html) lesson. You will include this file in your Mandala drawing code (as shown below), so that you have access to these shapes.

### Mandala Code

Type in the following code and run it:

```scala
// #include /path/to/mandala-shapes.kojo

// #include ~/Dropbox/mandala/shapes.kojo

// Things need to be added to this one 
cleari()
setBackground(darkGray)

val pics = ArrayBuffer.empty[Picture]


pics.append(penColor(white) * fillColor(noColor) -> inscribedTriangle(90, 270))

pics.append(penColor(white) * fillColor(noColor) -> Picture.circle(90))

repeatFor(0 to 8) { n =>
    val pic2 = penColor(white) * fillColor(noColor) ->
        semiCircPetal(90, n * 45, 45)
    pics.append(pic2)
}

repeatFor(0 to 8) { n =>
    val pic2 = penColor(white) * fillColor(noColor) ->
        openBookThing(90, n * 45, 15)
    pics.append(pic2)
}

pics.append(penColor(white) * fillColor(noColor) -> altar(180, 0.2, 90))


draw(pics.reverse)
```

<img src="mandala-4.png">

**Q1a.** How does the above code work? Explain to a friend.

### Exercise

Change the color scheme for the mandala. You can play with the following:
* Changing pen colors
* Changing fill colors
* Applying neural style transfer
