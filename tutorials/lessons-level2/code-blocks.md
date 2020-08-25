<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Blocks of code

### Step 1

Type in following code and run it:
```scala
val x1 = 3 * 10 + 2
println(x1)

val x1b = {
    val a = 10
    val b = a * 3
    b + 2
}
println(x1b)
// println(a)
```

**Q1a.** What's the difference in the calculation done for computing x1 and x1b?

**Q1b.** In the calculation done for x1b, do you see how the curly brackets (which create a block of code), allow you to:
* use multiple steps in the calculation?
* introduce named values to help with the calculation?

**Q1c** What's the result of a block of code? If it has three instructions, one after the other, which produce values `v1`, `v2`, and `v3`, what's the value of the whole block?

**Q1d** Do you see how the value of a block of code is the value of the last instruction in it?


### Step 2

Type in following code and run it:
```scala
val x2 = { 
    clear()
    forward(100)
    right(90)
}

println(x2)
```

**Q2a.** What's the value of x2?

### Step 3

Type in following code and run it in Worksheet mode via *Shift+Enter*:
```scala
val x3 = right(90)
```

**Q3a.** What's the value of x3? What's its type?

### Step 4

Type in following code and run it in Worksheet mode via *Shift+Enter*:
```scala
val x4 = forward(100)
```

**Q4a.** What's the value of x4? What's its type?

**Q4b.** Do you see how (all) commands return the value `()`, whose type is `Unit`?  
The unit value `()` is meant to signify *no information* - and this makes sense based on what you have learned earlier - that commands carry out actions but do not return any information, as opposed to functions, which take in information and return new information.


### Step 5

Type in following code and run it (via *Ctrl+Enter*):
```scala
val x5 = { a: Int =>
    val b = a * 3
    b + 2
}

println(x5(10))
```

**Q5a.** Do you see how the block of code above takes an input, and does a calculation based on this input?


### Step 6

Type in following code and run it:
```scala
def x6(a: Int) = {
    val b = a * 3
    b + 2
}

println(x6(10))
```

**Q6a.** What's the similarity between `x5` and `x6`?

**Q6b.** What's the difference between `x5` and `x6`?

Notice that in Step 5, first an *un-named block of code that takes an input* is created, and then it is given the name `x5` via the `val` keyword instruction. In Step 6, a *named block of code that takes an input* is directly created via the `def` keyword instruction -- with the name `x6`?

The *named block of code* above cannot exist without its name. But the *un-named block of code* can. To convince yourself of this, type in the following code and run it via *Shift+Enter*:
```scala
(
    { a: Int =>
        val b = a * 3
        b + 2
    }
)(10)
```

Do you see how the *un-named block of code that takes an input* is used above without giving it an intermediate name.

A *named block of code that takes an input* is called a user-defined command or function, while an *un-named block of code that takes an input* is called an anonymous command or function.

### Step 7

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

**Q7a.** Describe what the above code is doing.

**Q7b.** Do you see that the second input to `repeatFor` is a block of code that takes one input? Why does repeatFor want such an input?

**Q7c.** Can you identify the named code block in the code above? Can you identify the un-named code block?

**Q7d.** What's the benefit of a named block of code (user-defined command or function)? What's the drawback?

**Q7e.** What's the benefit of an un-named block of code (anonymous command or function)? What's the drawback?

