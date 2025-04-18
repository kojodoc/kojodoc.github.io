size(600, 600)
cleari()
setSpeed(superFast)
val cb = canvasBounds
val bgclr = cm.linearMultipleGradient(cb.x, cb.y, cb.x + cb.width, cb.y + cb.height, List(0, 0.8, 1), List(red, cm.darkOrange, orange))
setBackground(bgclr)

var clr = cm.radialMultipleGradient(0, 0, 180, List(0, 0.5, 1), List(cyan, blue, black), true)
setPenColor(black)
setFillColor(clr)
repeat(18) {
    repeat(5) {
        forward(100)
        right(72)
    }
    right(20)
}
