<div class="nav">
  <a href="../../index.html">Home</a> | <a href="index.html">Level 1s Index</a> | <a href="../../tutorials-index.html">Tutorials</a>
</div>

## Control flow

This activity has the following desired goals:
* Learning about sequencing, looping, selection, and calls in the context of the idea of control flow (**A, M**).
* Learning about the call/return based control flow in the context of command and function execution (**A, M**).
* Being able to describe the control flow in any program (or portion thereof) (**T**).

---

### Step 0

Read up on the [notional machine](/concepts/notional-machine.html) for Kojo.

---

### Step 1

Type in the following code and trace it:

```scala
def sum(n1: Int, n2: Int) = {
    n1 + n2
}

def sq(size: Int) = {
    repeat(4) {
        forward(size)
        right(90)
    }
}

clear()
val xx = sum(30, 40)
sq(xx)
hop(xx)
```

**Q1a** What does each line in the trace mean? Go through the trace and try to fully understand (take help from the explanation below as needed).

---

### Explanation

Control flow (or flow of control) is the order in which the instructions of a computer program are executed (by the CPU in a computer). There are four primary ways in which this happens:
* sequencing - this is the default mode of execution of a program - instructions are run one after the other.
* looping - special istructions (like repeat) make the program loop over a sequence of instructions.
* selection - lets you choose the next instrunction to run from alternative instructions - based on a condition.
* calls and returns - *calls* jump into previously defined functions or commands, supplying input values as needed, then carry out the instructions specified there, and finally *return* to the instruction right after the calling instruction. In the case of functions, the result of the computation/calculation carried out by the function is returned. In the case of commands, the unit value `()` is returned.

Note - the Kojo trace window only shows calls and returns to/from commands and functions that you define. It does not show the calls/returns of predefined (primitive) commands and functions. Be aware that these calls/returns (of primitives) happen under the covers.

When we talk about the [fundamentals of programming](/concepts/computing-essentials.html), we consider three different ways of looking at a program - [operation](/concepts/computing-essentials.html#program-operation), [structure](/concepts/computing-essentials.html#program-structure), and [development](/concepts/computing-essentials.html#program-development).

Let's look at control flow from these three different perspectives.
* Operation or running of a program - control flow **is** the running of the program.
* Program structure - control flow is specified in the structure of the program.
* Program development - you put various control flow mechanisms into your program as you develop it, in terms of the composition of commands and functions.