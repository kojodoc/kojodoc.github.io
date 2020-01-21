<div class="nav">
  <a href="../index.html">Home</a> | <a href="../gaming-index.html">Gaming</a> | <a href="../references-index.html">References</a>
</div>

> <img src="../man-at-work.png"/> <br/> *This section of the website is currently under development*.

## Gaming Reference

* `drawStage(color)` - draws a stage on the canvas with the given color. The stage border can be used for collision detection with game objects to keep them within the canvas.
* `canvasBounds` - returns the bounds of the canvas within an object that has `x`, `y`, `width`, and `height` data values.
* `Picture { turtle drawing }` - creates a picture out of a turtle shape.
  * The turtle shape can be made by using the [turtle primitives](../reference/turtle.html).
* `Picture.image(fileName)` - creates a picture from an image file.
* `pic.draw()` - draws the given picture on the canvas. Just creating a picture does not draw it. The creation via a function and the drawing via a command are separate operations.
* `pic.translate(x, y)` - moves the picture named `pic` on the canvas by the given amount.
* `pic.rotate(angle)` - rotates the picture around its origin by the given angle.
* `pic.rotateAboutPoint(x, y, angle)` - rotates the picture by the given angle around the given (x, y) in the local coordinate system of the picture.
* `pic.setPosition(x, y)` - sets the position of the picture named `pic` to be the given (x, y) on the canvas.
* `pic.collidesWith(otherPic)` - checks to see if `pic` is in collision with `otherPic`.
* `pic.onMouseClick { { (x, y) => code }` - runs the given code when the mouse is clicked on the picture. The code has access to the (x, y) of the mouse click.
* `bouncePicVectorOffStage(pic, vel)` - computes a new velocity for `pic` moving with `velocity` that collides with the stage border.
* `Vector2D(x, y)` - creates a vector with the two given components. The vector specifies a magnitude and a direction.
* `animate { code }` - schedules your code to be called approximately fifty times per second.
