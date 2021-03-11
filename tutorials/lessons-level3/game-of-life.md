<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 3 Index</a> | <a href="/modules/modules-index.html">Modules</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## A simulation on a rectangular grid - Conway's game of life

This activity has the following desired goals:
* Learning about cellular automata (**A, M**).
* Learning to do simulations on a rectangular grid (**A, M**).
* Implement Conway's game of life (**M, T**).

### Step 0

Read up on [Cellular Automata](https://en.wikipedia.org/wiki/Cellular_automaton).

---

### Step 1

Type in the following code and run it:

```scala
size(500, 500)
cleari()
clearOutput()
originBottomLeft()
setBackground(white)
val n = 50
val dx = cwidth.toFloat / n
val dy = cheight.toFloat / n

def createPopulation(n: Int): ArrayBuffer[ArrayBuffer[Int]] = {
    val newPop = ArrayBuffer.empty[ArrayBuffer[Int]]

    repeatFor(0 until n) { x =>
        val populationColumn = ArrayBuffer.empty[Int]
        repeatFor(0 until n) { y =>
            populationColumn.append(0)
        }
        newPop.append(populationColumn)
    }
    newPop
}

var population = createPopulation(n)

def drawCell(x: Int, y: Int) {
    val cell = Picture.rectangle(dx, dy)
    cell.setPosition(x * dx, y * dy)
    cell.setPenThickness(0.1)
    cell.setPenColor(cm.lightBlue)
    draw(cell)
}

def drawLiveCell(x: Int, y: Int) {
    val cell = Picture.ellipseInRect(dx, dy)
    cell.setPosition(x * dx, y * dy)
    cell.setPenThickness(2)
    cell.setPenColor(cm.lightBlue)
    cell.setFillColor(cm.darkBlue)
    draw(cell)
}

def drawGrid() {
    repeatFor(0 until n) { x =>
        repeatFor(0 until n) { y =>
            drawCell(x, y)
        }
    }
}

def drawPopulation() {
    repeatFor(0 until n) { x =>
        repeatFor(0 until n) { y =>
            if (population(x)(y) == 1) {
                drawLiveCell(x, y)
            }
        }
    }
}

def populationCopy = {
    val newPop = createPopulation(n)
    repeatFor(0 until n) { x =>
        repeatFor(0 until n) { y =>
            newPop(x)(y) = population(x)(y)
        }
    }
    newPop
}

def inRange(n: Int, low: Int, high: Int) = {
    n >= low && n <= high
}

def evolveCell(x: Int, y: Int, newPop: ArrayBuffer[ArrayBuffer[Int]]) {
    if (inRange(x - 1, 0, n - 1) && inRange(y - 1, 0, n - 1)) {
        if (population(x - 1)(y - 1) == 1) {
            newPop(x)(y) = 1
            newPop(x - 1)(y - 1) = 0
        }
    }
}

def updatePopulation() {
    val newPop = populationCopy
    repeatFor(0 until n) { x =>
        repeatFor(0 until n) { y =>
            evolveCell(x, y, newPop)
        }
    }
    population = newPop
}

def initPopulation(init: ArrayBuffer[(Int, Int)]) {
    repeatFor(init) { xy =>
        population(xy._1)(xy._2) = 1
    }
}

def initPattern = ArrayBuffer((0, 0), (1, 0), (0, 1))
initPopulation(initPattern)

drawGrid()
drawPopulation()

timer(500) {
    erasePictures()
    updatePopulation()
    drawGrid()
    drawPopulation()
}
```

**Q1a.** Read through the code above and try to understand what it does. What does the above code do? How does it do it?

---

### Exploration

Make changes to the `evolveCell` command in the code above to play with different cellular automata simulations.

---

### Exercise

Change the `evolveCell` command to implement Conway's game of life. The cell rules ([from Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)) are the following:

1. Any live cell with two or three live neighbours survives.
1. Any dead cell with three live neighbours becomes a live cell.
1. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
