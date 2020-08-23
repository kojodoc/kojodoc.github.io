<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Understanding the second input to repeatFor

### Step 1

Type in following code and run it:

```scala
clearOutput()
def printBoth(n1: Int, n2: Int) {
    println(n1)
    println(n2)
}

printBoth(10, 12)
```

**Q1a.** Is `printBoth` a command or a function?

**Q1b.** On which line is `printBoth` defined?

**Q1c.** On which line is `printBoth` used?

**Q1d.** How many inputs does `printBoth` take?

### Step 2

Type in following code and run it:

```scala
clearOutput()
def printBothV2(n1: Int)(n2: Int) {
    println(n1)
    println(n2)
}

printBothV2(10)(12)
```

**Q2a.** How is the definition of `printBothV2` different from the definition of `printBoth`?

**Q2b.** How is the usage of `printBothV2` different from the usage of `printBoth`?

### Step 3

Type in following code and run it:

```scala
clearOutput()
def repeatForBoth(n1: Int, n2: Int)(cmd: Int => Unit) {
    cmd(n1)
    cmd(n2)
}

def printInt(n: Int) {
    println(n)
}

repeatForBoth(10, 12)(printInt)

repeatForBoth(10, 12) { n =>
    println(n)
}
```

**Q3a.** What are the inputs to `repeatForBoth`? Notice that when an input is a command, the input and the result of the command are separated by a `=>`.

**Q3b.** How does `repeatForBoth` make use of its inputs?

**Q3c.** How are the two usages of `repeatForBoth` different? Do you see how the first call to `repeatForBoth` uses a named command (defined earlier), while the second call uses an unnamed command (defined right at the point of usage). Notice how the input and body of the anonymous command are separated by a `=>`.

### Step 4

Type in following code and run it:

```scala
clearOutput()

val ab = ArrayBuffer(2, 9, 3)

def printInt(n: Int) {
    println(n)
}

repeatFor(ab)(printInt)

repeatFor(ab) { n =>
    println(n)
}
```

**Q4a.** Describe what the above code is doing.

**Exercise** - Create an ArrayBuffer with the first 5 prime numbers as elements. Then use repeatFor to go through (or iterate over) the elements and print them. 