grammar RE;
expression :
       EPS
     | CCHAR
     | expression op = '*'
     | expression expression
     | expression op = '|' expression
     | op = '(' expression')';

EPS : 'eps';
CCHAR : [a-zA-Z];
WS : [ \n\t\r]+ -> skip;