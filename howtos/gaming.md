## Gaming How-to code snippets

### On picture click, draw a new picture
```scala
cleari()
val pic = Picture {
    setPenColor(cm.black)
    setFillColor(cm.green)
    repeat(4) {
        forward(100)
        right(90)
    }
}
pic.setPosition(100, 100)
pic.onMouseClick { (x, y) =>
    val newPic = Picture {
        setPenColor(cm.black)
        setPenThickness(4)
        right(45)
        forward(100)
    }
    newPic.setPosition(x, y)
    draw(newPic)
}
draw(pic)
```