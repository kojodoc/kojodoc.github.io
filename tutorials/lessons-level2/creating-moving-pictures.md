<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Creating Pictures and moving them around on the canvas

This activity has the following desired goals:
* Learning to make pictures out of turtle drawings (**A, M**).
* Learning to use `Picture.rectangle` (**A, M**).
* Learning to use `Picture.image` (**A, M**).
* Learning to move pictures around  (**A, M**).
* Using the above ideas to make an object hit the corner of the canvas (**M, T**).

---

### Step 1

Type in the following code and run it:

```scala
cleari()

val pic = Picture {
    repeat(5) {
        forward(50)
        right(72)
    }
}

draw(pic)
```

**Q1a.** Is `Picture` a command or function? What do you think it does?

**Q1b.** Is `draw` a command or function? What do you think it does?

---

### Explanation

A picture is a visual element in Kojo - made out of turtle drawings (and in other ways, as you will see in a bit). Given a picture:
* You can draw it.
* You can align it with other pictures.
* You can translate, scale, or rotate it.
* You can change its transparency.
* You can apply effects to it.
* You can animate it.
* You can detect collisions with other pictures

This opens up many possibilites in terms of generative art, gaming, and a deeper look at programming.

---

### Step 2

Type in the following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)

draw(pic)
```

**Q2a.** Is `Picture.rectangle` a command or function? What do you think it does?

**Q2b.** What does the `.` in `Picture.rectangle` signify?


---

### Explanation

For well defined shapes (like rectangles, ellipses, lines, etc.), you can create a Picture directly (by using the appropriate function in the Picture object, like above) without having to make a turtle drawing. The advantage of this is that it is easier to code and has better runtime performance. But this works only for predefined simple shapes. For custom shapes, you can always make a turtle drawing and put it in a Picture.

The `.` in the function name specifies that the function is being called via an object.

---

### Step 3

Type in the following code and run it:

```scala
cleari()

val pic = Picture.image("path/to/image/file.jpgOrPng")

draw(pic)
```

**Q3a.** Is `Picture.image` a command or function? What is the input to it? What is the output (or return value) from it?

---

### Explanation

The above was meant to just show you how to load and draw images in Kojo. This will be useful later, when you want to make your games look visually appealing. To write the core logic and mechanics of your game, you can just use `Picture.rectangle` to begin with (and then switch to `Picture.image` later on).

---


### Step 4

Type in the following code and run it:

```scala
cleari()

val pic = Picture.rectangle(50, 50)
pic.setPosition(50, 100)
pic.setFillColor(red)
pic.setPenColor(black)

draw(pic)

animate {
    pic.translate(2, 3)
}
```

**Q4a.** Is `pic.setPosition` a command or function? What do you think it does?

**Q4b.** What do you think `pic.setFillColor` does?

**Q4c.** What do you think `pic.setPenColor` does?

**Q4d.** Is `animate` a command or function? What do you think it does?

**Q4e.** Is `pic.translate` a command or function? What do you think it does?


---

### Explanation

* `pic.setPosition(x, y)` - sets the position of the given `pic` to the given `(x, y)`.
* `pic.setFillColor(c)` - sets the fill color of the given `pic` to given `c`.
* `pic.setPenColor(c)` - sets the pen color of the given `pic` to given `c`.
* `animate` is a command that takes another command as input, and runs this given command around 50 times per second.
* `pic.translate` is a command that moves the given `pic` by the given `x` and `y` amounts.

---

### Exercise

Write a program that draws a rectangle at the center of the canvas and moves it to the top-right so that the corner of the rectangle hits the corner of the canvas.

<div style="margin-top: 20px;margin-bottom: 20px;text-align:center">
    <iframe frameborder="0" width="640" height="360" src="https://player.vimeo.com/video/479774201" allow="autoplay"></iframe>
</div>
