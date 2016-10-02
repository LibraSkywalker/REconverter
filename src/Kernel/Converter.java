package Kernel;

import ANTLR.RELexer;
import ANTLR.REParser;
import FA.DFA;
import FA.NFA;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by Bill on 2016/10/2.
 */
public class Converter {
    public static void main(String[] args) throws IOException {
        RELexer lexer = new RELexer(new ANTLRInputStream(System.in)) ;

        CommonTokenStream tokens = new CommonTokenStream(lexer) ;

        REParser parser = new REParser(tokens) ;
        REParser.ExpressionContext ctx = parser.expression();

        Evaluator RE2NFA = new Evaluator();
        NFA now =  RE2NFA.visitExpression(ctx);

        System.out.println(now);
        System.out.println("\n\n\n\n");

        DFA transform = new DFA(now);
        transform.convert();

        System.out.println(transform.list());
        System.out.println("\n\n\n\n");
        System.out.println(transform);

    }
}
