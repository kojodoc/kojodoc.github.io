## Picture Basics

The basic idea with pictures is simple:
* You put a turtle drawing inside a picture.
* Now you can do many things with this picture drawing:
  * You can draw it (of course).
  * You can align it with other pictures.
  * You can translate, scale, or rotate it.
  * You can change its transparency.
  * You can apply effects to it.
  * You can animate it.
  * You can detect collisions with other pictures
  

Here, we are only interested in the drawing and the alignment part. Here is some sample code showing this in action:
```scala
// clear the canvas and make the trurtle invisible
cleari()

// make the first picture and give it the name pic1
val pic1 = Picture {
    setPenColor(cm.coral)
    setPenThickness(6)
    setFillColor(cm.cornSilk)
    repeat(6) {
        forward(100)
        right(60)
    }
}

// make the second picture and give it the name pic2
val pic2 = Picture {
    setPenColor(cm.brown)
    setPenThickness(4)
    right(360, 50)
}

// make a text picture and give it the name pic3
val pic3 = Picture {
    setPenFontSize(25)
    setPenColor(cm.darkRed)
    write("Picture Power!")
}

// make a gap picture to add spacing between pictures as desired
val gap = Picture {
    setPenColor(noColor)
    repeat(4) {
        forward(10)
        right(90)
    }
}

// stack pic1 and pic2 on top of each other and center them
val pic12 = picStackCentered(pic1, pic2)

// put pic3, the gap, and the stacked picture in a vertical centered colum
val pic123 = picColCentered(pic3, gap, pic12)

// draw the column of pictures
drawCentered(pic123)
```
![picture-power](picture-power.png)