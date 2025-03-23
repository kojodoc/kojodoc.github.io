<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Gaming-1 Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Creating Sprite-sheets via Kojo-animations.

In this activity, the core idea is to create individual character images via [Kojo animations](https://www.kogics.net/kojo-level-3-ebook), and to stitch these images together into sprite-sheets.


### Step 1

The following code shows an example of creating individual character images via a Kojo animation:

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

**Q1a.** How does the above code creating individual character images? Where are these images saved after the code runs?

**Q1b.** Why is the background color set to null in the above code?

**Q1c.** Why is the canvas size set to `(200, 200))` in the above code?


### Step 2

The next step is to stitch the images generated above into a sprite sheet. Assume that the images from the previous steps are available in a directory, and are named `man-10.png`, `man-20.png`, `man-30.png`, and `man-40.png`. The following code shows how to make a sprite-sheet out of these images.

```scala
size(64 * 4, 64)
cleari()
setBackground(null)

// change the following line as per the location of the assets folder on your computer
val assetsDir = "/home/lalit/work/gaming-1-trial/sprite-sheet-from-anims/"

// change the following line as per the location of the assets folder on your computer
val assetsDir = "full/path/to/assets/directory"


val pic1 = Picture.image(s"$assetsDir/man-10.png")
val pic2 = Picture.image(s"$assetsDir/man-20.png")
val pic3 = Picture.image(s"$assetsDir/man-30.png")
val pic4 = Picture.image(s"$assetsDir/man-40.png")

def sheet(n: Int): Picture = {
    if (n == 1) {
        Picture.image(s"$assetsDir/man-${n}0.png")
    }
    else {
        picStack(
            Picture.image(s"$assetsDir/man-${n}0.png").withTranslation((n - 1) * 64, 0),
            sheet(n - 1)
        )
    }
}

drawCentered(sheet(4))
```

**Q2a.** How does the code above create a sprite sheet?

**Q2b.** Why is the background color set to null in the above code?

**Q2c.** Why is the canvas size set to `(64 * 4, 64))` in the above code?

### Exercise

Do the following:
1. Create your own sprite sheet for the player
2. Create a sprite-sheet for the hunters
3. Incorporate these sprite sheets into the hunted-5 version of the game from the previous lesson.
