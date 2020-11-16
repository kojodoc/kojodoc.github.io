<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 2 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Sample game - Tic Tac Toe

This activity has the following desired goals:
* Learning to understand a given (more complex) game (**M, T**).
* Learning to make selected changes in a given piece of (complex) code (**M, T**).

### Game code

The code for the game is shown below. Study it to fully understand how the game works.

```scala
cleari()
val cb = canvasBounds
setBackground(black)
//disablePanAndZoom()
val len = 100

val boardSize = len * 3
val bx = cb.x + (cb.width - boardSize) / 2
val by = cb.y + (cb.height - boardSize) / 2

val margin = 20
val len2 = len - 2 * margin
val lineWidth = 8

def background() {
    setPenColor(noColor)
    setFillColor(black)
    val mgn = lineWidth / 2
    setPosition(mgn, mgn)
    repeat(4) {
        forward(len - 2 * mgn)
        right(90)
    }
}

def cross = Picture {
    background()
    setPenThickness(lineWidth)
    setPenColor(ColorMaker.hsl(200, 1.00, 0.50))
    setPosition(margin, margin)
    lineTo(len - margin, len - margin)
    setPosition(len - margin, margin)
    lineTo(margin, len - margin)
}

def o = Picture {
    background()
    setPenThickness(lineWidth)
    setPenColor(ColorMaker.hsl(120, 0.86, 0.64))
    setPosition(len / 2, margin)
    setHeading(0)
    left(360, len2 / 2)
}

def blank = Picture {
    background()
}

val lines = Picture {
    setPenThickness(lineWidth)
    repeatFor(1 to 2) { n =>
        setPosition(len * n, 0)
        lineTo(len * n, 3 * len)
    }
    repeatFor(1 to 2) { n =>
        setPosition(0, len * n)
        lineTo(3 * len, len * n)
    }
}

def noPic = Picture {}

val pics = ArrayBuffer(
    ArrayBuffer(noPic, noPic, noPic),
    ArrayBuffer(noPic, noPic, noPic),
    ArrayBuffer(noPic, noPic, noPic)
)
val state = ArrayBuffer(
    ArrayBuffer(0, 0, 0),
    ArrayBuffer(0, 0, 0),
    ArrayBuffer(0, 0, 0)
)

var nextCross = true
var done = false

def drawBoard() {
    lines.setPosition(bx, by)
    draw(lines)
    repeatFor(0 until 3) { x =>
        repeatFor(0 until 3) { y =>
            val pic = blank
            pic.setPosition(bx + x * len, by + y * len)
            draw(pic)
            pic.onMousePress { (_, _) =>
                if (!done) {
                    val newPic = if (nextCross) {
                        val np = cross
                        np.setPosition(pic.position)
                        state(x)(y) = 2
                        np
                    }
                    else {
                        val np = o
                        np.setPosition(pic.position)
                        state(x)(y) = 1
                        np
                    }
                    nextCross = !nextCross
                    pics(x)(y) = newPic
                    draw(newPic)
                    pic.erase()
                    checkWin()
                    if (!done) {
                        checkDraw()
                    }
                }
            }
            pics(x)(y) = pic
            state(x)(y) = 0
        }
    }
}

def column(x: Int) = state(x)
def row(y: Int) = ArrayBuffer(state(0)(y), state(1)(y), state(2)(y))
def diagonal1 = ArrayBuffer(state(0)(0), state(1)(1), state(2)(2))
def diagonal2 = ArrayBuffer(state(0)(2), state(1)(1), state(2)(0))

def checkWinFor(n: Int): Boolean = {
    var win = false
    val target = ArrayBuffer(n, n, n)
    repeatFor(0 until 3) { x =>
        win = { column(x) == target }
        if (win) {
            return true
        }
    }

    repeatFor(0 until 3) { y =>
        win = { row(y) == target }
        if (win) {
            return true
        }
    }
    win = { diagonal1 == target }
    if (win) {
        return true
    }
    win = { diagonal2 == target }
    win
}

def gameOver(msg: String) {
    val pmsg = Picture {
        setPenFontSize(80)
        setPenColor(white)
        write(msg)
    }
    val pic = picColCentered(pmsg, Picture.vgap(cb.height - 100))
    drawCentered(pic)
    done = true
}

def checkWin() {
    if (checkWinFor(1)) {
        gameOver("O Won")
    }
    else if (checkWinFor(2)) {
        gameOver("X Won")
    }
}

def checkDraw() {
    var filled = true
    repeatFor(0 until 3) { x =>
        repeatFor(0 until 3) { y =>
            if (state(x)(y) == 0) {
                filled = false
            }
        }
    }
    if (filled) {
        done = true
        gameOver("It's a Draw")
    }
}

drawBoard()
```

--- 

### Exercise

**1.** Make the Xs purple and the Os yellow in color.

**2.** Disable winning along the diagonals (only temporarily, just for the purpose of understanding and modifying).


