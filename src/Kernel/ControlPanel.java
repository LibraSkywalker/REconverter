package Kernel;

import java.io.*;
import java.util.Scanner;

import ANTLR.*;
import Kernel.FA.DFA;
import Kernel.FA.NFA;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


/**
 * Created by Bill on 2016/10/2.
 */
public class ControlPanel {
    public NFA nfa = null;
    public String visitExpr(controlParser.ExprContext ctx) throws IOException{
        String cmd = ctx.cmd.getText();
        if (cmd.equals("load")) {
            boolean isRE = true;
            if (ctx.op.getText().equals("-n")) isRE = false;
            String file = "";
            String data = "";

            if (ctx.File() != null) file = ctx.File().getText();

            if (isRE) {
                if (file.equals("")) {
                    Scanner scanner = new Scanner(System.in);
                    data = scanner.nextLine();
                }
                RELexer lexer;
                if (data.equals(""))
                    lexer = new RELexer(new ANTLRInputStream(new FileInputStream(file)));
                else
                    lexer = new RELexer(new ANTLRInputStream(data));
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                REParser parser = new REParser(tokens);
                REParser.ExpressionContext ctx2 = parser.expression();

                Evaluator RE2NFA = new Evaluator();
                nfa = RE2NFA.visitExpression(ctx2);
                nfa.tag();
            } else {
                FALexer lexer;
                if (file.equals(""))
                    lexer = new FALexer(new ANTLRInputStream(System.in));
                else
                    lexer = new FALexer(new ANTLRInputStream(new FileInputStream(file)));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                FAParser parser = new FAParser(tokens);
                FAParser.ContextContext ctx2 = parser.context();

                NFAfetcher nfAfetcher = new NFAfetcher();
                nfa = nfAfetcher.visitContext(ctx2);
            }
        } else if (cmd.equals("convert")){
            String file2 = "";
            if (ctx.File() != null) file2 = ctx.File().getText();
            PrintStream output = null;
            if (!file2.equals(""))
            output = new PrintStream(new FileOutputStream(new File(file2)));
            String parameter = ctx.op.getText();
            if (parameter.equals("NFA")) {
                if (output == null)
                    System.out.println(nfa);
                else
                    output.println(nfa);
            } else if (parameter.equals("DFA"))   {
                DFA dfa = new DFA(nfa);
                if (output == null)
                    System.out.println(dfa);
                else
                    output.println(dfa);
            } else {
                DFA dfa2 = new DFA(nfa);
                if (output == null)
                    System.out.println(dfa2.list());
                else
                    output.println(dfa2.list());
            }
        }
        return cmd;
    }
}
