## Turtle Graphcis Reference

While looking at turtle commands, it is helpful to remember that a turtle has the following properties related to 
how it moves and draws:
* **position** - the location on the canvas where the turtle is sitting. This location is specified by two 
numbers - the x coordinate and the y coordinate. As you move the mouse pointer within the drawing canvas, you will see these two numbers at the bottom-left of the Kojo window.
* **heading** - the direction in which the turtle's nose is pointing.
  * East (at the right of the screen) is at 0°
  * North (at the top of the screen) is at 90°
  * West (at the left of the screen) is at 180°
  * South (at the bottom of the screen) is at 270°
* **pen up/down** state - whether the turtle's pen is down (for drawing as it moves) or up (for just moveing without drawing).
* **pen color** - the color of the lines drawn by the pen.
* **pen thickness** - the thickness of the lines drawn by the pen.
* **fill color** - the color that fills areas enclosed by the lines drawn by the pen.

## Commands
[clear](#clear)  
[forward](#forward)  
[penUp and penDown](#penup-and-pendown)  
[hop](#hop)  
[right](#right)  
[left](#left)  
[setPenColor](#setpencolor)  
[setFillColor](#setfillcolor)  
[setPenThickness](#setpenthickness)  
[setBackground](#setbackground)  
[savePosHe](#saveposhe)  
[restorePosHe](#restoreposhe)  
[repeat](#repeat)  
[def](#def)  


### clear
`clear()` - clears the drawing canvas and resets the internal state of the turtle to the following:
* position becomes (0, 0).
* heading becomes 90°.
* pen goes down.
* pen color become red.
* pen thickness becomes 2.
* fill color becomes null (no fill).
* speed becomes slow.

### forward
`forward(numSteps)` - Moves the turtle forward in the direction of its nose - by the given number of steps. The turtle draws a line as it moves **if its pen is down**. The pen is down by default after a [clear()](#clear).

Example:
```scala
clear()
// draw a line that is 100 steps long
forward(100) 
          
// and another line that is 200 steps long
forward(200
```

### penUp and penDown
`penUp()` - Pulls the turtle's pen up. Any forward after this will not draw a line (till the next penDown).  
`penDown()` - Puts the turtle's pen down.

### hop
`hop(numSteps)` - Moves the turtle forward by the given number of steps with the pen up, so that no line is drawn. The pen is put down after the hop.

Example:  
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
has turned through the given angle. If the pen is down, the turtle draws an arc with the given angular extent and radius.

### left
left also comes in two variants, and is very similar to right, except that it turns the turtle left.

### setPenColor
`setPenColor(color)` - sets the color of the turtle's pen. From this point on in the program, any lines drawn by the turtle have this color.

### setFillColor
`setFillColor(color)` - sets the color of the fill area of the turtle's pen. From this point on in the program, any areas drawn by the turtle have this fill color.


### setPenThickness
`setPenThickness(width)` - sets the thickness of the turtle's pen. From this point on in the program, any lines drawn by the turtle have this thickness.


### setBackground
Todo

### savePosHe
Todo

### restorePosHe
Todo

### repeat
Todo

### def
Todo

