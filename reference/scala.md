To best understand the content below, it us useful for you to be familiar with the following ideas:
* [Program Structure](../concepts/scala-essentials#program-structure)
* [Program Operation](../concepts/scala-essentials#program-operation)
* [Program Development](../concepts/scala-essentials#program-development)


## Scala Quick Reference
---

* [1. Data Types](#data)
* [1.1 Int](#data-int)
* [1.2 Double](#data-double)
* [1.3 Boolean](#data-boolean)
* [1.4 String](#data-string)
* [1.5 Color](#data-color)
* [1.6 Picture](#data-picture)

* [1.7 Collections](#data-collections)
* [1.7.1 Sequence (Seq)](#data-sequence)
* [1.7.1.1 ArrayBuffer](#data-arraybuffer)
* [1.7.2 Map](#data-map) (*Todo*)
* [1.7.3 Set](#data-set) (*Todo*)

---

* [2. Control Flow](#control)
* [2.1 Sequencing](#control-sequencing)

* [2.2 Loops](#control-loops)
* [2.2.1 repeat](#control-repeat)
* [2.2.2 repeatFor](#control-repeatFor)
* [2.2.3 for](#control-for)

* [2.3 Selection](#control-selection)
* [2.4 Calls](#control-calls)

---

<a name="data">
**1. Data Types**

A program is nothing without data. It starts out with some data values, and computes new values from old values as it runs ([as explained elsewhere](./concepts/scala-essentials#program-operation)). So learning about data is important.

Here is some background information before we start looking at different types of data:

* A single piece of data is called a value.
* In Scala, every data value is an object. 
* An object combines data with functions/commands. The functions/commands attached to an object are called its methods.
* Every object value has a type.
* A type determines a set of possible values and the operations that can be done with these values.

The following are some of the different types of data supported by Scala.

<a name="data-int">
**1.1 Int**

Ints represent integral data. e.g. `1`, `3`, `5`, `-4`, `-9`.  
The usual math operations/functions (`+`, `-`, `*`, `/`, `>`, `>=`, `<`, `<=`, `==`, `!=`) are supported for integers.  
Note that some of the above functions return Int values, while others return Boolean values.
```scala
2 + 3 //> res23: Int = 5
3 + (2 * 5) - (10 * 2) //> res24: Int = -7
2 > 10 //> res25: Boolean = false
```
The above code shows some operations on integers after running (in Kojo) in *Worksheet* mode via `Shift+Enter`. Each expression in the above code is followed by `//>` and then `name: type = value`, where name is a Kojo assigned name for the value of the expression.

<a name="data-double">
**1.2 Double**

Doubles represent fractional data. e.g. `1.5`, `3.2`, `5.3`, `-4.1`, `-9.8`.  
The usual math operations/functions (`+`, `-`, `*`, `/`, `>`, `>=`, `<`, `<=`, `==`, `!=`) are supported for doubles.  
Note that some of the above functions return Double values, while others return Boolean values.
```scala
2.1 + 3.2 //> res40: Double = 5.300000000000001
3.1 + (2.2 * 5.05) - (10 * 2) //> res41: Double = -5.789999999999999
2.1 > 10 //> res42: Boolean = false
```

<a name="data-boolean">
**1.3 Boolean**

Booleans represent true/false data.  
The usual math operations/functions (`&&`, `||`, `==`, `!=`, `!`, `^`) are supported for booleans.
```scala
2 > 10 //> res34: Boolean = false
(10 > 2) && (3 > 11) //> res35: Boolean = false
(10 > 2) && (3 > 11) || (4 < 5) //> res36: Boolean = true
!true //> res37: Boolean = false
true ^ false //> res38: Boolean = true
true ^ true //> res39: Boolean = false
```
Booleans are important because they are used in conditions.

<a name="data-string">
**1.4 String**

Strings are used to communicate textual information to/from a program. e.g. "Hello World", s"Your score is $score".
```scala
val n = readInt("Enter a number")
val n2 = 2 * n
println(s"Twice the number you entered is $n2")
```

<a name="data-color">
**1.5 Color**

Colors are used to represent visual colors in drawings, games, etc. e.g. blue, green, red.
```scala
clear()
setPenColor(cm.brown)
setFillColor(cm.yellow)
repeat(4) {
    forward(100)
    right(90)
}
```
[Read more about colors](../concepts/colors.html)

<a name="data-picture">
**1.6 Picture**

Pictures are a Kojo defined data type. Pictures are visual elements that can be translated, scaled, rotated, spatially arranged, etc.

Here's an example of a Picture being operated on by transforms, as one would normally do while drawing:
```scala
def p = Picture {
    repeat(4) {
        forward(30)
        right(90)
    }
}

cleari()
showAxes()
val pic1 = p
val pic2 = trans(100, 0) * rot(45) * scale(2) -> p
draw(pic1, pic2)
```

Here's an example of a Picture being operated on by methods, as one would normally do in a game:
```scala
val pic = Picture {
    repeat(4) {
        forward(30)
        right(90)
    }
}

cleari()
showAxes()
draw(pic)
animate {
    pic.translate(1, 0)
    pic.rotate(1)
    pic.scale(1.001)
}
```

<a name="data-collections">
**1.7 Collections**

Collections let you organise the data in your program in particular ways (depending on the nature of the collection). Some useful collections are:

<a name="data-sequence">
**1.7.1 Sequence (Seq)**

A sequence is a bunch of data values arranged one after the other with a well defined order of elements. e.g. `Seq(1, 5, 3)`.  
If you want to arrange some data in your program in a sequence, and the sequence is fixed, you can use `Seq` to construct the sequence.
```scala
val names = Seq("name1", "name2", "name3")
// assume pic1, pic2, pic3 are defined earlier in your program
val pictures = Seq(pic1, pic2, pic3)
```

Once your data is in a sequence, you can do multiple things with the sequence. Three of the most important operations on a sequence are the following:
* Carry out a command/statement with each element of the sequence (via `foreach`).
* Convert the sequence to another sequence using a function that maps each element to a new element (via `map`).
* Get a subsequence from the sequence with elements that meet a certain criterion (via `filter`).

Here's some code showing these operations in action:

```scala
cleari()
showAxes()
def p = Picture {
    repeat(4) {
        forward(30)
        right(90)
    }
}
val pic1 = p
val pic2 = trans(50, 0) -> p
val pic3 = trans(100, 0) -> p
val pictures = Seq(pic1, pic2, pic3)

// do something for each element in the sequence
pictures.foreach { p =>
    draw(p)
}

// map a sequence to convert it to another sequence
val pictures2 = pictures.map { p =>
    rot(45) * fillColor(blue) -> p.copy
}

// then do something for each element in the new sequence
pictures2.foreach { p =>
    draw(p)
}

// filter a sequence to get a sub-sequence
val pictures3 = pictures.filter { p =>
    p.position.x > 50
}

// then do something for each element in the new sequence
pictures3.foreach { p =>
    draw(rot(-30) * fillColor(green) -> p.copy)
}
```
Note - we need to do a p.copy in the above code because the original picture has already been drawn, and you can't redraw a picture.

Let's try to understand what the following code (copied from above) that uses `map` does:
```scala
val pictures2 = pictures.map { p =>
    rot(45) * fillColor(blue) -> p.copy
}
```
This code can be rewritten as:
```scala
def fn1(p: Picture): Picture = {
    rot(45) * fillColor(blue) -> p.copy
}

val pictures2 = pictures.map(fn1)
```
The first version of the code uses an anonymous function that is defined inline in the call to `map`, while the second version of the code uses a named function that is defined first and then used in the call to `map`.

Let's do a similar exercise for `filter`.

Version with an anonymous function defined inline:
```scala
val pictures3 = pictures.filter { p =>
    p.position.x > 50
}
```
Version with a named function:
```scala
def fn2(p: Picture): Boolean = {
    p.position.x > 50
}

val pictures3 = pictures.filter(fn2)
```
As you can see above, `map` and `filter` both take a function as input, apply that function to each element of the sequence, and construct a new sequence based on the results of the function calls.

Scala has multiple sequence types (technically subtypes of Seq). We're going to look at one of them - the `ArrayBuffer`. 

<a name="data-arraybuffer">
**1.7.1.1 ArrayBuffer**

An `ArrayBuffer` is useful when you want to be able to modify an existing sequece, by changing its elements, adding new elements to it, or removing elements from it.

An `ArraBuffer` is also a sequence, so anything you can do with a sequence (including the stuff from the previous section), you can also do with an `ArrayBuffer`.

Here is some sample code for `ArrayBuffers`.

```scala
// create an arraybuffer with some values
val ab = ArrayBuffer(1, 5, 3, 9) //> ab: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 5, 3, 9)
// create an empty arraybuffer
val ab2 = ArrayBuffer.empty[Int] //> ab2: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()

ab2.append(11)
ab2.append(2)

ab.remove(0) //> res5: Int = 1

ab //> res6: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(5, 3, 9)
ab2 //> res7: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(11, 2)
```

<a name="data-map">
**1.7.2 Map**

Todo

<a name="data-set">
**1.7.3 Set**

Todo

<a name="control">
**2 Control Flow**
* When a program runs, it carries out the instructions inside it one after the other, in sequence.
* The following constructs change the above default mode of execution:
  * Loops (repeat, repeatFor, for, while, etc)
  * Selection (if-else or switch)
  * Calls (to functions or commands)


Let's look at the above in a little more detail.

<a name="control-sequencing">
**2.1 Sequencing**

This is the default mode of execution of a program - instructions are run one after the other.
```scala
clear()
forward(100)
right(90)
val x = 200
forward(x)
```

<a name="control-loops">
**2.2 Loops**

<a name="control-repeat">
**2.2.1 repeat**

`repeat(n) { code }` - repeats the given code n number of times. This helps you to do the same thing over and over again.
```scala
clear()
repeat(4) {
    forward(100)
    right(90)
}
```

<a name="control-repeatFor">
**2.2.2 repeatFor**

`repeatFor(sequence) { element => code }` - repeats the given code multiple times, once for each element of the given sequence. The current sequence element is available to your code - to help you do something slightly different based on the current element.
```scala
clear()
setSpeed(fast)
repeatFor(10 to 100) { n =>
    // n is the current element of the sequence that you are going through
    forward(n)
    right(91)
}
```

Now let's look at a particular problem and multiple ways of solving the problem. Let's say we want to draw five rectangles (width = 20, height = 100) as shown below:

![five-rects](five-rects.png)

In the first way of solving the problem, we use `repeatFor` to create and draw the pictures:

```scala
cleari()
repeatFor(0 to 4) { n =>
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    draw(pic)
}
```

In the second way of solving the problem, we use `repeatFor` to create the desired pictures and add them to an `ArrayBuffer`. Then we just draw all the pictures in the `ArrayBuffer`.

```scala
cleari()
val pics = ArrayBuffer.empty[Picture]
repeatFor(0 to 4) { n =>
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    pics.append(pic)
}
draw(pics)
```

The third way of solving the problem is very similar to the second one above. We just use `foreach` instead of `repeatFor`.

```scala
cleari()
val pics = ArrayBuffer.empty[Picture]
(0 to 4).foreach { n =>
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    pics.append(pic)
}
draw(pics)
```
The idea to take away from the second and third solutions is that `repeatFor` and `foreach` are totally interchangable. Where you can use one, you can use the other. Take your pick.

The fourth and last way of solving the problem uses `map` and is arguable the best, because you have a nice separation of functions and commands.

```scala
cleari()
val pics = (0 to 4).map { n =>
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    pic
}
draw(pics)
```

<a name="control-for">
**2.2.3 for**

`repeat` and `repeatFor` are looping methods provided by Kojo. Scala itself has multiple looping methods like - `for`, `while`, and `do-while`. Here we will just mention the scala `for` loop.

The `for` loop in Scala is extremely powerful, and allows you to use a combination of `foreach`, `map`, and `filter` as per your needs. Let's write the `foreach` and `map` examples from above using `for`:

The rewritten `foreach` example:

```scala
cleari()
val pics = ArrayBuffer.empty[Picture]
for (n <- 0 to 4) {
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    pics.append(pic)
}
draw(pics)
```

The rewritten `map` example:
```scala
cleari()
val pics = for(n <- 0 to 4) yield {
    val pic = Picture.rectangle(20, 100)
    pic.setPosition(n * 50, 0)
    pic
}
draw(pics)
```

<a name="control-selection">
**2.3 Selection**

**2.3.1 if-else**

**2.3.2 switch: pattern-matching**
Todo

<a name="control-calls">
**2.4 Calls**

```scala
clear()
def diag(b: Double, h: Double) =
    math.sqrt(b * b + h * h)

forward(100)
right(90)
forward(50)
towards(0, 0)
val d = diag(50, 100)
forward(d)
```

**3 Abstraction / Naming**

**3.0 Blocks**

Scala is a block structured language (like C, Java, or JavaScript). A block is anything between `{` and `}`. In Scala, a block has the following important functions:
* It introduces a new scope for naming. A name introduced within a block is visible only within that block, and shadows names from enclosing scopes.

```scala
val x = 10

{
    val x = 20
    println(x)
}

println(x)
```
This prints
```scala
20
10
```

* Wherever a single expression (or statement) is expected, you can put in multiple expressions (or statements) by enclosing them within a block. The value of this block is the value of the last expression in the block. Recall that statements are expressions that evaluate to `()`.

```scala
val x = {
    val a = 10
    val b = a * 3
    b + 2
}
println(x)
```
This prints
```scala
32
```

**3.1 val**

Todo

**3.2 var**

Todo

**3.3 def**

Todo

**3.4 class**

Todo
