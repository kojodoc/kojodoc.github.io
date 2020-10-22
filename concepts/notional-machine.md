<div class="nav">
  <a href="../index.html">Home</a> | <a href="../fundamentals-index.html">Fundamentals</a>
</div>

## A notional machine for Kojo

A [notional machine](http://teachtogether.tech/en/index.html#s:models-notional):

* Is an idealized abstraction of computer hardware and other aspects of a program's runtime environment.
* Allows a conceptually accurate description of what a program does when executed.

The goal of a notional machine is to help you to understand, create, and debug computer programs.

Here is a notional machine for Kojo:

1. Running programs live in memory, which is divided between a code area, a heap, and a call stack.
2. The code for a program is loaded into the code area.
3. The data for a program is created and lives in the heap.
4. Variables, named values, command/function inputs/parameters (which are like named values), and command/function outputs/return-values live on the call stack.
5. Every piece of data is an object. The object contains the value of the data, information on the type of the data, and a reference to the code that works with this type of data. The code is a bunch of commands and functions, which are called the methods of the object. A piece of data is also informally called a value.
6. A val is constant reference to a value. You can think of it as a name for a value.
7. A var is a reference to a value. You can think of it as a binding of a name to a value. This binding can be changed to a different value in your program.
8. Some types of data are never modified after they are created, e.g., Boolean, Int, Double, String, Seq, List, etc. These are called immutable data types.
9. Other types of data can be modified after they are created, e.g., ArrayBuffer, HashMap, HashSet, etc. These are called mutable data types.
10.  Immutable data types are built using vals. Mutable data types are built using vars.
11.  When code is loaded into memory, Kojo converts it to a sequence of instructions that are stored in the code area. 
12. Code can be treated as data by putting it in an object. This is why it’s possible to assign commands/functions to vals/vars and pass them as inputs/parameters to other commands/functions.
13. When code is executed, Kojo steps through the instructions in the code, doing what each one tells it to do in turn.
14. Some instructions make Kojo read data (queries), do calculations and create new data (functions), and carry out actions (commands). Other instructions control what instructions Kojo executes (these are mostly keyword instructions), which is how looping and selection works. 
15. The calling of any command or function happens via a call/return.
16. When a command or function is called, Kojo creates a new stack frame and adds it to the call stack. The inputs/parameters to the command/function are supplied via this stack frame.
 * When a method is called on an object via the dot notation, the object is considered to be a input/parameter to the method.
17. Each stack frame stores the val/var names created inside the command/function, and references to the data corresponding to the names. Command/Function inputs/parameters are just vals in the stack frame.
18. When a val/var is used, Kojo looks for it in the current stack frame. If it isn’t there, Kojo looks for it in the top-level (global) frame.
19. When a command or function finishes, Kojo erases its stack frame from the call stack, jumps back (returns) to the instructions it was executing before the command/function call, and carrries on with the next instruction after the call.
 * A function returns a value (which is the result of its computation/calculation) to the next instruction. It's the responsibility of the next instruction to use this value appropriately (otherwise the value will remain unused in the program).
 * A command returns the unit value `()` to the next instruction. The unit value `()` specifies *no information*.   
If there isn’t a next instruction, the program finishes.
