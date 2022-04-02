cleari()
setAnimationDelay(0)
setBackground(white)
setPenColor(darkGray)
def fill = ColorMaker.hsl(54, 0.76, 0.84)
setFillColor(fill)

hop(100)
right(45)
def sq(s:Int){
    repeat(4) {
        forward(s)
        right(90)
    }
}

sq(50)
setFillColor(noColor)
hop(50)
right(90)
hop(25)
left(90)
forward(20)
right(90)
forward(35)
right(90)
forward(100)
right(90)
forward(100)
left(90)
forward(50)
left(90)
forward(150)
right(90)
forward(150)
right(90)
forward(75)
right(90)
forward(15)
left(90)
hop(50)
right(90)
setFillColor(fill)
sq(100)
def direction{
    write("s")
    forward(50)
    hop(20)
    write("n")
    hop(-45)
    right(90)
    hop(-40)
    left(90)
    hop(15)
    write("w")
    hop(-15)
    right(90)
    hop(15)
    forward(50)
    hop(10)
    left(90)
    hop(10)
    write("e")
   
}

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

draw(directions.withTranslation(-250, 100))
