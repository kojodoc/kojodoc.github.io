// Sample game submitted by Ansh Arora (aarora85@asu.edu)

cleari()
drawStage(cm.black)
val cb = canvasBounds

// Player Cannon
val cannon = Picture.rectangle(60, 20)
cannon.setFillColor(cm.white)
cannon.setPosition(cb.x + cb.width / 2, cb.y + 30)
draw(cannon)

// Game Variables
val aliens = ArrayBuffer.empty[Picture]
val lasers = ArrayBuffer.empty[Picture]
val alienSpeed = 60.0
val laserSpeed = 200.0
var score = 0
var misses = 0
val maxMisses = 3
val timeLimit = 30
var timeLeft = timeLimit
var spawnTime = 0.0
var timeAccumulator = 0.0

// Scoreboard
var scoreCard = Picture.text(s"Score: $score", 18)
scoreCard.setPosition(cb.x + 20, cb.y + cb.height - 40)
scoreCard.setPenColor(white)
draw(scoreCard)

var missCard = Picture.text(s"Misses: $misses / $maxMisses", 18)
missCard.setPosition(cb.x + 150, cb.y + cb.height - 40)
missCard.setPenColor(red)
draw(missCard)

var timerCard = Picture.text(s"Time: $timeLeft", 18)
timerCard.setPosition(cb.x + cb.width - 120, cb.y + cb.height - 40)
timerCard.setPenColor(white)
draw(timerCard)

// Game end
def gameLost() {
    stopAnimation()
    drawCenteredMessage("Game Over!", red, 30)
}
def gameWon() {
    stopAnimation()
    drawCenteredMessage(s"You Win! Score: $score", green, 30)
}

// Animate
val cannonSpeed = 200

animate {
    val dt = frameDeltaTime
    spawnTime += dt
    timeAccumulator += dt

    // Move cannon
    if (isKeyPressed(Kc.VK_LEFT)) {
        cannon.translate(-cannonSpeed * dt, 0)
    }
    if (isKeyPressed(Kc.VK_RIGHT)) {
        cannon.translate(cannonSpeed * dt, 0)
    }

    // Fire laser
    if (isKeyPressed(Kc.VK_SPACE)) {
        if (lasers.isEmpty || lasers.last.position.y - cannon.position.y > 40) {
            val laser = Picture.rectangle(4, 20)
            laser.setFillColor(cm.red)
            laser.setPosition(cannon.position.x, cannon.position.y + 10)
            lasers.append(laser)
            draw(laser)
        }
    }

    // Spawn aliens every 1 sec
    if (spawnTime > 1.0) {
        val alien = Picture.rectangle(40, 40)
        alien.setFillColor(cm.green)
        alien.setPosition(randomDouble(cb.x + 40, cb.x + cb.width - 40), cb.y + cb.height - 40)
        aliens.append(alien)
        draw(alien)
        spawnTime = 0.0
    }

    // Move aliens
    val outOfBounds = ArrayBuffer.empty[Picture]
    aliens.foreach { a =>
        a.translate(0, -alienSpeed * dt)
        if (a.position.y < cb.y + 10) {
            outOfBounds.append(a)
        }
    }
    outOfBounds.foreach { a =>
        a.erase()
        aliens.remove(aliens.indexOf(a))
        misses += 1
        missCard.erase()
        missCard = Picture.text(s"Misses: $misses / $maxMisses", 18)
        missCard.setPosition(cb.x + 150, cb.y + cb.height - 40)
        missCard.setPenColor(red)
        draw(missCard)
        if (misses >= maxMisses) {
            gameLost()
        }
    }

    // Move lasers
    val usedLasers = ArrayBuffer.empty[Picture]
    lasers.foreach { l =>
        l.translate(0, laserSpeed * dt)
        if (l.position.y > cb.y + cb.height) {
            usedLasers.append(l)
        }
    }

    // Collision detection
    val hitAliens = ArrayBuffer.empty[Picture]
    for (l <- lasers; a <- aliens) {
        if (l.collidesWith(a)) {
            usedLasers.append(l)
            hitAliens.append(a)
            score += 1
        }
    }

    // Remove hit aliens and lasers
    hitAliens.foreach { a =>
        a.erase()
        aliens.remove(aliens.indexOf(a))
    }
    usedLasers.foreach { l =>
        l.erase()
        if (lasers.contains(l)) lasers.remove(lasers.indexOf(l))
    }

    // Update score
    if (hitAliens.nonEmpty) {
        scoreCard.erase()
        scoreCard = Picture.text(s"Score: $score", 18)
        scoreCard.setPosition(cb.x + 20, cb.y + cb.height - 40)
        scoreCard.setPenColor(white)
        draw(scoreCard)
    }

    // Timer update
    if (timeAccumulator >= 1.0) {
        timeLeft -= 1
        timeAccumulator = 0.0
        timerCard.erase()
        timerCard = Picture.text(s"Time: $timeLeft", 18)
        timerCard.setPosition(cb.x + cb.width - 120, cb.y + cb.height - 40)
        timerCard.setPenColor(white)
        draw(timerCard)

        if (timeLeft <= 0) {
            gameWon()
        }
    }
}

activateCanvas()