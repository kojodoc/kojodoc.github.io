size(600, 600)
cleari()
originBottomLeft()
setSpeed(superFast)
setBackground(white)
setPenColor(black)

val tileCount = 10
val tileSize = cwidth / tileCount


def recp(n: Int, l: Double) {
    if (n == 1) {
        forward(l)
    }
    else {
        forward(l)
        right(90)
        recp(n-1, l * 0.9)
    }
}

def shape() {
    savePosHe()
//    recp(random(10, 10), tileSize)
    recp(random(5, 25), tileSize)
    restorePosHe()
}

def block(posX: Double, posY: Double) {
    setPosition(posX, posY)
    setFillColor(randomColor.fadeOut(0.5))
    shape()
}

repeatFor(rangeTill(0, cheight, tileSize)) { posY =>
    repeatFor(rangeTill(0, cwidth, tileSize)) { posX =>
        block(posX, posY)
    }
}

