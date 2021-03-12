<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 3 Index</a> | <a href="/modules/modules-index.html">Modules</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Drawing with Pictures

This activity has the following desired goals:
* Learning to make pictures out of turtle drawings (**A, M**).
* Learning to use `Picture.rectangle` and other picture making functions (**A, M**).


### Step 1

Type in the following code and run it:

```scala
cleari()

val pic = Picture {
    repeat(5) {
        forward(50)
        right(72)
    }
}

draw(pic)
```

**Q1a.** Is `Picture` a command or function? What do you think it does?

**Q1b.** Is `draw` a command or function? What do you think it does?

---

### Explanation

A picture is a visual element in Kojo - made out of turtle drawings (and in other ways, as you will see in a bit). Given a picture:
* You can draw it.
* You can align it with other pictures.
* You can translate, scale, or rotate it.
* You can change its transparency.
* You can apply effects to it.
* You can animate it.
* You can detect collisions with other pictures

This opens up many possibilites in terms of generative art, gaming, and a deeper look at programming.

---

### Step 2

Type in the following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)

draw(pic)
```

**Q2a.** Is `Picture.rectangle` a command or function? What do you think it does?

**Q2b.** What does the `.` in `Picture.rectangle` signify?


---

### Explanation

For well defined shapes (like rectangles, ellipses, lines, etc.), you can create a Picture directly (by using the appropriate function in the Picture object, like above) without having to make a turtle drawing. The advantage of this is that it is easier to code and has better runtime performance. But this works only for predefined simple shapes. For custom shapes, you can always make a turtle drawing and put it in a Picture.

The `.` in the function name specifies that the function is being called via an object.

---

### Step 3

Type in the following code and run it:

```scala
cleari()
showAxes()
val pic1 = Picture.rectangle(100, 50)
val pic2 = Picture.circle(50)
draw(pic1, pic2)
```

**Q3a.** What does the above code do? Explain to a friend.

---

### Explanation

A picture can be created using any one of the functions shown below. As you use these functions, there are a couple of things that you should be aware of:  
* A newly created picture is located at at the canvas position (0, 0) to begin with. It can then be positioned at any other location by using the `pic.setPosition(x, y)` command or being part of a row, column, or stack of pictures.
* Normally, a picture's position is the location of it's bottom-left corner. Exceptions to this are the ellipse, the circle, and the arc, which are positioned at their center.

| Function | Description |
| :--- | :--- |
| `Picture {turtle drawing code}` | Creates a picture from the given turtle drawing. |
| `Picture.line(width, height)` | Creates a picture of a line with the given width and height. |
| `Picture.rectangle(width, height)` | Creates a picture of a rectangle with the given width and height. |
| `Picture.circle(radius)` | Creates a picture of a circle with the given radius. The center of the circle is at (0, 0) |
| `Picture.ellipse(xRadius, yRadius)` | Creates a picture of an ellipse with the given xRadius and yRadius. The center of the ellipse is at (0, 0) |
| `Picture.ellipseInRect(width, height)` | Creates a picture of an ellipse with the given width and height. |
| `Picture.point` | Creates a picture of a point. |
| `Picture.arc(radius, angle)` | Creates a picture of an arc with the given radius and angle. The center of the arc is at (0, 0). |
| `Picture.text(string)` | Creates a picture with the given text. |
| `Picture.hgap(width)` | Creates an invisible picture with the given width. This can be useful during picture layout |
| `Picture.vgap(width)` | Creates an invisible picture with the given height. This can be useful during picture layout |
| `Picture.image(fileName)` | Creates a picture with the image in the given file. |
| `Picture.image(url)` | Creates a picture with the image at the given file link. |
| `Picture.image(image)` | Creates a picture with the given image. |

---

#### Exercise

Use all the picture creation functions listed above (except `hgap` and `vgap`) to create and draw pictures.
