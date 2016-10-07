// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\control.g4 by ANTLR 4.5.1
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
public class controlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, QUIT=11, WS=12, File=13;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'help'", "'load'", "'-r'", "'-n'", "'-i'", "'convert'", "'NFA'", 
		"'DFA'", "'transition table'", "'-o'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "QUIT", 
		"WS", "File"
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
	public String getGrammarFileName() { return "control.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public controlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public Token cmd;
		public Token op;
		public TerminalNode QUIT() { return getToken(controlParser.QUIT, 0); }
		public TerminalNode File() { return getToken(controlParser.File, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof controlVisitor ) return ((controlVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			setState(16);
			switch (_input.LA(1)) {
			case QUIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2);
				match(QUIT);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(3);
				((ExprContext)_localctx).cmd = match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(4);
				((ExprContext)_localctx).cmd = match(T__1);
				setState(5);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(8);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(6);
					match(T__4);
					setState(7);
					match(File);
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(10);
				((ExprContext)_localctx).cmd = match(T__5);
				setState(11);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(14);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(12);
					match(T__9);
					setState(13);
					match(File);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\25\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2\13\n\2\3\2\3\2\3\2\3\2\5\2\21\n\2\5\2\23\n\2"+
		"\3\2\2\2\3\2\2\4\3\2\5\6\3\2\t\13\30\2\22\3\2\2\2\4\23\7\r\2\2\5\23\7"+
		"\3\2\2\6\7\7\4\2\2\7\n\t\2\2\2\b\t\7\7\2\2\t\13\7\17\2\2\n\b\3\2\2\2\n"+
		"\13\3\2\2\2\13\23\3\2\2\2\f\r\7\b\2\2\r\20\t\3\2\2\16\17\7\f\2\2\17\21"+
		"\7\17\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\4\3\2\2\2\22\5"+
		"\3\2\2\2\22\6\3\2\2\2\22\f\3\2\2\2\23\3\3\2\2\2\5\n\20\22";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}