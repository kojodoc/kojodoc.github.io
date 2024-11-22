<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Moving pictures smoothly on the canvas

This activity has the following desired goals:
* Students will know how to use the Standar and libGDX runtimes for their games (**A**).
* Students will understand how to move game objects at the same speed across slow vs fast computers/runtimes (**M**).
* Students will be able to move a rectangle with a given speed towards a target(**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)
pic.setPosition(-300, -300)
pic.setFillColor(red)
pic.setPenColor(black)

draw(pic)

val speed = 2

animate {
    pic.translate(speed, speed)
}
```

**Q1a.** What does the above code do? How?

**Q1b.** What's the speed of the square in pixels per second as it moves?

---

### Step 2

Type in the following code and run it:

```scala
// #exec template /picgaming

cleari()

val pic = Picture.rectangle(50, 50)
pic.setPosition(-300, -300)
pic.setFillColor(red)
pic.setPenColor(black)

draw(pic)

val speed = 2

animate {
    pic.translate(speed, speed)
}
```

**Q2a.** How is the code from `Step 2 ` different from the code in `Step 1`?

**Q2b.** How is result of (running the code in) `Step 2 ` different from the result of `Step 1`?


---

### Explanation

You might have noticed in the output from step-1 that the moving square moves in a slightly jerky manner (especially on Windows). This is because the Standard Java runtime used by Kojo is not optimized (especially on Windows) for showing animations. To overcome this issues, Kojo provides an option to run your games using a runtime (based on libGDX, LWJGL, and OpenGL) that is highly optimized for animations. This runtime can be activated by adding the following line (via code completion, for convenience) at the top of your script:

```scala
// #exec template /picgaming
```

After you run your script in this mode (in `Step 2`), you should find the square (a) moving much more smoothly across the screen, and (b) moving across the screen much faster (in `Step 2` compared to `Step 1`). (a) is good, but (b) is not so good, because you want to be able to prototype your games with the Kojo default runtime, and then move them to the optimized runtime as desired, with similar behavior. You also want your games to run at the same speed on slow vs fast computers.

---

### Step 3

Type in the following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)
pic.setPosition(-300, -300)
pic.setFillColor(red)
pic.setPenColor(black)

draw(pic)

val speed = 50 // pixels per second

animate {
    val dt = frameDeltaTime
    val deltaDist = dt * speed
    pic.translate(deltaDist, deltaDist)
}
```

**Q3a.** How is the code in `Step 3` different from the code in `Step 1`?

**Q3b.** How is the `speed` in `Step 3` different from the `speed` in `Step 1`?

**Q3c.** What is `frameDeltaTime`? Explore and experiment to find out.

**Q3d.** What is `deltaDist`?

---

### Explanation

Here's a key fact - pixels on the screen are the same on slow computers/runtimes vs fast computers/runtimes. So if you can specify the speed of your game objects in pixels per second, they will move at the same speed on all kinds of computers/runtimes.

This is what the above code does. It specifies a speed in pixels per second, determines the time since the last frame was drawn, uses the speed and the time elapsed to calculate the distance to be moved, and then moves the rectangle through this distance.

Query description:

* `frameDeltaTime` - returns the time since the last frame was drawn

---

### Exercises

1. Run the program in `Step 3` via the libGDX runtime.  
Does the square move with the same speed in the libGDX and Standard runtimes?

1. Write a program that draws a rectangle at the center of the canvas and moves it to the top-right, with a speed of 50 pixels per second, so that the corner of the rectangle hits the corner of the canvas.  
Run this program with both the Standard and libGDX runtimes.