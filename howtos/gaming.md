<div class="nav">
  <a href="../index.html">Home</a> | <a href="../gaming-index.html">Gaming</a>
</div>

## Gaming How-to code snippets
* [On picture click - draw a new picture](#on-picture-click---draw-a-new-picture)
* [Pictures with hotspots for collision checking](#pictures-with-hotspots-for-collision-checking)

### On picture click - draw a new picture
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

### Pictures with hotspots for collision checking
This one is a little tricky due to the need to keep track of the global coordinate system and the hotspot's local coordinate system while rotating a picture with a hotspot.

```scala
cleari()

class PicWithHotspot(pic: Picture, spotX: Double, spotY: Double, spotRadius: Double) {
    val hotspot = Picture.circle(spotRadius)
    hotspot.setPenColor(cm.blue)
    hotspot.setPenThickness(1)

    def draw() {
        pic.draw(); hotspot.draw()
    }

    def rotate(a: Double) {
        pic.rotate(a)
        hotspot.rotateAboutPoint(a, -spotX, -spotY)
    }

    def setPosition(x: Double, y: Double) {
        pic.setPosition(x, y)
        hotspot.setPosition(x + spotX, y + spotY)
    }

    def hotspotCollidesWith(other: PicWithHotspot): Boolean = {
        hotspot.collidesWith(other.hotspot)
    }

    def setFillColor(c: Color) {
        pic.setFillColor(c)
    }
    
    setPosition(0, 0)
}

val pic1 = Picture {
    setFillColor(cm.green)
    setPenThickness(0)
    repeat(4) {
        forward(100)
        right(90)
    }
}

val hpic1 = new PicWithHotspot(pic1, 2, 98, 2)
hpic1.setPosition(50, 0)

val pic2 = Picture {
    setFillColor(cm.brown)
    setPenThickness(0)
    repeat(4) {
        forward(50)
        right(90)
    }
}

val hpic2 = new PicWithHotspot(pic2, 48, 2, 2)
hpic2.setPosition(-100, 0)

hpic1.draw()
hpic2.draw()

animate {
    hpic1.rotate(1)
    if (hpic1.hotspotCollidesWith(hpic2)) {
        hpic2.setFillColor(red)
        stopAnimation()
    }
}
```