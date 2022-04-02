cleari()
setPenColor(darkGray)
setFillColor(ColorMaker.hsl(54, 0.76, 0.84))

setAnimationDelay(0)
def rect(w: Int, h: Int) {
    repeat(2) {
        forward(h)
        right(90)
        forward(w)
        right(90)
    }
}

right(45)
rect(100, 60)
hop(60)
right(90)
savePosHe()
hop(140)
right(90)
rect(40, 20)
hop(20)
rect(40, 40)
restorePosHe()
hop(50)
left(90)
rect(90, 40)
left(90)
hop(50)
right(90)
rect(50, 50)
hop(50)
savePosHe()
rect(50, 50)
right(90)
hop(50)
right(90)
hop(10)
right(180)
rect(10, 30)
hop(30)
rect(50, 30)
hop(-30)
right(90)
hop(10)
left(90)
rect(40, 15)
hop(15)
rect(40, 15)
restorePosHe()
rect(25, 25)

def directions = {
    picStack(
        picColCentered(
            Picture.text("S").withPenColor(black),
            Picture.vgap(3),
            Picture.vline(50).withPenColor(black).withPenThickness(1),
            Picture {
                setFillColor(gray)
                left(90)
                forward(5)
                right(120)
                forward(10)
                right(120)
                forward(10)
                right(120)
                forward(5)
            }.withPenThickness(1).withPenColor(black),
            Picture.vgap(3),
            Picture.text("N").withPenColor(black),
        ),
        picRowCentered(
            Picture.text("W").withPenColor(black),
            Picture.hgap(3),
            Picture.hline(50).withPenThickness(1).withPenColor(black),
            Picture.hgap(3),
            Picture.text("E").withPenColor(black),
        ).withTranslation(-39, 37)
    )
}

draw(directions.withTranslation(-50, 100))
