// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\FA.g4 by ANTLR 4.5.1
package ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, EPS=7, CCHAR=8, NAME=9, 
		WS=10;
	public static final int
		RULE_context = 0, RULE_assemly = 1, RULE_expr = 2;
	public static final String[] ruleNames = {
		"context", "assemly", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'start'", "':'", "'accept'", "'->'", "'['", "']'", "'eps'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "EPS", "CCHAR", "NAME", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ContextContext extends ParserRuleContext {
		public AssemlyContext assemly() {
			return getRuleContext(AssemlyContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ContextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FAVisitor ) return ((FAVisitor<? extends T>)visitor).visitContext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextContext context() throws RecognitionException {
		ContextContext _localctx = new ContextContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_context);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(6);
				expr();
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
			assemly();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemlyContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(FAParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(FAParser.NAME, i);
		}
		public AssemlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemly; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FAVisitor ) return ((FAVisitor<? extends T>)visitor).visitAssemly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemlyContext assemly() throws RecognitionException {
		AssemlyContext _localctx = new AssemlyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assemly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(T__0);
			setState(15);
			match(T__1);
			setState(16);
			match(NAME);
			setState(17);
			match(T__2);
			setState(18);
			match(T__1);
			setState(19);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(FAParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(FAParser.NAME, i);
		}
		public TerminalNode EPS() { return getToken(FAParser.EPS, 0); }
		public TerminalNode CCHAR() { return getToken(FAParser.CCHAR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FAVisitor ) return ((FAVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(NAME);
			setState(22);
			match(T__3);
			setState(23);
			match(NAME);
			setState(24);
			match(T__4);
			setState(25);
			_la = _input.LA(1);
			if ( !(_la==EPS || _la==CCHAR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(26);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f\37\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\2\2\5\2\4\6\2\3\3\2\t\n\34\2"+
		"\13\3\2\2\2\4\20\3\2\2\2\6\27\3\2\2\2\b\n\5\6\4\2\t\b\3\2\2\2\n\r\3\2"+
		"\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2\2\2\16\17\5\4\3\2"+
		"\17\3\3\2\2\2\20\21\7\3\2\2\21\22\7\4\2\2\22\23\7\13\2\2\23\24\7\5\2\2"+
		"\24\25\7\4\2\2\25\26\7\13\2\2\26\5\3\2\2\2\27\30\7\13\2\2\30\31\7\6\2"+
		"\2\31\32\7\13\2\2\32\33\7\7\2\2\33\34\t\2\2\2\34\35\7\b\2\2\35\7\3\2\2"+
		"\2\3\13";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}