# REconverter

>Superiors construct the rule, while inferiors just obey it.

## How to use:

+ install JRE, don't forget to write the CLASSPATH.

+ Find the JavaArchiveFile (.jar) in the *test* folder.

+ write your regular expression into *text.txt* in the folder.

+ Double Click the *test.bat* and the result will exist in *result.txt*

## What is supported:

+ convert RE to NFA, the result is shown in Dot Language, You can use [graphviz](http://www.graphviz.org/) to compile it.

+ continue coverting NFA to DFA, both the transition table and the DFA will be shown in the text. (The transion table is shown in Latex table form and the DFA is in dot language)

## TODO:

+ minimizing the DFA

+ parsing NFA