// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\RE.g4 by ANTLR 4.5.1
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link REParser}.
 */
public interface REListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link REParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(REParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link REParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(REParser.ExpressionContext ctx);
}