// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\control.g4 by ANTLR 4.5.1
package ANTLR;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link controlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class controlBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements controlVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpr(controlParser.ExprContext ctx) { return visitChildren(ctx); }
}