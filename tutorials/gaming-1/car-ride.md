<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Game refinement project 2 - Car Ride

This activity has the following desired goals:
* Learning to understand a given game and refine it using images and sounds (**M, T**).
* Practice with exporting a game as a web-app (**M, T**).

---

### Steps to be followed:
1. Understand the game below.
1. Refine the game-play (make the other cars obstruct myCar more, allow game to continue after a collision with reduced energy, etc).
1. Add background and character images to the game to make it more attractive.
1. Implement any other ideas for improvement that you can come up with.

---

### Game starter code

The code for the game is shown below. Study it to fully understand how the game works.

```scala
// #exec template /picgaming

cleari()
originBottomLeft()
drawStage(black)

val myCar = Picture.rectangle(40, 80)
myCar.setPenColor(cm.darkGray)
myCar.setFillColor(cm.lightBlue)
myCar.setPosition(cwidth / 2, cheight / 2)
draw(myCar)

def otherCarMaker(x: Double) = {
    val car = Picture.rectangle(40, 80)
    car.setPenColor(cm.darkGray)
    car.setFillColor(cm.lightCoral)
    car.setPosition(x, cheight)
    car
}

val cars = HashSet.empty[Picture]

val otherSpeed = 400
val mySpeed = 300

timer(700) {
    val otherCar = otherCarMaker(randomDouble(0, cwidth - 40))
    draw(otherCar)
    cars.add(otherCar)
}

animate {
    val dt = frameDeltaTime
    repeatFor(cars) { car =>
        car.translate(0, -otherSpeed * dt)
        if (car.collidesWith(myCar)) {
            stopAnimation()
            drawCenteredMessage("You Lose", red, 30)
        }
    }

    if (isKeyPressed(Kc.VK_UP)) {
        myCar.translate(0, mySpeed * dt)
    }
    if (isKeyPressed(Kc.VK_DOWN)) {
        myCar.translate(0, -mySpeed * dt)
    }
    if (isKeyPressed(Kc.VK_RIGHT)) {
        myCar.translate(mySpeed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_LEFT)) {
        myCar.translate(-mySpeed * dt, 0)
    }
}
showGameTime(60, "You Win", green, 15)
activateCanvas()
```

