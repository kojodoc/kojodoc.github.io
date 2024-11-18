<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## A simple platformer game

This activity has the following desired goals:
* Students will know how to write a platformer game (**A**).
* Students will understand the core ideas behind platformer games (**M**).
* Students will be able to take a given game and make it better (**T**).

---

### Steps to be followed:
1. Understand the game below.
1. Extend the game so that it uses frameDeltaTime.
1. Refine the game as desired.

---

### Game assets and starter code

Download the zip file with the assets for this lesson - [platformer1-assets.zip](platformer1-assets.zip). This zip file contains the following files:
```
halfway-target.png
level1.tmx
player.png
target.png
tiles.png
```

Uncompress this zip-file and put it under any folder on your computer. Let's call this folder `full/path/to/assets`.

So now the above images will be in the folder `full/path/to/assets/platformer1-assets`.

The code for the game is shown below. Study it to fully understand how the game works. To run the game, save the code below inside the assets folder, then run the code from there (via a `File -> Open` in Kojo).


```scala
// #exec template /picgaming

clearOutput()
cleari()
disablePanAndZoom()

println("To win the game, find and drink the red-ball potion and then return to the starting point to drink the (initially covered) green-star potion.")

scroll(-canvasBounds.x, canvasBounds.y)
setBackground(ColorMaker.hsl(189, 0.03, 0.45))

// Tiled map layer of tiles that you collide with
val collisionLayer = 1

class Player(tx: Int, ty: Int, world: TileWorld) {
    val playerPos = world.tileToKojo(TileXY(tx, ty))
    val sheet = SpriteSheet("player.png", 30, 42)

    // player images are 30x40
    // scale the player down to fit into a 24 pixel wide tile
    def playerPicture(img: Image) = {
        val pic = Picture.image(img)
        pic.scale(0.8)
        pic
    }

    val stillRight = picBatch(playerPicture(sheet.imageAt(0, 0)))
    val stillLeft = picBatch(playerPicture(sheet.imageAt(0, 1)))

    val runningRight = picBatch(List(
        sheet.imageAt(0, 2),
        sheet.imageAt(1, 2),
        sheet.imageAt(2, 2),
        sheet.imageAt(3, 2),
        sheet.imageAt(4, 2)
    ).map(playerPicture))

    val runningLeft = picBatch(List(
        sheet.imageAt(0, 3),
        sheet.imageAt(1, 3),
        sheet.imageAt(2, 3),
        sheet.imageAt(3, 3),
        sheet.imageAt(4, 3)
    ).map(playerPicture))

    val jumpingRight = picBatch(List(
        sheet.imageAt(0, 0),
        sheet.imageAt(1, 0),
        sheet.imageAt(2, 0),
        sheet.imageAt(3, 0)
    ).map(playerPicture))

    val jumpingLeft = picBatch(List(
        sheet.imageAt(0, 1),
        sheet.imageAt(1, 1),
        sheet.imageAt(2, 1),
        sheet.imageAt(3, 1)
    ).map(playerPicture))

    var currentPic = stillRight
    currentPic.setPosition(playerPos)

    var facingRight = true
    val gravity = -0.1
    val speedX = 3.0
    var speedY = -1.0
    var inJump = false

    def step() {
        stepCollisions()
        stepFood()
    }

    var goalEnabled = false
    def stepFood() {
        if (currentPic.collidesWith(halfwayGoal)) {
            halfwayGoal.erase()
            goal.setOpacity(1)
            goalEnabled = true
        }
        if (goalEnabled) {
            if (currentPic.collidesWith(goal)) {
                goal.erase()
                stopAnimation()
                drawCenteredMessage("You Win!", white, 30)
            }
        }
    }

    def stepCollisions() {
        if (isKeyPressed(Kc.VK_RIGHT)) {
            facingRight = true
            updateImage(runningRight)
            currentPic.translate(speedX, 0)
            if (world.hasTileAtRight(currentPic, collisionLayer)) {
                world.moveToTileLeft(currentPic)
            }
        }
        else if (isKeyPressed(Kc.VK_LEFT)) {
            facingRight = false
            updateImage(runningLeft)
            currentPic.translate(-speedX, 0)
            if (world.hasTileAtLeft(currentPic, collisionLayer)) {
                world.moveToTileRight(currentPic)
            }
        }
        else {
            if (facingRight) {
                updateImage(stillRight)
            }
            else {
                updateImage(stillLeft)
            }
        }

        if (isKeyPressed(Kc.VK_UP)) {
            if (!inJump) {
                speedY = 5
            }
        }

        speedY += gravity
        speedY = math.max(speedY, -10)
        currentPic.translate(0, speedY)

        if (world.hasTileBelow(currentPic, collisionLayer)) {
            inJump = false
            world.moveToTileAbove(currentPic)
            speedY = 0
        }
        else {
            inJump = true
            if (world.hasTileAbove(currentPic, collisionLayer)) {
                world.moveToTileBelow(currentPic)
                speedY = -1
            }
        }

        if (inJump) {
            if (facingRight) {
                updateImage(jumpingRight)
            }
            else {
                updateImage(jumpingLeft)
            }
            currentPic.showNext(200)
        }
        else {
            currentPic.showNext()
        }
        scrollIfNeeded()
    }

    var cb = canvasBounds
    def scrollIfNeeded() {
        val threshold = 200
        val pos = currentPic.position
        if (cb.x + cb.width - pos.x < threshold) {
            scroll(speedX, 0)
            cb = canvasBounds
        }
        else if (pos.x - cb.x < threshold) {
            scroll(-speedX, 0)
            cb = canvasBounds
        }
    }

    def updateImage(newPic: BatchPics) {
        if (newPic != currentPic) {
            currentPic.invisible()
            newPic.visible()
            newPic.setPosition(currentPic.position)
            currentPic = newPic
        }
    }

    def draw() {
        drawAndHide(stillLeft, runningRight, runningLeft, jumpingRight, jumpingLeft)
        currentPic.draw()
    }
}

class AttackerUpDown(tx: Int, ty: Int, world: TileWorld) {
    val playerPos = world.tileToKojo(TileXY(tx, ty))
    val sheet = SpriteSheet("tiles.png", 24, 24)
    // make attacker slighty smaller than a tile - to prevent picture based collision
    // with the player in an adjacent tile
    def attackerPicture(img: Image) = {
        val pic = Picture.image(img)
        pic.translate(0.2, 0.2)
        pic.scale(0.98)
        pic
    }

    var currentPic = picBatch(List(
        sheet.imageAt(0, 6),
        sheet.imageAt(1, 6)
    ).map(attackerPicture))

    currentPic.setPosition(playerPos)

    val gravity = -0.03
    //    var speedX = 0.0
    var speedY = -2.0

    def step() {
        speedY += gravity
        speedY = math.max(speedY, -10)
        currentPic.translate(0, speedY)
        currentPic.showNext()
        if (world.hasTileBelow(currentPic, collisionLayer)) {
            world.moveToTileAbove(currentPic)
            speedY = 5
        }
        else if (world.hasTileAbove(currentPic, collisionLayer)) {
            world.moveToTileBelow(currentPic)
            speedY = -2
        }
    }

    def updateImage(newPic: BatchPics) {
        if (newPic != currentPic) {
            currentPic.invisible()
            newPic.visible()
            newPic.setPosition(currentPic.position)
            currentPic = newPic
        }
    }

    def draw() {
        currentPic.draw()
    }
}

val tileWorld =
    new TileWorld("level1.tmx")

// Create a player object and set the level it is in
val player = new Player(9, 5, tileWorld)
val attackers = List(
    new AttackerUpDown(14, 2, tileWorld),
    new AttackerUpDown(17, 3, tileWorld),
    new AttackerUpDown(22, 9, tileWorld),
    new AttackerUpDown(32, 2, tileWorld),
    new AttackerUpDown(35, 3, tileWorld)
)

val goal = {
    val pic = Picture.image("target.png")
    pic.scale(0.3)
    pic
}
goal.setPosition(tileWorld.tileToKojo(TileXY(9, 2)))
goal.setOpacity(0.4)

val halfwayGoal = {
    val pic = Picture.image("halfway-target.png")
    pic.scale(0.5)
    pic
}
halfwayGoal.setPosition(tileWorld.tileToKojo(TileXY(41, 15)))

tileWorld.draw()
player.draw()
draw(goal)
draw(halfwayGoal)
attackers.foreach { attacker =>
    attacker.draw()
}

animate {
    tileWorld.step()
    player.step()
    attackers.foreach { attacker =>
        attacker.step()
        if (player.currentPic.collidesWith(attacker.currentPic)) {
            player.currentPic.rotate(30)
            stopAnimation()
        }
    }
}

activateCanvas()

// game resources sourced from: https://github.com/pricheal/pygame-tiled-demo
```
