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

    String Manual(){
        String str = "Command Manual:\n" +
                "\n" +
                "load (get the RE or NFA from user)\n" +
                "\t-r (the input is RE)\n" +
                "\t-n (the input is NFA)\n" +
                "\t-i FILE(the input is redirected to the FILE)\n" +
                "\t\n" +
                "the load command should be in the following form:\n" +
                "\tload (-r | -n) (-i FILE)?\n" +
                "\t\n" +
                "example :\n" +
                "\tload -r\n" +
                "\tload -n -i test.txt\n" +
                "\t\n" +
                "convert (convert to NFA or DFA)\n" +
                "\tNFA (convert to NFA)\n" +
                "\tDFA\t(convert to DFA)\n" +
                "\ttransition table (output the transition table from NFA to DFA)\n" +
                "\t-o FILE(the output is redirected to the FILE)\n" +
                "\t\n" +
                "the convert command should be in the following form:\n" +
                "\tconvert (NFA | DFA | transition table) (-o FILE)?\n" +
                "\t\n" +
                "example :\n" +
                "\tconvert NFA\n" +
                "\tconvert DFA\n" +
                "\tconvert transition table -o result.txt\n" +
                "\t\n" +
                "quit , stop , q , exit , bye , terminate (exit the program)\n";
        return str;
    }

    public String visitExpr(controlParser.ExprContext ctx){
        if (ctx.QUIT() != null) return "quit";
        String cmd = ctx.cmd.getText();
        if (cmd.equals("help")){
            System.out.println(Manual());
        } else if (cmd.equals("load")) {
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
                try {
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
                } catch (Exception e){
                    System.err.println("The regular expression is illegal.");
                    e.printStackTrace();
                }

            } else {
                try {
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
                } catch (Exception e){
                    System.err.println("The nfa expression is illegal");
                    e.printStackTrace();
                }

            }
        } else if (cmd.equals("convert")){
            String file2 = "";
            if (ctx.File() != null) file2 = ctx.File().getText();
            PrintStream output = null;
            if (!file2.equals("")) try {
                output = new PrintStream(new FileOutputStream(new File(file2)));
            } catch (FileNotFoundException e){
                System.err.println("The file cannot be created.\n");
            }
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
