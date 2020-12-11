<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Functional Programming

This activity has the following desired goals:
* Learning about functional programming (**A, M**).

---

### Topics to be discussed

* computing with pure functions and data flow.
* immutable data (and data structures).
* functions as values.
* comparison of the imperitive and functional way of doing something (with an example).


### Sample algorithms
***Imperative Style***
```scala
val numList = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
var result = 0;
repeatFor(numList) { n =>
    if (n % 2 == 0) {
        result += n * 10
    }
}
println(result)
```

***Functional Style***
```scala
val result = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    .filter(n => n % 2 == 0)
    .map(a => a * 10)
    .reduce((a, b) => a + b)

println(result)
```