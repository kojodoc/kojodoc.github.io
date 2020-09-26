size(600, 600)
cleari()
setSpeed(fast)
val cb = canvasBounds
val bgclr = cm.linearGradient(cb.x, cb.y + cb.height, red, cb.x + cb.width, cb.y, yellow, true)
setBackground(bgclr)

var clr = cm.radialGradient(0, 0, black, 100, blue, true)
setPenColor(black)
setFillColor(clr)
repeat(18) {
    repeat(5) {
        forward(100)
        right(72)
    }
    right(20)
}
