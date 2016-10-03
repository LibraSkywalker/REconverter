package Kernel;

import ANTLR.FABaseVisitor;
import ANTLR.FAParser;
import Kernel.FA.NFA;
import Kernel.FA.edge;
import Kernel.FA.node;

import java.util.Hashtable;

/**
 * Created by Bill on 2016/10/3.
 */
public class NFAfetcher extends FABaseVisitor<NFA>{
    Hashtable<String,node> nameList = new Hashtable<>();

    node prepare(String now){
        if (nameList.containsKey(now)) return nameList.get(now);
        else {
            node newNode = new node(now);
            nameList.put(now,newNode);
            return newNode;
        }
    }

    public NFA visitContext(FAParser.ContextContext ctx) {
        NFA now = visitAssemly(ctx.assemly());

        for (FAParser.ExprContext context : ctx.expr()){
            visitExpr(context);
        }
        return now;
    }

   public NFA visitExpr(FAParser.ExprContext ctx) {
       node source = prepare(ctx.NAME(0).getText());
       node sink = prepare(ctx.NAME(1).getText());
       new edge(source,sink,(ctx.CCHAR() == null ? " ": ctx.CCHAR().getText()));
       return null;
   }

    public NFA visitAssemly(FAParser.AssemlyContext ctx) {
        node start = prepare(ctx.NAME(0).getText());
        node accept = prepare(ctx.NAME(1).getText());
        return new NFA(start,accept);
    }
}
