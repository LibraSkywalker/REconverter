// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\FA.g4 by ANTLR 4.5.1
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FAParser#context}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext(FAParser.ContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FAParser#assemly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemly(FAParser.AssemlyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FAParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FAParser.ExprContext ctx);
}