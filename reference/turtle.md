This page contains descriptions of the basic turtle commands available in Kojo.

While looking at the turtle commands, it is helpful to remember that a turtle has the following properties related to 
how it moves and draws:
* **position** - the location on the canvas where the turtle is sitting. This location is specified by two 
numbers - the x coordinate and the y coordinate. As you move the mouse pointer within the drawing canvas, you will see these two numbers at the bottom-left of the Kojo window.
* **heading** - the direction in which the turtle's nose is pointing:
  * East (at the right of the screen) is at 0°
  * North (at the top of the screen) is at 90°
  * West (at the left of the screen) is at 180°
  * South (at the bottom of the screen) is at 270°
* **pen up/down** state - whether the turtle's pen is down (for drawing as it moves) or up (for just moving without drawing).
* **pen color** - the color of the lines drawn by the pen.
* **pen thickness** - the thickness of the lines drawn by the pen.
* **fill color** - the color that fills areas enclosed by the lines drawn by the pen.

## Basic Commands
*Click on a command below to go to its description.  
Most descriptions include sample code. Copy & paste and then run the sample code for a command in Kojo for a better understanding of that command.*

* [clear](#clear)
* [cleari](#cleari)
* [forward](#forward)
* [penUp and penDown](#penup-and-pendown)
* [hop](#hop)
* [right](#right)
* [left](#left)
* [setPenColor](#setpencolor)
* [setFillColor](#setfillcolor)
* [setPenThickness](#setpenthickness)
* [setBackground](#setbackground)
* [savePosHe](#saveposhe)
* [restorePosHe](#restoreposhe)
* [write](#write)
* [setPenFontSize](#setpenfontsize)
* [setPenFont](#setpenfont)
* [setPosition](#setposition)
* [setSpeed](#setspeed)
* [invisible and visible](#invisible-and-visible)
* [repeat](#repeat)
* [repeatFor](#repeatfor)
* [def](#def)  


### clear
`clear()` - clears the drawing canvas and resets the internal state of the turtle to the following:
* position becomes (0, 0).
* heading becomes 90°.
* pen goes down.
* pen color become red.
* pen thickness becomes 2.
* fill color becomes null (no fill).
* speed becomes slow.

### cleari
`cleari()` - clears the drawing canvas as described above, and then hides the turtle (i.e. makes it invisible).

### forward
`forward(numSteps)` - Moves the turtle forward in the direction of its nose - by the given number of steps. The turtle draws a line as it moves **if its pen is down**. The pen is down by default after a [clear()](#clear). See example below:
```scala
clear()
// draw a line that is 100 steps long
forward(100) 
          
// and another line that is 200 steps long
forward(200)
```

### penUp and penDown
`penUp()` - Pulls the turtle's pen up. Any forward after this will not draw a line (till the next penDown).  
`penDown()` - Puts the turtle's pen down.

### hop
`hop(numSteps)` - Moves the turtle forward by the given number of steps with the pen up, so that no line is drawn. The pen is put down after the hop. See example below:
```scala
clear()
hop(10)
forward(10)
hop(10)
forward(10)
```

### right
right comes in two variants:  
`right(angle)` - turns the direction of the turtle's nose (i.e. the turtle's heading) right by the given angle.  
`right(angle, radius)` - makes the turtle move right on the boundary of a circle with the given radius, till the turtle's nose 
has turned through the given angle. If the pen is down, the turtle draws an arc with the given angular extent and radius. See example below:
```scala
clear()
// turn the turtle right by 90° at its current position
right(90)
// make the turtle draw a blue quarter circle of radius 100 to the right
setPenColor(blue)
right(90, 100)
// make the turtle draw a green semi circle of radius 150 to the right
setPenColor(green)
right(180, 150)
```

### left
left also comes in two variants, and is very similar to right, except that it turns the turtle to the left. See example below:
```scala
clear()
// turn the turtle left by 90° at its current position
left(90)
// make the turtle draw a blue quarter circle of radius 100 to the left
setPenColor(blue)
left(90, 100)
// make the turtle draw a green semi circle of radius 150 to the left
setPenColor(green)
left(180, 150)
```

### setPenColor
`setPenColor(color)` - sets the [color](../concepts/colors.html) of the turtle's pen. From this point on in the program, any lines drawn by the turtle have this [color](../concepts/colors.html).  

### setFillColor
`setFillColor(color)` - sets the [color](../concepts/colors.html) of the fill area of the turtle's pen. From this point on in the program, any areas drawn by the turtle have this fill [color](../concepts/colors.html).


### setPenThickness
`setPenThickness(width)` - sets the thickness of the turtle's pen. From this point on in the program, any lines drawn by the turtle have this thickness.


### setBackground
`setBackground(color)` - paints the background of the canvas the specified [color](../concepts/colors.html).

### savePosHe
`savePosHe()` - saves the position and heading of the turtle. At a later point in the program, the turtle can be brought to the saved position and heading using the `restorePosHe()` command. See example below:
```scala
clear()
// draw a square with lines at the corners
repeat(4) {
    // draw a side of the square
    forward(100)
    // save position and heading
    savePosHe()
    // draw a corner line
    left(45)
    forward(30)
    // restore position and heading to draw the rest of the square
    restorePosHe()
    right(90)
}
```

### restorePosHe
`restorePosHe` - restores the position and heading of the turtle based on the most recent `savePosHe()`

### write
`write("text")` - writes the given text at the turtle's current position, oriented as per the turtle's current heading. See example below:
```scala
clear()
hop(50)
right(45)
write("Hello World")
```

### setPenFontSize
`setPenFontSize(size)` - sets the size of the font used for writing text. See example below:
```scala
clear()
setPenFontSize(30)
hop(50)
right(45)
write("Hello World")
```


### setPenFont
`setPenFont(font)` - sets the font used for writing text. See example below:
```scala
clear()
setPenFont(Font("Consolas", 30))
hop(50)
right(45)
write("Hello World")
```

### setPosition
`setPosition(x, y)` - sets the turtle's position to the given x and y.

### setSpeed
`setSpeed(speed)` - sets the turtle's speed to the given speed, which can be one of `slow`, `medium`, `fast`, or `superFast`.

### invisible and visible
`invisible()` - hides the turtle.  
`visible()` - makes a hidden turtle visible again.

### repeat
`repeat(n) { code }` - repeats the given code n number of times. This helps you to do the same thing over and over again.
```scala
clear()
repeat(4) {
    forward(100)
    right(90)
}
```

### repeatFor
`repeatFor(sequence) { element => code }` - repeats the given code multiple times, once for each element of the given sequence. The current sequence element is available to your code - to help you do something slightly different based on the current element.
```scala
clear()
setSpeed(fast)
repeatFor(10 to 100) { n =>
    forward(n)
    right(91)
}
```

### def
`def newCommand(inputs) { code }` - creates a new command that takes the specified inputs and carries out commands as defined in the given code. See example below:
```scala
// create a new command named square1 that 
// always draws squares of size 100
def square1() {
    repeat(4) {
        forward(100)
        right(90)
    }
}

// create a new command named square2 that 
// draws squares of the given size
def square2(size: Int) {
    repeat(4) {
        forward(size)
        right(90)
    }
}

clear()
// now use the newly defined commands
square1()
square2(50)
square2(25)
```