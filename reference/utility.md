<div class="nav">
  <a href="../index.html">Home</a> | <a href="../references-index.html">References</a>
</div>

This page contains descriptions of general purpose utility commands and functions available in Kojo.

### Environment

| Command/Function | Description |
| :--- | :--- |
| `size(w, h)` | sets the size of the canvas to the given width and height. |
| `cwidth`  | returns the current width of the canvas. |
| `cheight`  | returns the current height of the canvas. |
| `originBottomLeft()`  | situates the origin at the bottom left of the canvas. |
| `setup { drawing code }` | calls the drawing code once at the beginning of your program. |
| `drawLoop { drawing code }` | calls the drawing code at the default refresh rate, which is 50 times a second. |
| `setRefreshRate(n)` | sets the refresh rate to `n` times per second. The next time a `clear()` is done, the refresh rate is reset to its default value of 50. |
| `erasePictures()` | erases all the pictures in the canvas. |

### Random numbers

| Command/Function | Description |
| :--- | :--- |
| `random(upperBound)` | Returns a random integer between `0` (inclusive) and `upperBound` (exclusive). |
| `random(lowerBound, upperBound)` | Returns a random integer between `lowerBound` (inclusive) and `upperBound` (exclusive). |
| `randomDouble(upperBound)` | Returns a random decimal fraction between `0` (inclusive) and `upperBound` (exclusive). |
| `randomDouble(lowerBound, upperBound)` | Returns a random decimal fraction between `lowerBound` (inclusive) and `upperBound` (exclusive). |
| `randomNormalDouble` | Returns a normally distributed number with mean `0` and standard deviation `1`. |
| `randomBoolean` | Returns a random boolean value. This is like a coin toss. |
| `randomFrom(seq)` | Returns a random value from the given sequence. |
| `randomFrom(seq, weights)` | Returns a random value from the given sequence as per the given distribution of weights. |
| `randomColor` | Returns a random color. |
| `initRandomGenerator()` | Initializes the Kojo random number generater with a random seed, and prints out the seed for future reference. |
| `initRandomGenerator(seed)` | Initializes the Kojo random number generater with the given seed (potentially obtained via the previous command) to enable the reproducing of random patterns. |

### Math

| Function | Description |
| :--- | :--- |
| `mathx.map(value, start1, stop1, start2, stop2)` | Maps the given value from the range `(start1, stop1)` to the range `(start2, stop2)`. |
| `mathx.lerp(start, stop, amt)` | Returns the interpolation as per the given fraction `amt` in the range `(start, stop)`. |
| `mathx.constrain(value, min, max)` | Constrains the given `value` between `min` and `max`. |
| `mathx.distance(x1, y1, x2, y2)` | Calculates the distance between (x1, y1) and (x2, y2). |
| `mathx.distance(point1, point2)` | Calculates the distance between point1 and point2. |
| `mathx.angle(x1, y1, x2, y2)` | calculates the angle in degrees between the line from (x1, y1) to (x2, y2) and the horizontal. |
| `mathx.angle(point1, point2)` | calculates the angle in degrees between the line from point1 to point2 and the horizontal. |
| `rangeTill(from, untill, step)` | returns a range that starts from `from`, goes until (but excluding) `until`, and steps up by `step`. [See example](#rangetill). |

### Colors

| Function | Description |
| :--- | :--- |
| `cm.hsl(hueAngle, saturationFraction, lightnessFraction)` | Creates a color with the given hue, saturation, and lightness. |
| `cm.hsla(hueAngle, saturationFraction, lightnessFraction, opacityFraction)` | Creates a color with the given hue, saturation, lightness, and opacity. |
| `cm.linearGradient(x1, y1, c1, x2, y2, c2, cyclic)` | Creates a linear color gradient between color `c1` at position `(x1, y1)` and color `c2` at position `(x2, y2)`. The `cyclic` parameter specifies whether the gradient should be repeated or not. |
| `cm.radialGradient(cx, cy, c1, radius, c2, cyclic)` | Creates a radial color gradient between color `c1` at the center of a circle positioned at `(x1, y1)` and color `c2` at a distance `radius` from the center. The `cyclic` parameter specifies whether the gradient should be repeated or not. |
| `cm.linearMultipleGradient(x1, y1, x2, y2, distribution, colors, cyclic)` | Creates a linear color multi-gradient between position `(x1, y1)` and position `(x2, y2)`. The gardient is spread across this range as per the `distribution` and `colors`; `distribution` is a sequence of fractions, and `colors` is a sequence of colors. Both sequences should have the same number of elements. So, for example, if the `distribution` is `Seq(0, 0.4, 1)` and colors is `Seq(red, blue, green)`, then the multi-gradient will be made out of `red` at the beginning of the range, `blue` at 40% of the range, and `green` at the end of the range. The `cyclic` parameter specifies whether the gradient should be repeated or not. |
| `cm.linearMultipleGradient(x, y, r, distribution, colors, cyclic)` | Creates a radial color multi-gradient between position `(x, y)` as the center of a circle with radius `r` and the boundary of this circle. The gardient is spread across this range as per the `distribution` and `colors`; `distribution` is a sequence of fractions, and `colors` is a sequence of colors. Both sequences should have the same number of elements. So, for example, if the `distribution` is `Seq(0, 0.4, 1)` and colors is `Seq(red, blue, green)`, then the multi-gradient will be made out of `red` at the beginning of the range, `blue` at 40% of the range, and `green` at the end of the range. The `cyclic` parameter specifies whether the gradient should be repeated or not. |

### Misc

| Function | Description |
| :--- | :--- |
| `isKeyPressed(keyCode)` | Returns true if the given key is currently pressed on the keyboard. Otherwise returns false. |
| `joystick(radius)` | Creates a joystick control with the given radius. |
| `js.currentVector` | Tells you the current vector for the joystick `js`. This vector is defined by two points - the center of the joystick control, and the center of the moveable joystick circle. |
| `js.movePlayer(pic, scaleFactor)` | For the joystick `js`, moves the player based on the movement of the joystick circle, as per the `currentVector` defined above. You can scale the currentVector by using `scaleFactor` to make the movement faster (`scaleFactor` > `1`) or slower (`scaleFactor` < `1`). |


### Examples

#### rangeTill

```scala
rangeTill(4, 10, 2).toArray //> res16: Array[Int] = Array(4, 6, 8)
rangeTill(4, 11.5, 2.5).toArray //> res17: Array[BigDecimal] = Array(4.0, 6.5, 9.0)
```



