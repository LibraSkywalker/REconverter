grammar FA;

context : (expr)* assemly;

assemly : 'start' ':' NAME 'accept' ':' NAME ;

expr : NAME '->' NAME '[' (EPS | CCHAR) ']';

EPS : 'eps';
CCHAR : [a-zA-Z];
NAME : [0-9a-zA-Z]+ ;
WS : [ \n\t\r,;]+ -> skip;