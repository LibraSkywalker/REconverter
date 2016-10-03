package Kernel;

import ANTLR.controlLexer;
import ANTLR.controlParser;
import Kernel.FA.NFA;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bill on 2016/10/4.
 */
public class Tool {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        ControlPanel control = new ControlPanel();
        do{
            controlLexer lexer = new controlLexer(new ANTLRInputStream(scanner.nextLine()));
            CommonTokenStream tokens = new CommonTokenStream(lexer) ;
            controlParser parser = new controlParser(tokens) ;
            controlParser.ExprContext ctx = parser.expr();
            try {
                cmd = control.visitExpr(ctx);
            } catch (IOException e){
                e.printStackTrace();
            }
        } while (!cmd.equals("quit"));
    }
}
