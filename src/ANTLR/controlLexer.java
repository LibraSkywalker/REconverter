// Generated from E:/OneDrive/Ideaprojects/Regular Expression and Finite Automata/src\control.g4 by ANTLR 4.5.1
package ANTLR;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class controlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, QUIT=11, WS=12, File=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "QUIT", "WS", "File"
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


	public controlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "control.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\fr\n\f\3\r\6\ru\n\r\r\r\16\rv\3\r\3\r\3\16\6"+
		"\16|\n\16\r\16\16\16}\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\3\2\4\5\2\13\13\17\17\"\"\5\2\13\f\17\17\"\"\u0086"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\"\3\2\2\2\7\'\3\2\2\2\t*\3\2"+
		"\2\2\13-\3\2\2\2\r\60\3\2\2\2\178\3\2\2\2\21<\3\2\2\2\23@\3\2\2\2\25Q"+
		"\3\2\2\2\27q\3\2\2\2\31t\3\2\2\2\33{\3\2\2\2\35\36\7j\2\2\36\37\7g\2\2"+
		"\37 \7n\2\2 !\7r\2\2!\4\3\2\2\2\"#\7n\2\2#$\7q\2\2$%\7c\2\2%&\7f\2\2&"+
		"\6\3\2\2\2\'(\7/\2\2()\7t\2\2)\b\3\2\2\2*+\7/\2\2+,\7p\2\2,\n\3\2\2\2"+
		"-.\7/\2\2./\7k\2\2/\f\3\2\2\2\60\61\7e\2\2\61\62\7q\2\2\62\63\7p\2\2\63"+
		"\64\7x\2\2\64\65\7g\2\2\65\66\7t\2\2\66\67\7v\2\2\67\16\3\2\2\289\7P\2"+
		"\29:\7H\2\2:;\7C\2\2;\20\3\2\2\2<=\7F\2\2=>\7H\2\2>?\7C\2\2?\22\3\2\2"+
		"\2@A\7v\2\2AB\7t\2\2BC\7c\2\2CD\7p\2\2DE\7u\2\2EF\7k\2\2FG\7v\2\2GH\7"+
		"k\2\2HI\7q\2\2IJ\7p\2\2JK\7\"\2\2KL\7v\2\2LM\7c\2\2MN\7d\2\2NO\7n\2\2"+
		"OP\7g\2\2P\24\3\2\2\2QR\7/\2\2RS\7q\2\2S\26\3\2\2\2TU\7s\2\2UV\7w\2\2"+
		"VW\7k\2\2Wr\7v\2\2XY\7u\2\2YZ\7v\2\2Z[\7q\2\2[r\7r\2\2\\]\7d\2\2]^\7{"+
		"\2\2^r\7g\2\2_r\7s\2\2`a\7j\2\2ab\7c\2\2bc\7n\2\2cr\7v\2\2de\7v\2\2ef"+
		"\7g\2\2fg\7t\2\2gh\7o\2\2hi\7k\2\2ij\7p\2\2jk\7c\2\2kl\7v\2\2lr\7g\2\2"+
		"mn\7g\2\2no\7z\2\2op\7k\2\2pr\7v\2\2qT\3\2\2\2qX\3\2\2\2q\\\3\2\2\2q_"+
		"\3\2\2\2q`\3\2\2\2qd\3\2\2\2qm\3\2\2\2r\30\3\2\2\2su\t\2\2\2ts\3\2\2\2"+
		"uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\b\r\2\2y\32\3\2\2\2z|\n\3\2"+
		"\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\34\3\2\2\2\6\2qv}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}