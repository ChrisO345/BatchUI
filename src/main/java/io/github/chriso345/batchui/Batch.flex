package io.github.chriso345.batchui.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.psi.BatchTypes;
import com.intellij.lexer.FlexLexer;

%%

%class BatchLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WhiteSpace = [ \t]
LineTerminator = \r|\n|\r\n
FullLine = [^\r\n]
StringLiteral = \" ( \\\" | [^\"\n\r] )* \"
Exp = [^ \t\f\n\r\:\;\,\|\&\<\>]+
CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
EscapeCharacter = "^".

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"

%state ANNOTATION, EXPR, LABEL, REM

%%

<YYINITIAL> {
    {WhiteSpace}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    "@" { yybegin(ANNOTATION); return BatchTypes.ANNOTATION; }
    // {Exp}
    // {Escaping}
    // {StringLiteral}
    {CommentIndicator} { yybegin(REM); yypushback(yylength()); }
    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
}

<ANNOTATION> {
    {WhiteSpace}* { yybegin(ANNOTATION); return TokenType.WHITE_SPACE; }
    {RemIndicator} { yybegin(REM); return BatchTypes.COMMENT; }
    {Exp}+ { yybegin(EXPR); return BatchTypes.ANNOTATION; }
}

<EXPR> {
    {WhiteSpace}* { yybegin(EXPR); return TokenType.WHITE_SPACE; }
    {Toggle}? { yybegin(YYINITIAL); return BatchTypes.TOGGLE; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
}

<LABEL> {
    {WhiteSpace}* { yybegin(LABEL); return TokenType.WHITE_SPACE; }
    {FullLine}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
}

<REM> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {FullLine}* { yybegin(REM); return BatchTypes.COMMENT; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }