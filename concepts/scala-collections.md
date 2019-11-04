<div class="nav">
  <a href="../index.html">Home</a> | <a href="../gaming-index.html">Gaming</a> | <a href="../fundamentals-index.html">Fundamentals</a>
</div>

## Scala Collections

The Scala collections are predefined data-structures that are available to you to structure and organize the data in your programs. A full [description of the Scala collections](https://docs.scala-lang.org/overviews/collections/overview.html) is available on the Scala website. Here, we are going to look at just that collections that we are going to use to begin with.

* [ArrayBuffer](#arraybuffer)
* [HashSet](#hashset)
* [HashMap](#hashmap)

### ArrayBuffer
An ArrayBuffer is a modifiable, indexed sequence of elements of a given type. [More info](https://alvinalexander.com/scala/arraybuffer-class-methods-syntax-examples-reference).

Example usage:
```scala
clearOutput()
// create an empty arraybuffer
val ab = ArrayBuffer.empty[Int]
// add an element to it
ab.append(10)
// add two more elements to it
ab.append(11, 12)
// do something with all the elements
ab.foreach { x =>
    println(x)    
}
// do something with all the elements using our old friend repeatFor
// this does the same thing as above
println("---")
repeatFor(ab) { x =>
    println(x)
}

// convert ab to a new arraybuffer via a rule for how each element 
// is to be changed
val ab2 = ab.map { x =>
    x * 2    
}
println("---")
println(ab2)

// filter ab to get a new arraybuffer via a rule for whether an element 
// is to be selected or not
val ab3 = ab.filter { x =>
    x > 10
}
println("---")
println(ab3)
```

### HashSet
A HashSet is a set of elements of a given type. A set is also an unordered sequence.

Example Usage:
```scala
clearOutput()
// create an empty hashset
val hs = HashSet.empty[Int]
// add an element to it
hs.add(10)
// add another elements to it
hs.add(12)

// do something with all the elements
hs.foreach { x =>
    println(x)    
}
// do something with all the elements using our old friend repeatFor
// this does the same thing as above
println("---")
repeatFor(hs) { x =>
    println(x)
}

// foreach and repeatFor (above) work the same for all sequences.

// test for membership; this is mostly why you want to use a set
println("---")
println(hs.contains(11))
println(hs.contains(12))

// filter and map (below) work the same for all sequences.

// convert hs to a new hashset via a rule for how each element 
// is to be changed
val hs2 = hs.map { x =>
    x * 2    
}
println("---")
println(hs2)

// filter hs to get a new hashset via a rule for whether an element 
// is to be selected or not
val hs3 = hs.filter { x =>
    x > 10
}
println("---")
println(hs3)
```

### HashMap
A HashMap is a map/dictionary of associations between keys and values.  
Todo