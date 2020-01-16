<div class="nav">
  <a href="../index.html">Home</a>
</div>

## An introduction to pictures
A picture is a visual element in Kojo. To work with a picture, you do the following:
* [Create the picture](#picture-creation)
* Transform it and align it with other pictures (optional)
* Attach mouse event handlers to it (optional)
* Draw it
* Animate it as you continue to transform it (optional)
* Check for collisions with other pictures (optional)
* Interact with it as a user via the event handlers(optional)

The above Picture capabilites enable the following:
* Functional art
* Generative art
* Gaming

### Picture creation
Pictures can be created in many different ways using any one of the following functions:  
*Note* - these pictures are located at at the canvas position (0, 0) to begin with. They can be positioned at any other location by using the setPosition command or being part of a row, column, or stack of pictures.

| Function | Description |
| :--- | :--- |
| `Picture {turtle drawing code}` | Creates a picture from the given turtle drawing. |
| `Picture.line(width, height)` | Creates a picture of a line with the given width and height. |
| `Picture.rectangle(width, height)` | Creates a picture of a rectangle with the given width and height. |
| `Picture.circle(radius)` | Creates a picture of a circle with the given radius. The center of the circle is at (0, 0) |
| `Picture.ellipse(xRadius, yRadius)` | Creates a picture of an ellipse with the given xRadius and yRadius. The center of the ellipse is at (0, 0) |
| `Picture.ellipseInRect(width, height)` | Creates a picture of an ellipse with the given width and height. |
| `Picture.arc(radius, angle)` | Creates a picture of an arc with the given radius and angle. The center of the arc is at (0, 0) |
| `Picture.text(string)` | Creates a picture with the given text |

#### Example

```scala
cleari()
val pic1 = Picture.rectangle(100, 50)
val pic2 = Picture.circle(50)
draw(pic1, pic2)
```

#### Exercise

Use all the picture creation functions to create and draw pictures (one of each kind).

### Picture transformation and alignment
You can transform pictures in the following main ways:
* translate - via `trans(x, y) -> pic` or `pic.translate(x, y)`
* position at a location - via `offset(x, y) -> pic` or `pic.setPosition(x, y)`
* rotate - via `rot(angle) -> pic` or `pic.rotate(angle)`
* scale - via `scale(f) -> pic` or `pic.scale(f)`
* change pen color - via `penColor(color) -> pic` or `pic.setPenColor(color)`
* change pen thickness - via `penThickness(t) -> pic` or `pic.setPenThickness(t)`
* change fill color - via `fillColor(color) -> pic` or `pic.setFillColor(color)`
