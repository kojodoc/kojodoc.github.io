clear()
setBackground(white)
setSpeed(superFast)
setPenColor(darkGray)

def centeredCircle(r: Int) {
    savePosHe()
    right(90)
    hop(r)
    left(90)
    circle(r)
    restorePosHe()
}

repeatFor(0 to 2) { n =>
    val r = 100 + n * 100
    centeredCircle(r)
}

repeatFor(0 to 23) { i =>
    val n = i * 15
    savePosHe()
    left(n)
    hop(-500)
    forward(1000)
    restorePosHe()
}

