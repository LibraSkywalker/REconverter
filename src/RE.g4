grammar RE;
expression :
       EPS
     | CCHAR
     | expression op = '*'
     | expression expression
     | expression op = '|' expression
     | op = '(' expression')';

CCHAR : [a-zA-Z];
EPS : 'eps';
WS : [ \n\t\r]+ -> skip;