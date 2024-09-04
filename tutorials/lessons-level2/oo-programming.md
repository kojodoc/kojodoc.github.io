<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Object Oriented Programming

This activity has the following desired goals:
* Learning about object oriented programming (**A, M**).
* Going through the process of converting a regular structured program to an object oriented program (**A, M**).
* Understanding the idea of Objects and Message-passing.
* Understanding Abstraction, Encapsulation, Polymorphism, Inheritance, and Composition (**A, M**).
* Using the above ideas to create a new class to fit into an existing program  (**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
cleari()
drawStage(black)

val pic1 = Picture.rectangle(50, 50)
val pic2 = Picture.rectangle(50, 50)
draw(pic1, pic2)

var vel1 = Vector2D(1, 2)
var vel2 = Vector2D(-1, 2)

animate {
    pic1.translate(vel1)
    pic2.translate(vel2)
    if (pic1.collidesWith(stageBorder)) {
        vel1 = bouncePicOffStage(pic1, vel1)
    }
    if (pic2.collidesWith(stageBorder)) {
        vel2 = bouncePicOffStage(pic2, vel2)
    }
}
```

**Q1a.** What does the above program do? How does it do it?

**Q1b.** In calls or usages like `pic1.translate(vel1)`, what's on the left of the `.` and what's on the right? Can you guess how this might relate to objects and messages being passed to objects?

---

### Explanation

In the above program, various commands are used, one after the other, to carry out the desired functionality. We see examples of the sequencing of commands, repetition (via `animate`), the calling of various picture commands, and the use of one function to do an interesting calculation/computation. The focus is on the flow of control of the program.

Let's focus on one line in the program -- `pic1.translate(vel1)`.

Here the thing to the left of the `.` is an object (a bundle of data and commands/functions that work with that data). The thing to the right of the `.` is a method (a command or function) in the object. Methods in objects work in the context of the data within the object. You can think of the calling of a method in an object as the passing a message to that object.

---

### Step 2

Type in the following code and run it:

```scala
cleari()
drawStage(black)

class InstagePic(pic: Picture, vel: Vector2D) {
    var currVel = vel
    def move() {
        pic.translate(currVel)
        if (pic.collidesWith(stageBorder)) {
            currVel = bouncePicOffStage(pic, currVel)
        }
    }

    def draw() {
        pic.draw()
    }
}

val pic1 = new InstagePic(Picture.rectangle(50, 50), Vector2D(1, 2))
val pic2 = new InstagePic(Picture.rectangle(50, 50), Vector2D(-1, 2))

pic1.draw()
pic2.draw()

animate {
    pic1.move()
    pic2.move()
}
```

**Q2a.** Does the above program do the same thing as the program in `Step 1`? How is it different?

---

### Explanation

In the program in `Step 2`, the logic for bouncing off the stage and keeping within the stage area has moved inside the class InstagePic.

So what's a class, and how does it relate to object oriented programming? Read on:

* A class is a description/definition of a type.
* Given a class `X`, you can create an object of type `X` named, say, `x1` by doing `val x1 = new X`.
* `x1` is now an object with type `X`. `x1` is called an instance of `X`. You can create as many instances of `X` in your program as you want, giving them whatever names you want.
* The data and methods available in the object `x1` are as per the definition of `X` (because `x1` is an instance of `X`).
* Programming with objects is called object oriented programming.
* The core ideas in object oriented programming are:
  * Abstraction - Something useful is created with a given name and a way of interacting with it (called its interface).
  * Message Passing - You interact with an abstraction only by passing messages to it (via method calls).
  * Encapsulation - The implementation of the interface is hidden behind the walls of the abstraction (within the body of the class/object).
  * Polymorphism - Different types of objects with the same interface can be treated in the same fashion. Ploymorphism literally means - *many forms*, and supports the idea of the same thing (interface) in many forms (implementations). So if an interface has a method `makeSound`, and you have a sequence of objects that implement this interface, you can call the `makeSound` method on all these objects, and the exact sound that is made can vary depending on the implementation of this method in the object.
  * Inheritence and composition - to use the functionality of a given class, a new class can inherit from it or use it (by containing an instance of it).

Note how in object-oriented programming, the focus shifts from the flow of control to the flow of messages.

  ---

**Q2b.** Can you identify the abstraction in the above code?

**Q2c.** Can you identify the message-passing in the above code?

**Q2d.** Can you identify the encapsulation in the above code?

---

### Step 3

Type in the following code and run it:

```scala
cleari()
clearOutput()
drawStage(black)

trait Shape {
    def pic: Picture
    var currVel: Vector2D = _

    def draw() {
        pic.draw()
    }

    def move() {
        pic.translate(currVel)
        if (pic.collidesWith(stageBorder)) {
            currVel = bouncePicOffStage(pic, currVel)
        }
    }

    def printShape()
}

class Square(size: Int, vel: Vector2D) extends Shape {
    val pic = Picture.rectangle(size, size)
    currVel = vel

    def printShape() {
        println("Square")
    }
}

class Circle(radius: Int, vel: Vector2D) extends Shape {
    val pic = Picture.circle(radius)
    currVel = vel

    def printShape() {
        println("Circle")
    }
}

val pic1 = new Square(50, Vector2D(1, 2))
val pic2 = new Circle(25, Vector2D(-1, 2))

val pics = List(pic1, pic2)
repeatFor(pics) { pic =>
    pic.draw()
    pic.printShape()
}

animate {
    repeatFor(pics) { pic =>
        pic.move()
    }
}
```

**Q3a.** Can you identify the abstraction in the above code?

**Q3b.** Can you identify the interface vs implementation in the above code?

**Q3c.** Can you identify the message-passing in the above code?

**Q3d.** Can you identify the inheritance in the above code?

**Q3e.** Can you identify the composition in the above code?

**Q3f.** Can you identify the polymorphism in the above code?

---

### Explanation

* The core abstraction above is `Shape`. It is defined using a trait, which is similar to an `interface` in Java. The `Shape` abstraction defines the interface via which a user of a Shape can interact with the given shape, by passing messages to it via the methods defined in the interface.
* `Shape` has two different implementations - `Square` and `Circle`, each of which `extends` or inherits from `Shape`.
* `Shape` provides an implementation of `draw` and `move`, which are inherited (and do not need to be defined again) by `Square` and `Circle`.
* Every shape has a Picture `pic` within it (via composition) when can be used to draw and move the shape on the stage.
* The two `repeatFor` calls show polymorphism in action, as both `Square` and `Circle` (which are *poly morphs* or different forms of `Shape`) are handled in exactly the same way through calls (message-passing) to the `draw`, `printShape`, and `move` methods.

--- 

### Exercise

Add a triangle shape to the above example - so that when you run the program, three different shapes (a square, a circle, and a triangle) move out from the center, bounce off the stage borders, and stay within the stage area.