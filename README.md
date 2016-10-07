# REconverter

>Superiors construct the rule, while inferiors just obey it.

## How to use:

+ install JRE, don't forget to write the CLASSPATH.

+ Find the JavaArchiveFile (.jar) in the *test* folder.

+ Double Click the *test.bat* to start the command line interface.

+ If you are not familiar with the command, just type "help" in the interface.

## What is supported:

+ parsing RE

+ parsing NFA

+ convert RE to NFA, the result is shown in Dot Language, You can use [graphviz](http://www.graphviz.org/) to compile it.

+ covert NFA to DFA, both the transition table and the DFA are available. (The transition table is in the form of Latex table form and the DFA is in dot language)

## TODO:

+ minimizing the DFA

NFA specification:
a->b[c] (connect node a and b with edge c)
start:a (a is the starting state)
accept:b (b is the accepting state)

There can be any amount of edges, but there's only one starting state and one accepting state is allowed,for all NFA can be constructed to the form of one start and one accept by adding epsilon moves.

and the word "eps" is reserved for epsilon move, don't choose it as a normal name.
