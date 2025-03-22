<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Creating Sprite-sheets via Kojo-animations.

This activity is a work in progress...

In this activity, the core idea is to create individual character images via [Kojo animations](https://www.kogics.net/kojo-level-3-ebook), and to stitch these images together into sprite-sheets.

The following code shows an example of creating individual character images via Kojo animations:

```scala
size(200, 200)
cleari()
setBackground(null)

def arm(a: Double, l: Double): Picture = {
  picStack(
    Picture.hline(l/2),
    Picture.hline(0.7 * l)
      .withRotation(a + 15)
      .withTranslation(l/2, 0)
  ).withRotation(a)
}

def stickMan(armAngle: Double): Picture = {
  val head = Picture.circle(20).withTranslation(0, 100)
  val body = Picture.vline(30).withTranslation(0, 30)
  val leftLeg = Picture.hline(60).withRotation(240).withTranslation(-10, 20)
  val rightLeg = Picture.hline(60).withRotation(-60).withTranslation(10, 20)
  val leftArm = arm(armAngle, 70).withTranslation(10, 70)
  val rightArm = arm(armAngle, 70).withTranslation(10, 70).withFlippedX

  picStack(
    head.withPenThickness(12).withFillColor(cm.brown).withPenColor(cm.brown),
    leftLeg.withPenThickness(16),
    rightLeg.withPenThickness(16),
    leftArm.withPenThickness(12),
    rightArm.withPenThickness(12),
    body.withPenThickness(28).withFillColor(cm.brown).withPenColor(cm.brown),
  ).withTranslation(0, -55)
}

// Animation state: just one value — the arm angle
def armAngleProp(state: Seq[Double]) = state(0)

def makeFrame(state: Seq[Double]): Picture = {
  val angle = armAngleProp(state)
  if (angle % 10 < 0.2) {
    // this is where we save off the character images from close to the desired frames
    exportThumbnail(f"man-$angle%.2f", 64)
  }
  stickMan(angle)
}

val anim = Transition(
  2,               // duration in seconds
  Seq(5.0),       // start angle
  Seq(40.0),       // end angle
  easing.Linear,   // smooth linear animation
  makeFrame,       // how to draw each frame
  false            // do not hide the final picture
)

run(anim)
```

More information coming soon...