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
Numeric = [0-9]+

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"

%state ANNOTATION, CALL, COMMAND, ECHO, ECHO_STRING, EXIT, GOTO, LABEL, REM, SET, SET_LOCAL, SHIFT, SET_VALUE

%%

<YYINITIAL> {
    {WhiteSpace} { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    "@"{CommentIndicator} { yybegin(REM); yypushback(yylength() - 1); return BatchTypes.REM_DECORATOR; }
    "@"{Token}+ { yybegin(ANNOTATION); yypushback(yylength() - 1); return BatchTypes.DECORATOR; }
    // {Escaping}
    {StringLiteral} { yybegin(YYINITIAL); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(YYINITIAL); return BatchTypes.NUMERIC; }
    {CommentIndicator} { yybegin(REM); yypushback(yylength()); }
    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
    {CommandTerminator} { yybegin(YYINITIAL); return BatchTypes.COMMAND_TERMINATOR; }
    {Token}+ { yybegin(COMMAND); yypushback(yylength()); }
    "=" { yybegin(YYINITIAL); return BatchTypes.ASSIGNMENT; }
}

<ANNOTATION> {
    {WhiteSpace} { yybegin(ANNOTATION); return TokenType.WHITE_SPACE; }

    echo { yybegin(ECHO); return BatchTypes.ECHO_ANNOTATION; }

    {Token}+ { yybegin(YYINITIAL); return BatchTypes.DECORATOR; }
}

<CALL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(GOTO); return TokenType.WHITE_SPACE; }

    ":" { yybegin(LABEL); return BatchTypes.LABEL_MARKER; }
    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
}

<COMMAND> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(COMMAND); return TokenType.WHITE_SPACE; }
    {StringLiteral} { yybegin(COMMAND); return BatchTypes.STRING; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    echo { yybegin(ECHO); return BatchTypes.ECHO_COMMAND; }
    goto { yybegin(GOTO); return BatchTypes.GOTO_COMMAND; }
    call { yybegin(CALL); return BatchTypes.CALL_COMMAND; }
    setlocal { yybegin(SET_LOCAL); return BatchTypes.SETLOCAL_COMMAND; }
    set {yybegin(SET); return BatchTypes.SET_COMMAND; }
    shift {yybegin(SHIFT); return BatchTypes.SHIFT_COMMAND; }
    endlocal { yybegin(YYINITIAL); return BatchTypes.ENDLOCAL_COMMAND; }
    exit { yybegin(EXIT); return BatchTypes.EXIT_COMMAND; }
}

<ECHO> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    {Toggle}[\ \t]*[\r\n]+ { yybegin(YYINITIAL); return BatchTypes.TOGGLE; }

    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }
    {Token}+ { yybegin(ECHO_STRING); return BatchTypes.PLAINTEXT; }
}

<ECHO_STRING> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO_STRING); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }

    {Token}+ { yybegin(ECHO_STRING); return BatchTypes.PLAINTEXT; }
}

<EXIT> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(EXIT); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    \/b { yybegin(EXIT); return BatchTypes.EXTENSION; }
    {Numeric} { yybegin(YYINITIAL); return BatchTypes.NUMERIC; }
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
    {Token}+[\ \t]*= { yybegin(SET); yypushback(1); return BatchTypes.VARIABLE; }
    = { yybegin(SET_VALUE); return BatchTypes.ASSIGNMENT; }
}

<SET_LOCAL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET_LOCAL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(SET_LOCAL); return BatchTypes.SETLOCAL_PARAMETER; }
}

<SET_VALUE> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET_VALUE); return TokenType.WHITE_SPACE; }
    {StringLiteral} { yybegin(SET_VALUE); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(SET_VALUE); return BatchTypes.NUMERIC; }
    {Token}+ { yybegin(SET_VALUE); return BatchTypes.STRING; }
    = { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<SHIFT> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SHIFT); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    \/[0-8] { yybegin(YYINITIAL); return BatchTypes.EXTENSION; }
}

{Token}+ { return TokenType.BAD_CHARACTER; }