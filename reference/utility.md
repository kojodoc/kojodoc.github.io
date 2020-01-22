<div class="nav">
  <a href="../index.html">Home</a> | <a href="../references-index.html">References</a>
</div>

This page contains descriptions of general purpose utility commands and functions available in Kojo.

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
| `mathx.map(value, low1, high1, low2, high2)` | Maps the given value from the range `(low1, high1)` to the range `(low2, high2)`. |
| `mathx.lerp(value1, value2, amt)` | Returns the interpolation as per the given fraction `amt` in the range `(value1, value2)`. |
| `mathx.constrain(value, min, max)` | Constrains the given `value` between `min` and `max`. |



