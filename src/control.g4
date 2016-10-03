grammar control;

expr : cmd = 'quit'
     | cmd = 'load' op = ('-r' | '-n') ('-i' File)?
     | cmd = 'convert' op = ('NFA' | 'DFA' | 'transition table') ('-o' File)?;

WS : [ \t\r]+ -> skip;

File:~[ \t\r\n]+;