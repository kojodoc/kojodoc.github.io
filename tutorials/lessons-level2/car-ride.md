<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Game refinement project 1 - Dino

This activity has the following desired goals:
* Learning to understand a given game and refine it using images and sounds (**M, T**).
* Practice with exporting a game as a web-app (**M, T**).

---

### Steps to be followed:
1. Understand the game below.
1. Refine the game-play (make the other cars obstruct myCar more, allow game to continue after a collision with reduced energy, etc).
1. Add background and character images to the game to make it more attractive.
1. Add sounds to the game to make it more attractive.
1. Load all assets from the web.
1. Test the game in iKojo.
1. Export the game as a web-app.
1. Test on PC and mobile.

---

### Game starter code

The code for the game is shown below. Study it to fully understand how the game works.

```scala
cleari()
originBottomLeft()
drawStage(black)

def rectanglePic(w: Int, h: Int) = Picture {
    repeat(2) {
        forward(h)
        right()
        forward(w)
        right()
    }
}

val myCar = rectanglePic(40, 80)
myCar.setPenColor(cm.darkGray)
myCar.setFillColor(cm.lightBlue)
myCar.setPosition(cwidth / 2, cheight / 2)
draw(myCar)

def otherCarMaker(x: Double) = {
    val car = rectanglePic(40, 80)
    car.setPenColor(cm.darkGray)
    car.setFillColor(cm.lightCoral)
    car.setPosition(x, cheight)
    car
}

val cars = HashSet.empty[Picture]

val otherSpeed = 8
val mySpeed = 6

timer(700) {
    val otherCar = otherCarMaker(randomDouble(0, cwidth - 40))
    draw(otherCar)
    cars.add(otherCar)
}

animate {
    repeatFor(cars) { car =>
        car.translate(0, -otherSpeed)
        if (car.collidesWith(myCar)) {
            stopAnimation()
            drawCenteredMessage("You Lose", red, 30)
        }
    }

    if (isKeyPressed(Kc.VK_UP)) {
        myCar.translate(0, mySpeed)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        myCar.translate(0, -mySpeed)
    }
    if (isKeyPressed(Kc.VK_RIGHT)) {
        myCar.translate(mySpeed, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        myCar.translate(-mySpeed, 0)
    }
}
showGameTime(60, "You Win", green, 15)
activateCanvas()
```

