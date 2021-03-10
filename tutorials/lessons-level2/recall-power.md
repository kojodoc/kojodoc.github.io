<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Sample game - Recall Power

This activity has the following desired goals:
* Learning to understand a given (more complex) game (**M, T**).
* Learning to make selected changes in a given piece of (complex) code (**M, T**).

### Game code

The code for the game is shown below. Study it to fully understand how the game works.

```scala
cleari()
setBackground(white)
val cb = canvasBounds

val randomNums = ArrayBuffer.empty[Int]

repeat(4) {
    var n = random(1, 10)
    while (randomNums.contains(n)) {
        n = random(1, 10)
    }
    randomNums.append(n)
}

def gameOver() {
    stopAnimation()
    erasePictures()
    drawCenteredMessage(s"Game Over. Your score is: $score", cm.darkGreen, 30)
}

var currNumber = 0
var prevNum = 0
var currNumberPic = Picture.text("")
var playerTurn = false
val currSeq = ArrayBuffer.empty[Int]
var currSeqIdx = 0
val numToPic = HashMap.empty[Int, Picture]
var seqLen = 4
var erase = false
var score = 0

val scorePic = Picture.text(score, 20)
scorePic.setPosition(cb.x, cb.y + cb.height)
scorePic.setPenColor(black)

def reset() {
    playerTurn = false
    currSeq.clear()
    currSeqIdx = 0
    seqLen += 1
    horivert.setFillColor(cm.darkBlue)
}

def currClickHandler(n: Int) {
    if (n == currSeq(currSeqIdx)) {
        if (currSeqIdx == currSeq.length - 1) {
            reset()
        }
        else {
            currSeqIdx += 1
        }
        score += 1
        scorePic.update(score)
    }
    else {
        gameOver()
    }
}

onKeyPress { c =>
    if (playerTurn) {
        val num = c - 48
        val pic = numToPic.getOrElse(num, null)
        if (pic != null) {
            pic.setPenColor(red)
        }
        else {
            gameOver()
        }
    }
}

onKeyRelease { c =>
    if (playerTurn) {
        val num = c - 48
        val pic = numToPic.getOrElse(num, null)
        if (pic != null) {
            pic.setPenColor(black)
            currClickHandler(num)
        }
        else {
            gameOver()
        }
    }
}

def textOnRect(n: Int) = {
    val pic = penColor(black) -> picStackCentered(fillColor(cm.darkBlue) -> Picture.rectangle(50, 50), Picture.text(n, 20))
    pic.onMousePress { (x, y) =>
        if (playerTurn) {
            pic.setPenColor(red)
        }
    }
    pic.onMouseRelease { (x, y) =>
        if (playerTurn) {
            pic.setPenColor(black)
            currClickHandler(n)
        }
    }
    numToPic.put(n, pic)
    pic
}

val horizontalPics = picRowCentered(
    textOnRect(randomNums(0)), Picture.hgap(50), textOnRect(randomNums(1)))

val verticalPics = picColCentered(
    textOnRect(randomNums(2)), Picture.vgap(50), textOnRect(randomNums(3)))

val horivert = picStackCentered(horizontalPics, verticalPics)

drawCentered(horivert)

draw(scorePic)

def switchToPlayerMode() {
    playerTurn = true
    horivert.setFillColor(cm.lightBlue)
}

timer(500) {
    if (!playerTurn) {
        if (erase) {
            currNumberPic.erase()
            erase = false
            if (currSeq.length == seqLen) {
                switchToPlayerMode()
            }
        }
        else {
            currNumber = randomFrom(randomNums)
            while (currNumber == prevNum) {
                currNumber = randomFrom(randomNums)
            }
            currSeq.append(currNumber)
            currNumberPic = Picture.text(currNumber, 20)
            currNumberPic.setPenColor(cm.darkGreen)
            drawCentered(currNumberPic)
            erase = true
            prevNum = currNumber
        }
    }
}
activateCanvas()
val maxTime = 60
showGameTime(maxTime + 1, "", cm.darkGreen, 15)

timer(maxTime * 1000) {
    gameOver()
}
```

--- 

### Exercise

**1.** Improve the dynamics of the game as you see fit!



