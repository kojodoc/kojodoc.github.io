def lotusPetal(radius: Double, radiusOuter: Double,
               theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    import s._
    val tDelta = thetaExtent / 2
    beginShape()
    curveVertexRt(radius, theta - tDelta)
    curveVertexRt(radius, theta - tDelta)

    val rExtent = radiusOuter / radius

    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.6), theta - tDelta * 22 / 30)
    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.7), theta - tDelta * 2 / 30)
    curveVertexRt(radius * rExtent, theta)
    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.7), theta + tDelta * 2 / 30)
    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.6), theta + tDelta * 22 / 30)

    curveVertexRt(radius, theta + tDelta)
    curveVertexRt(radius, theta + tDelta)
    endShape()
}

def diya(radius: Double, radiusOuter: Double,
         theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    import s._
    val tDelta = thetaExtent / 2
    val rExtent = radiusOuter / radius
    beginShape()
    curveVertexRt(radius, theta)
    curveVertexRt(radius, theta)
    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.5), theta - tDelta / 4)
    curveVertexRt(radius * rExtent, theta)
    curveVertexRt(radius * rExtent, theta)
    endShape()

    beginShape()
    curveVertexRt(radius * rExtent, theta)
    curveVertexRt(radius * rExtent, theta)
    curveVertexRt(mathx.lerp(radius, radius * rExtent, 0.5), theta + tDelta / 4)
    curveVertexRt(radius, theta)
    curveVertexRt(radius, theta)
    endShape()
}

def pointedPetal(radius: Double, radiusOuter: Double,
                 theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    val tDelta = thetaExtent / 2
    import s._
    beginShape()

    curveVertexRt(radius, theta - tDelta)
    curveVertexRt(radius, theta - tDelta)

    curveVertexRt(radius + (radiusOuter - radius) / 2, theta - 2 * tDelta / 3)

    curveVertexRt(radiusOuter, theta)

    curveVertexRt(radius + (radiusOuter - radius) / 2, theta + 2 * tDelta / 3)

    curveVertexRt(radius, theta + tDelta)
    curveVertexRt(radius, theta + tDelta)

    endShape()
}

def pointedPetal2(radius: Double, radiusOuter: Double,
                  theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    val tDelta = thetaExtent / 2
    import s._
    beginShape()

    curveVertexRt(radius, theta - tDelta)
    curveVertexRt(radius, theta - tDelta)

    curveVertexRt(radiusOuter, theta)

    curveVertexRt(radius, theta + tDelta)
    curveVertexRt(radius, theta + tDelta)

    endShape()
}

def roundedPetal(radius: Double, radiusOuter: Double,
                 theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    val tDelta = thetaExtent / 2
    import s._
    implicit val s2 = s
    beginShape()

    curveVertexRt(radius, theta - tDelta)
    curveVertexRt(radius, theta - tDelta)

    curveVertexRt(radius + 3 * (radiusOuter - radius) / 4, theta - tDelta / 2)

    curveVertexRt(radiusOuter, theta)

    curveVertexRt(radius + 3 * (radiusOuter - radius) / 4, theta + tDelta / 2)

    curveVertexRt(radius, theta + tDelta)
    curveVertexRt(radius, theta + tDelta)

    endShape()
}

def semiCircularPetal(radius: Double, theta: Double, thetaExtent: Double) = Picture.fromVertexShape { s =>
    val tDelta = thetaExtent / 2
    import s._
    beginShape()

    curveVertexRt(radius, theta - tDelta)
    curveVertexRt(radius, theta - tDelta)

    curveVertexRt(radius + (0.7010526 * thetaExtent), theta - tDelta / 2)

    curveVertexRt(radius + (0.93333 * thetaExtent), theta)

    curveVertexRt(radius + (0.7010526 * thetaExtent), theta + tDelta / 2)

    curveVertexRt(radius, theta + tDelta)
    curveVertexRt(radius, theta + tDelta)

    endShape()
}

def inscribedTriangle(vertexR: Double, vertexTheta: Double) = Picture.fromVertexShape { s =>
    import s._
    beginShape()
    vertexRt(vertexR, vertexTheta)
    vertexRt(vertexR, vertexTheta + 120)
    vertexRt(vertexR, vertexTheta + 240)
    vertexRt(vertexR, vertexTheta)
    endShape()
}

def inscribedSquare(vertexR: Double, vertexTheta: Double) = Picture.fromVertexShape { s =>
    import s._
    beginShape()
    vertexRt(vertexR, vertexTheta)
    vertexRt(vertexR, vertexTheta + 90)
    vertexRt(vertexR, vertexTheta + 180)
    vertexRt(vertexR, vertexTheta + 270)
    vertexRt(vertexR, vertexTheta)
    endShape()
}

def altar(r: Double, gateRFraction: Double, gateTheta: Double) = Picture {
    setHeading(gateTheta)
    hop(r)
    left(90)
    val glen = r * gateRFraction
    hop(glen)
    repeat(4) {
        forward(r - glen)
        left()
        forward(r - glen)
        right()
        forward(r / 10)
        right()
        forward(r / 4)
        left()
        forward(r / 10)
        left()
        forward(r / 4)
        forward(glen * 2)
        forward(r / 4)
        left()
        forward(r / 10)
        left()
        forward(r / 4)
        right()
        forward(r / 10)
        right(90)
    }
}

def wings(r: Double, direction: Double, baseLength: Double) = Picture {
    setHeading(direction)
    hop(r)
    forward(baseLength)
    savePosHe()
    arc(baseLength / 2, 180)
    restorePosHe()
    arc(baseLength / 2, -180)
}

def trishoolThing(r: Double, direction: Double, baseLength: Double) = Picture {
    setHeading(direction)
    hop(r)
    forward(baseLength)
    back(baseLength / 4)
    right(180)
    savePosHe()
    arc(baseLength / 3, 180)
    arc(baseLength / 4, -180)
    restorePosHe()
    arc(baseLength / 3, -180)
    arc(baseLength / 4, 180)
}

def star(vertexR: Double, vertexTheta: Double) = Picture.fromVertexShape { s =>
    import s._
    beginShape()
    vertexRt(vertexR, vertexTheta)
    vertexRt(vertexR, vertexTheta + 144)
    vertexRt(vertexR, vertexTheta + 288)
    vertexRt(vertexR, vertexTheta + 432)
    vertexRt(vertexR, vertexTheta + 576)
    vertexRt(vertexR, vertexTheta)
    endShape()
}
