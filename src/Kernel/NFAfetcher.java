package Kernel;

import ANTLR.FABaseVisitor;
import ANTLR.FAParser;
import Kernel.FA.NFA;
import Kernel.FA.Node;
import Kernel.FA.Edge;

import java.util.Hashtable;

/**
 * Created by Bill on 2016/10/3.
 */
public class NFAfetcher extends FABaseVisitor<NFA>{
    Hashtable<String,Node> nameList = new Hashtable<>();

    Node prepare(String now){
        if (nameList.containsKey(now)) return nameList.get(now);
        else {
            Node newNode = new Node(now);
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
       Node source = prepare(ctx.NAME(0).getText());
       Node sink = prepare(ctx.NAME(1).getText());
       new Edge(source,sink,(ctx.CCHAR() == null ? " ": ctx.CCHAR().getText()));
       return null;
   }

    public NFA visitAssemly(FAParser.AssemlyContext ctx) {
        Node start = prepare(ctx.NAME(0).getText());
        Node accept = prepare(ctx.NAME(1).getText());
        return new NFA(start,accept);
    }
}
