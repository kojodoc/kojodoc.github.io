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
| `mathx.map(value, start1, stop1, start2, stop2)` | Maps the given value from the range `(start1, stop1)` to the range `(start2, stop2)`. |
| `mathx.lerp(start, stop, amt)` | Returns the interpolation as per the given fraction `amt` in the range `(start, stop)`. |
| `mathx.constrain(value, min, max)` | Constrains the given `value` between `min` and `max`. |
| `mathx.distance(x1, y1, x2, y2)` | Calculates the distance between (x1, y1) and (x2, y2). |
| `mathx.distance(point1, point2)` | Calculates the distance between point1 and point2. |
| `mathx.angle(x1, y1, x2, y2)` | calculates the angle in degrees between the line from (x1, y1) to (x2, y2) and the horizontal. |
| `mathx.angle(point1, point2)` | calculates the angle in degrees between the line from point1 to point2 and the horizontal. |
| `rangeTill(from, untill, step)` | returns a range that starts from `from`, goes until (but excluding) `until`, and steps up by `step`. [See example](#rangetill). |

### Examples

#### rangeTill

```scala
rangeTill(4, 10, 2).toArray //> res16: Array[Int] = Array(4, 6, 8)
rangeTill(4, 11.5, 2.5).toArray //> res17: Array[BigDecimal] = Array(4.0, 6.5, 9.0)
```



