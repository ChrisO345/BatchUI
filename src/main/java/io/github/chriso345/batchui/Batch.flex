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
StringLiteral = [^\=]\" ( \\\" | [^\"\n\r] )* \"
ArgLiteral = \%\~[0-9~]
AllowEqualsToken = [^ \t\f\n\r\:\;\,\|\&\<\>]+
Token = [^ \t\f\n\r\:\;\,\|\&\<\>\=]+
CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
EscapeCharacter = "^".
Numeric = [0-9]+

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"
ComparisonOperator = "EQU" | "NEQ" | "LSS" | "LEQ" | "GTR" | "GEQ" | "NOT"

%state ANNOTATION, ASSOC, ASSOC_VALUE, CALL, COMMAND, ECHO, ECHO_STRING, EXIT, GOTO, IF, IF_ERRORLEVEL, IF_EXIST, IF_STANDARD, LABEL, MORE, REM, SET, SET_LOCAL, SHIFT, SET_VALUE

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

<ASSOC> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ASSOC); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {Token}+ { yybegin(ASSOC); return BatchTypes.VARIABLE; }
    = { yybegin(ASSOC_VALUE); return BatchTypes.ASSIGNMENT; }
}

<ASSOC_VALUE> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ASSOC_VALUE); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral} { yybegin(ASSOC_VALUE); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(ASSOC_VALUE); return BatchTypes.NUMERIC; }
    {Token}+ { yybegin(ASSOC_VALUE); return BatchTypes.STRING; }
    = { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
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

    assoc { yybegin(ASSOC); return BatchTypes.ASSOC_COMMAND; }
    echo { yybegin(ECHO); return BatchTypes.ECHO_COMMAND; }
    goto { yybegin(GOTO); return BatchTypes.GOTO_COMMAND; }
    call { yybegin(CALL); return BatchTypes.CALL_COMMAND; }
    if { yybegin(IF); return BatchTypes.IF_COMMAND; }
    more { yybegin(MORE); return BatchTypes.MORE_COMMAND; }
    setlocal { yybegin(SET_LOCAL); return BatchTypes.SETLOCAL_COMMAND; }
    set {yybegin(SET); return BatchTypes.SET_COMMAND; }
    shift {yybegin(SHIFT); return BatchTypes.SHIFT_COMMAND; }
    endlocal { yybegin(YYINITIAL); return BatchTypes.ENDLOCAL_COMMAND; }
    exit { yybegin(EXIT); return BatchTypes.EXIT_COMMAND; }

    {Token}+ { yybegin(YYINITIAL); return BatchTypes.PLAINTEXT; }
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

<IF> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    {ComparisonOperator} { yybegin(IF); return BatchTypes.COMPARISON_OPERATOR; }

    ERRORLEVEL { yybegin(IF_ERRORLEVEL); return BatchTypes.ERRORLEVEL_TOKEN; }
    EXIST { yybegin(IF_EXIST); return BatchTypes.EXIST_TOKEN; }

    {Token}+ { yybegin(IF_STANDARD); return BatchTypes.STRING; }
}

<IF_ERRORLEVEL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_ERRORLEVEL); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {Numeric} { yybegin(YYINITIAL); return BatchTypes.NUMERIC; }
    {Token}+ { yybegin(COMMAND); yypushback(yylength()); }
}

<IF_EXIST> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_EXIST); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {StringLiteral} { yybegin(YYINITIAL); return BatchTypes.STRING; }
    {Token}+ { yybegin(COMMAND); yypushback(yylength()); }
}

<IF_STANDARD> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_STANDARD); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {StringLiteral} { yybegin(IF_STANDARD); return BatchTypes.STRING; }
    {ComparisonOperator} | == { yybegin(IF_STANDARD); return BatchTypes.COMPARISON_OPERATOR; }
    {AllowEqualsToken}+ { yybegin(COMMAND); return BatchTypes.PLAINTEXT; }
}

<LABEL> {
    {WhiteSpace} { yybegin(LABEL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(YYINITIAL); return BatchTypes.FUNC_LABEL; }
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
}

<MORE> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(MORE); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    \/t{Numeric} { yybegin(MORE); return BatchTypes.EXTENSION; }
    \+{Numeric} { yybegin(MORE); return BatchTypes.EXTENSION; }
    \/[cps] { yybegin(MORE); return BatchTypes.EXTENSION; }
    [a-zA-Z]+:{Token}* { yybegin(MORE); return BatchTypes.DISK_DRIVE; }
    {Token}+ { yybegin(MORE); return BatchTypes.PLAINTEXT; }
}

<REM> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {FullLine}+ { yybegin(REM); return BatchTypes.COMMENT; }
}

<SET> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET); return TokenType.WHITE_SPACE; }
    {Token}+[\ \t]*\= { yybegin(SET); yypushback(1); return BatchTypes.VARIABLE; }
    \= { yybegin(SET_VALUE); return BatchTypes.ASSIGNMENT; }
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
    \= { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<SHIFT> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SHIFT); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    \/[0-8] { yybegin(YYINITIAL); return BatchTypes.EXTENSION; }
}

{Token}+ { return TokenType.BAD_CHARACTER; }
. { return TokenType.BAD_CHARACTER; }