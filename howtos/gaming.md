<div class="nav">
  <a href="../index.html">Home</a> | <a href="../gaming-index.html">Gaming</a>
</div>

## Gaming How-to code snippets
* [Move a picture towards a given position](#move-a-picture-towards-a-given-position).
* [On picture click - draw a new picture](#on-picture-click---draw-a-new-picture).
* [Check if two pictures have the same orientation](#check-if-two-pictures-have-the-same-orientation).
* [Fire Bullets](#fire-bullets).
* [Click on a button to start a game](#click-on-a-button-to-start-a-game).
* [Pictures with hotspots for collision checking](#pictures-with-hotspots-for-collision-checking).


### Move a picture towards a given position
```scala
// an example where a rectange moves towards the mouse cursor
cleari()
val pic = Picture.rectangle(50, 50)
draw(pic)

animate {
    val mp = mousePosition 
    // mp now holds the x, y of the current mouse cursor location
    val pos = pic.position

    val vel = Vector2D(mp.x - pos.x, mp.y - pos.y).normalize * 3
    pic.translate(vel)
    
}
```

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
    // note `newPic` will be drawn over `pic`. So mouse clicks 
    // within the bounds of `newPic` will not reach `pic`
    draw(newPic)
}
draw(pic)
```

### Check if two pictures have the same orientation
```scala
cleari()
val pic1 = Picture {
    repeat(4) {
        forward(100)
        right(90)
    }
}

val pic2 = Picture {
    repeat(4) {
        forward(100)
        right(90)
    }
}

pic2.setPosition(200, 0)
pic2.rotate(-45)

draw(pic1, pic2)
println(pic1.heading)

def headingsSame(pic1: Picture, pic2: Picture) = {
    pic2.heading % 360 == pic1.heading % 360
}
animate {
    if (isKeyPressed(Kc.VK_LEFT)) {
        pic2.rotate(1)
        println(pic2.heading)
    }

    if (isKeyPressed(Kc.VK_RIGHT)) {
        pic2.rotate(-1)
        println(pic2.heading)
    }

    if (headingsSame(pic1, pic2)) {
        drawCenteredMessage("You Win", green, 30)
        stopAnimation()
    }
}
activateCanvas()
```

### Fire Bullets
```scala
cleari()
drawStage(white)
val cb = canvasBounds

def newBullet = {
    fillColor(red) -> Picture.rectangle(2, 5)
}

val bullets = HashSet.empty[Picture]

timer(1000) {
    val b = newBullet
    bullets.add(b)
    draw(b)
    b.setPosition(cb.x + 20, cb.y + 5)
    b.setHeading(- random(45))
}


animate {
    bullets.foreach { b =>
        b.translate(0, 5)
    }

    bullets.foreach { b =>
        if (b.collidesWith(stageBorder)) {
            bullets.remove(b)
            b.erase()
        }
    }
}
```

### Click on a button to start a game
```scala
cleari()
drawStage(black)
val player = Picture.rectangle(100, 60)
player.setPosition(100, 100)
draw(player)
var vel = Vector2D(2, 3)
var active = false
animate {
    if (active) {
        realAnimate()
    }
}

def realAnimate() {
    player.translate(vel)
    if (player.collidesWith(stageBorder)) {
        vel = bouncePicVectorOffStage(player, vel)
    }
}

val startButton = Picture {
    // there are easier ways to do this
    // but let's stick with turtle graphics for now
    setFillColor(green)
    setPenColor(blue)
    repeat(2) {
        forward(60)
        right(90)
        forward(130)
        right(90)
    }
    setPosition(30, 50)
    setPenFontSize(30)
    setPenColor(black)
    write("Start")
}

draw(startButton)
startButton.onMouseClick { (x, y) =>
    active = true
    startButton.erase()
}
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