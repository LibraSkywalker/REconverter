package Kernel;

import ANTLR.REBaseVisitor;
import ANTLR.REParser;
import Kernel.FA.NFA;

/**
 * Created by Bill on 2016/10/2.
 */
public class Evaluator extends REBaseVisitor<NFA> {
    public NFA visitExpression(REParser.ExpressionContext ctx){
        if (ctx.CCHAR() != null) return new NFA(ctx.CCHAR().getText());
        if (ctx.EPS() != null) return new NFA(" ");
        if (ctx.op == null) {
            NFA subgraph1 = visitExpression(ctx.expression(0));
            NFA subgraph2 = visitExpression(ctx.expression(1));
            return new NFA(subgraph1,subgraph2,'&');
        } else {
            String op = ctx.op.getText();
            if (op.equals("(")) return visitExpression(ctx.expression(0));
            else if (op.equals("*")) {
                NFA subgraph = visitExpression(ctx.expression(0));
                return new NFA(subgraph);
            } else {
                NFA subgraph1 = visitExpression(ctx.expression(0));
                NFA subgraph2 = visitExpression(ctx.expression(1));
                return new NFA(subgraph1, subgraph2, '|');
            }
        }
    }
}
