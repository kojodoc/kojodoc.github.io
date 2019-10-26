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
// hop forward by 100 steps
hop(10)
// move forward by 100 steps
forward(10)
// hop forward by 100 steps
hop(10)
// move forward by 100 steps
forward(10)
```

### right
Todo

### left
Todo

### setPenColor
Todo

### setFillColor
Todo

### setPenThickness
Todo

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

