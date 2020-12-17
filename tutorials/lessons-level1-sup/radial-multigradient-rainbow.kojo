clear()
setBackground(white)
setSpeed(fast)
val cb = canvasBounds
val clr = cm.radialMultipleGradient(
    400, 0, 400,
    List(4.0/10, 5.0/10, 6.0/10, 7.0/10, 8.0/10, 9.0/10, 10.0/10),
    List(cm.violet, cm.indigo, blue, green, yellow, orange, cm.red), false
)

setFillColor(clr)
savePosHe()
right(180, 400)
restorePosHe()
right(90)
hop(250)
left(90)
setFillColor(white)
setPenColor(white)
right(180, 150)

