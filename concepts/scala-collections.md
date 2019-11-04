<div class="nav">
  <a href="../index.html">Home</a> | <a href="../gaming-index.html">Gaming</a> | <a href="../fundamentals-index.html">Fundamentals</a>
</div>

## Scala Collections

The Scala collections are predefined data-structures that are available to you to structure and organize the data in your programs. A full [description of the Scala collections](https://docs.scala-lang.org/overviews/collections/overview.html) is available on the Scala website. Here, we are going to look at just that collections that we are going to use to begin with.

* [ArrayBuffer](#arraybuffer)
* [HashSet](#hashset)
* [HashMap](#hashmap)

### ArrayBuffer
An ArrayBuffer is a mutable (modifiable), indexed sequence of elements of a given type. An element's location in the ArrayBuffer (its index) is based on the order in which it was added to the buffer. [More info](https://alvinalexander.com/scala/arraybuffer-class-methods-syntax-examples-reference).

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

// use indexing to access an element
println("---")
val e = ab(0)
val e2 = ab(1)
println(e, e2)

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
A HashSet is a mutable set of elements of a given type. A set is an unordered sequence. Use a set when you don't care about the order of the elements inside, but care only about whether an element is present inside or not. [More info](https://alvinalexander.com/scala/scala-set-class-how-to-add-elements-cookbook-recipes).

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
val c = hs.contains(11)
val c2 = hs.contains(12) 
println(c, c2)

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
A HashMap is a mutable map/dictionary of associations between keys and values. You add (key, value) pairs to the map, and can then look up values based on keys. [More info](https://alvinalexander.com/scala/how-to-add-update-remove-mutable-map-elements-scala-cookbook).

Example:
```scala
clearOutput()
// create an empty hashmap
val hm = HashMap.empty[Int, Int]
// add a key, value pair to it
hm(10) = 2

// add another key, value pair to it
hm(11) = 5

// get the value for a key
println("---")
val k = hm(10)
val k2 = hm(11)
println(k, k2)

// To guard against a key not being present, use getOrElse
val k3 = hm.getOrElse(12, 0)
println(k3)
```