grammar control;

expr : QUIT
     | cmd = 'help'
     | cmd = 'load' op = ('-r' | '-n') ('-i' File)?
     | cmd = 'convert' op = ('NFA' | 'DFA' | 'transition table') ('-o' File)?;

QUIT : 'quit' | 'stop' | 'bye' | 'q' | 'halt' | 'terminate' | 'exit';

WS : [ \t\r]+ -> skip;

File:~[ \t\r\n]+;