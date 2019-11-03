<div class="nav">
  <a href="index.html">Home</a>
</div>

These pages describe the Gaming facility within Kojo.  

> <img src="man-at-work.png"/> <br/> *This section of the website is currently under development*.

For now, here are some simple animations leading up to a *Lunar Lander* game:

* [Bouncing shape](#bouncing-shape)
* [Bouncing shape with gravity](#bouncing-shape-with-gravity)
* [Bouncing sprite with gravity](#bouncing-sprite-with-gravity)
* [Lunar Lander](#lunar-lander)
* [A video of a Platformer game](https://www.youtube.com/watch?v=QytErHlrUpY) built using Kojo. The game can be run from the Showcase menu in Kojo.

> *Note* - computer programs in Kojo are written using the [Scala](http://scala-lang.org) programming language. You will need to know the [Basics of Scala](concepts/scala-essentials.html) to understand the programs below.

You can copy the programs below and paste them into Kojo to run them.

### Bouncing shape
```scala
clear()
drawStage(ColorMaker.black)
val cb = canvasBounds

val pic = Picture {
    setFillColor(red)
    repeat(4) {
        forward(40)
        right(90)
    }
}
pic.setPosition(cb.x + 20, cb.y + 20)
var vel = Vector2D(2, 10)

draw(pic)

animate {
    pic.translate(vel)
    if (pic.collidesWith(stageBorder)) {
        vel = bouncePicVectorOffStage(pic, vel)
    }
}
```


### Bouncing shape with gravity
```scala
clear()
drawStage(ColorMaker.black)
val cb = canvasBounds

class Ball {
    val pic = Picture.rectangle(40, 40)
    pic.setFillColor(red)
    pic.setPosition(cb.x + 20, cb.y + 20)
    var vel = Vector2D(2, 10)
    val gravity = Vector2D(0, -0.2)

    def draw() {
        pic.draw()
    }

    def step() {
        vel = vel + gravity
        pic.translate(vel)
        if (pic.collidesWith(stageBorder)) {
            vel = bouncePicVectorOffStage(pic, vel)
        }
    }
}

val ball = new Ball()
ball.draw()

animate {
    ball.step()
}
```

### Bouncing sprite with gravity
```scala
clear()
drawStage(ColorMaker.black)
val cb = canvasBounds

class Ball {
    val pic1 = PicShape.image("/media/flappy-ball/ballwing1.png")
    val pic2 = PicShape.image("/media/flappy-ball/ballwing2.png")
    val pic = picBatch(
          pic1,
          pic2
    )
    pic.setPosition(cb.x + 20, cb.y + 20)
    var vel = Vector2D(2, 10)
    val gravity = Vector2D(0, -0.2)

    def draw() {
        pic.draw()
    }

    def step() {
        vel = vel + gravity
        pic.translate(vel)
        if (pic.collidesWith(stageBorder)) {
            vel = bouncePicVectorOffStage(pic, vel)
        }
        pic.showNext(150)
    }
}

val ball = new Ball()
ball.draw()

animate {
    ball.step()
}
```

### Lunar Lander
```scala
cleari()
drawStage(ColorMaker.hsl(240, 0.20, 0.16))

class Lander {
    val body = fillColor(red) -> Picture.rectangle(40, 70)
    val thruster = fillColor(orange) -> Picture.rectangle(20, 35)
    thruster.setPosition(body.position.x + 10, body.position.y - 20)

    var gravity = Vector2D(0, -0.1)
    var velocity = Vector2D(0, 0)
    var thrust = Vector2D(0, 0)

    def draw() {
        body.draw()
        thruster.draw()
        thruster.invisible()
    }

    def step() {
        if (isKeyPressed(Kc.VK_UP)) {
            inThrust()
        }
        else {
            noThrust()
        }
        velocity += gravity
        velocity += thrust

        body.translate(velocity)
        thruster.setPosition(body.position.x + 10, body.position.y - 20)

        if (body.collidesWith(stageBorder)) {
            velocity = bouncePicVectorOffStage(body, velocity)
        }
    }

    def inThrust() {
        thrust = new Vector2D(0, 1)
        thruster.visible()
    }

    def noThrust() {
        thrust = new Vector2D(0, 0)
        thruster.invisible()
    }
}

class Moon {
    val pic = trans(370, -350) -> Picture {
        setPenColor(cm.lightBlue)
        setFillColor(cm.darkGray)
        left(45)
        left(90, 500)
    }

    def draw() {
        pic.draw()
    }

    def check(l: Lander) {
        if (l.body.collidesWith(pic)) {
            if (l.velocity.y.abs > 3) {
                drawCenteredMessage("You Lose", red, 39)
            }
            else {
                drawCenteredMessage("You Win", green, 30)
            }
            stopAnimation()
        }
    }

}

val l = new Lander()
l.draw()

val m = new Moon()
m.draw()

animate {
    l.step()
    m.check(l)
}
activateCanvas()
```
