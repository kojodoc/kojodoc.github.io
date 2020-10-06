<div class="nav">
  <a href="../index.html">Home</a> | <a href="../picture-index.html">Picture Graphics</a> | <a href="../references-index.html">References</a>
</div>

## Picture Graphics Reference

### Picture Creation

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
| `Picture.hgap(width)` |  Creates an invisible picture with the given width. This can be used during picture layout - to provide horizontal spacing. |
| `Picture.vgap(height)` |  Creates an invisible picture with the given height. This can be used during picture layout - to provide vertical spacing. |
| `Picture.image(fileName)` | Creates a picture with the image in the given file. |
| `Picture.image(fileName, envelope)` | Creates a picture with the image in the given file, and with the given envelope for the picture's (collision) geometry. |
| `Picture.image(url)` | Creates a picture with the image at the given file link. |
| `Picture.image(image)` | Creates a picture with the given image. |

### Picture Transformation

| Transformation | Object/function | Method/command |
| :--- | :--- | :--- |
| rotate | `rot(angle) -> pic` | `pic.rotate(angle)` |
| scale | `scale(f) -> pic` | `pic.scale(f)` |
| translate (in its local coordinate system) | `trans(x, y) -> pic` | `pic.translate(x, y)` |
| translate (in its parent's coordinate system) | `offset(x, y) -> pic` | `pic.offset(x, y)` |
| position at a given location | `offset(x, y) -> pic` (one time) | `pic.setPosition(x, y)` |
| change pen color | `penColor(color) -> pic` | `pic.setPenColor(color)` |
| change pen thickness | `penThickness(t) -> pic` | `pic.setPenThickness(t)` |
| set no pen | `noPen -> pic` | `pic.setNoPen()` | 
| change fill color | `fillColor(color) -> pic` | `pic.setFillColor(color)` |
| set opacity | `opac(o) -> pic` | `pic.setOpacity(o)` | 

### Picture Layout

| Layout type | Function for layout (with centering) | Function for layout (without centering) |
| :--- | :--- | :--- |
| stack - one over the other | `picStackCentered(pic1, pic2, ...)` | `picStack(pic1, pic2, ...)` |
| row - left to right | `picRowCentered(pic1, pic2, ...)` | `picRow(pic1, pic2, ...)` |
| column - bottom to top | `picColCentered(pic1, pic2, ...)` | `picCol(pic1, pic2, ...)` |


### Picture Effects

* [Image filters from JH Labs](http://www.jhlabs.com/ip/filters/). 
  * [JavaDoc and source code](https://github.com/litan/jhlabs-image-filters/tree/master/src/com/jhlabs/image).

### Picture Drawing

* `draw(pic)` - draws the picture.
* `pic.draw()` - similar to the above.
* `drawCentered(pic)` - draws the picture centered in the canvas.

#### Debugging
* `Picture.showAxes(pic)`
* `Picture.showAxes(pic1, pic2, ...)`
* `Picture.showBounds(pic)`
* `Picture.showBounds(pic1, pic2, ...)`

### Picture Animation
`animate { }` loop.

Transformations useful during animation and gaming:
* `pic.invisible()` - hides `pic`.
* `pic.visible()` - makes hidden `pic` visible again.
* `pic.erase()` - erases `pic` and removes it from the canvas.

### Picture Collisions
* `pic.collidesWith(stageBorder)` - returns true if `pic` has collided with the stage border.
bouncing off the stage.
* `pic.collidesWith(other: Picture)` - returns true if `pic` has collided with `other`.
* `pic.collisions(others: Set[Picture])` - returns the subset of pictures within `others` that `pic` has collided with.
* `pic.collision(others: Seq[Picture])` - returns an Option with the first picture in `others` that pic has collided with.
* `bouncePicOffStage(pic, vel)` - for a picture `pic` moving with velocity `vel` - this function returns the velocity after bouncing off the stage.
* `bouncePicOffPic(pic: Picture, vel: Vector2D, obstacle: Picture)`- for a picture `pic` moving with velocity `vel` - this function returns the velocity after bouncing off `obstacle`.

### Picture Event Handling

* `pic.onMouseClick { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is clicked inside the picture.
* `pic.onMousePress { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is pressed inside the picture.
* `pic.onMouseRelease { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is released inside the picture.
* `pic.onMouseMove { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse moves inside the picture.
* `pic.onMouseDrag { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse is dragged inside the picture.
* `pic.onMouseEnter { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse enters the picture.
* `pic.onMouseExit { (x, y) => handler code }` - The supplied code is called, with the current mouse position as input, when the mouse exits the picture.

