cleari()
//showAxes()
val cb = canvasBounds

val pic1 = Picture.rectangle(50, 50)
pic1.setPosition(cb.x, cb.y)

val pic2 = Picture.rectangle(50, 50)
pic2.setPosition(cb.x, cb.y + cb.height - 50)

val pic3 = Picture.rectangle(50, 50)
pic3.setPosition(cb.x + cb.width - 50, cb.y)

val pic4 = Picture.rectangle(50, 50)
pic4.setPosition(cb.x + cb.width - 50, cb.y + cb.height - 50)

val pic5 = Picture.rectangle(50, 50)
pic5.setPosition(cb.x + cb.width / 2 - 25, cb.y + cb.height / 2 - 25)

draw(pic1, pic2, pic3, pic4, pic5)
