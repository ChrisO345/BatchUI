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
Token = [^ \t\f\n\r\:\;\,\|\&\<\>]+
CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
EscapeCharacter = "^".

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"

%state ANNOTATION, COMMAND, ECHO, ECHO_STRING, GOTO, LABEL, REM

%%

<YYINITIAL> {
    {WhiteSpace} { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    "@"{RemIndicator} { yybegin(REM); yypushback(yylength() - 1); return BatchTypes.REM_ANNOTATION; }
    "@"{Token}+ { yybegin(ANNOTATION); yypushback(yylength() - 1); return BatchTypes.ANNOTATION; }
    // {Escaping}
    {StringLiteral} { yybegin(YYINITIAL); return BatchTypes.STRING; }
    {CommentIndicator} { yybegin(REM); yypushback(yylength()); }
    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
    {CommandTerminator} { yybegin(YYINITIAL); return BatchTypes.CMD_TERMINATOR; }
    {Token}+ { yybegin(COMMAND); yypushback(yylength()); }
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

    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
}

<LABEL> {
    {WhiteSpace} { yybegin(LABEL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
}

<REM> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {FullLine}+ { yybegin(REM); return BatchTypes.COMMENT; }
}

{Token}+ { return TokenType.BAD_CHARACTER; }