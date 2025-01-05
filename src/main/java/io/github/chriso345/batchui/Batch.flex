package io.github.chriso345.batchui.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.psi.BatchTypes;
import com.intellij.lexer.FlexLexer;

%%

%class BatchLexer
%implements FlexLexer
%ignorecase
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WhiteSpace = [ \t]+
LineTerminator = \r|\n|\r\n
FullLine = [^\r\n]
StringLiteral = \" ( \\\" | [^\"\n\r] )* \"
ArgLiteral = \%\~[0-9~]
Token = [^ \t\f\n\r\:\;\,\|\&\<\>\=]+
CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
EscapeCharacter = "^".

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"

%state ANNOTATION, COMMAND, ECHO, ECHO_STRING, GOTO, LABEL, REM, SET, SET_LOCAL, SET_VALUE

%%

<YYINITIAL> {
    {WhiteSpace} { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    "@"{CommentIndicator} { yybegin(REM); yypushback(yylength() - 1); return BatchTypes.REM_ANNOTATION; }
    "@"{Token}+ { yybegin(ANNOTATION); yypushback(yylength() - 1); return BatchTypes.ANNOTATION; }
    // {Escaping}
    {StringLiteral} { yybegin(YYINITIAL); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(YYINITIAL); return BatchTypes.NUMERIC; }
    {CommentIndicator} { yybegin(REM); yypushback(yylength()); }
    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
    {CommandTerminator} { yybegin(YYINITIAL); return BatchTypes.CMD_TERMINATOR; }
    {Token}+ { yybegin(COMMAND); yypushback(yylength()); }
    "=" { yybegin(YYINITIAL); return BatchTypes.SEPARATOR; }
}

<ANNOTATION> {
    {WhiteSpace} { yybegin(ANNOTATION); return TokenType.WHITE_SPACE; }

    echo { yybegin(ECHO); return BatchTypes.ANNOTATION; }

    {Token}+ { yybegin(YYINITIAL); return BatchTypes.ANNOTATION; }
}

<COMMAND> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(COMMAND); return TokenType.WHITE_SPACE; }
    {StringLiteral} { yybegin(COMMAND); return BatchTypes.STRING; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    echo { yybegin(ECHO); return BatchTypes.COMMAND; }
    goto { yybegin(GOTO); return BatchTypes.COMMAND; }
    setlocal { yybegin(SET_LOCAL); return BatchTypes.COMMAND; }
    set {yybegin(SET); return BatchTypes.COMMAND; }
}

<ECHO> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    {Toggle}[\ \t]*[\r\n]+ { yybegin(YYINITIAL); return BatchTypes.TOGGLE; }

    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }
    {Token}+ { yybegin(ECHO_STRING); return BatchTypes.COMMAND; }
}

<ECHO_STRING> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO_STRING); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }

    {Token}+ { yybegin(ECHO_STRING); return BatchTypes.COMMAND; }
}

<GOTO> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(GOTO); return TokenType.WHITE_SPACE; }

    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
}

<LABEL> {
    {WhiteSpace} { yybegin(LABEL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
}

<REM> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {FullLine}+ { yybegin(REM); return BatchTypes.COMMENT; }
}

<SET> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET); return TokenType.WHITE_SPACE; }
    {Token}+[\ \t]*= { yybegin(SET); yypushback(1); return BatchTypes.CONSTANT; }
    = { yybegin(SET_VALUE); return BatchTypes.SEPARATOR; }
}

<SET_LOCAL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET_LOCAL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(SET_LOCAL); return BatchTypes.SET_LOCAL_COMMAND; }
}

<SET_VALUE> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET_VALUE); return TokenType.WHITE_SPACE; }
    {StringLiteral} { yybegin(SET_VALUE); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(SET_VALUE); return BatchTypes.NUMERIC; }
    {Token}+ { yybegin(SET_VALUE); return BatchTypes.STRING; }
    = { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

{Token}+ { return TokenType.BAD_CHARACTER; }