## Picture Basics

For now, here is some code to show Pictures in action:
```scala
cleari()
val pic1 = Picture {
    setPenColor(cm.coral)
    setPenThickness(6)
    setFillColor(cm.cornSilk)
    repeat(6) {
        forward(100)
        right(60)
    }
}

val pic2 = Picture {
    setPenColor(cm.brown)
    setPenThickness(4)
    right(360, 50)
}

val pic3 = Picture {
    setPenFontSize(25)
    setPenColor(cm.darkRed)
    write("Picture Power!")
}

val gap = Picture {
    setPenColor(noColor)
    repeat(4) {
        forward(10)
        right(90)
    }
}

val pic12 = picStackCentered(pic1, pic2)
val pic123 = picColCentered(pic3, gap, pic12)

drawCentered(pic123)
```
![picture-power](picture-power.png)