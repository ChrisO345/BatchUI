package io.github.chriso345.batchui.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.github.chriso345.batchui.psi.BatchTypes;
import com.intellij.lexer.FlexLexer;
import java.util.Stack;

%%

%class BatchLexer
%implements FlexLexer
%ignorecase
%unicode
%function advance
%type IElementType
%{
  private Stack<Integer> tokenOrigin = new Stack<>();
%}
%eof{  return;
%eof}

WhiteSpace = [ \t]+
LineTerminator = \r|\n|\r\n
FullLine = [^\r\n]

// TODO: improve the way a string literal is determined
StringLiteral = (\" ( \\\" | [^\"\n\r] )* \") | \' ( \\\' | [^\'\n\r] )* \'
ArgLiteral = \%\~?[0-9]

// TODO: tweak the token regex to allow for more characters to be used in plaintext
Token = [^ \t\f\n\r\:\;\,\|\&\<\>\=\(\)\+]+

CommandTerminator = "|""|"? | "&""&"? | "<""<"? | ">"">"?
SpecialCharacter = [\|\&\<\>\(\)]
EscapeCharacter = "^".
Numeric = [0-9]+

RemIndicator = [Rr][Ee][Mm]
CommentIndicator = ("::" | {RemIndicator})
Toggle = "on" | "off"
ComparisonOperator = "EQU" | "NEQ" | "LSS" | "LEQ" | "GTR" | "GEQ" | "NOT"
Operator = [\+\-\*\/]

%state ANNOTATION, ASSOC, ASSOC_VALUE, BREAK, CALL, COMMAND, ECHO, ECHO_STRING, EXIT, FOR, FOR_COLLECTION, GOTO, IF, IF_ERRORLEVEL, IF_EXIST, IF_STANDARD, LABEL, MORE, REM, SET, SET_LOCAL, SHIFT, SET_VALUE, TOKEN
%state BAD_WHITESPACE
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
    \([\s\S]+\) { yybegin(YYINITIAL); yypushback(yylength() - 1); return BatchTypes.OPEN_PAREN; }
    \) { yybegin(YYINITIAL); return BatchTypes.CLOSE_PAREN; }
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

<BREAK> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(BREAK); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    {Toggle} { yybegin(BREAK); return BatchTypes.TOGGLE; }
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
    break { yybegin(BREAK); return BatchTypes.BREAK_COMMAND; }
    echo { yybegin(ECHO); return BatchTypes.ECHO_COMMAND; }
    goto { yybegin(GOTO); return BatchTypes.GOTO_COMMAND; }
    for { yybegin(FOR); return BatchTypes.FOR_COMMAND; }
    call { yybegin(CALL); return BatchTypes.CALL_COMMAND; }
    if { yybegin(IF); return BatchTypes.IF_COMMAND; }
    more { yybegin(MORE); return BatchTypes.MORE_COMMAND; }
    setlocal { yybegin(SET_LOCAL); return BatchTypes.SETLOCAL_COMMAND; }
    set {yybegin(SET); return BatchTypes.SET_COMMAND; }
    shift {yybegin(SHIFT); return BatchTypes.SHIFT_COMMAND; }
    else { yybegin(YYINITIAL); return BatchTypes.ELSE_COMMAND; }
    endlocal { yybegin(YYINITIAL); return BatchTypes.ENDLOCAL_COMMAND; }
    exit { yybegin(EXIT); return BatchTypes.EXIT_COMMAND; }

    {Token}+ { yybegin(YYINITIAL); return BatchTypes.PLAINTEXT; }
}

<ECHO> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    {Toggle}[\ \t]*[\r\n]+ { yybegin(YYINITIAL); return BatchTypes.TOGGLE; }
    {Toggle}[\ \t]*{SpecialCharacter} { yybegin(YYINITIAL); yypushback(1); return BatchTypes.TOGGLE; }

    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }
    {Token}+ { tokenOrigin.push(ECHO_STRING); yypushback(yylength()); yybegin(TOKEN); }
}

<ECHO_STRING> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(ECHO_STRING); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral} { yybegin(ECHO_STRING); return BatchTypes.STRING; }

    {Token}+ { tokenOrigin.push(ECHO_STRING); yypushback(yylength()); yybegin(TOKEN); }
}

<EXIT> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(EXIT); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    \/b { yybegin(EXIT); return BatchTypes.EXTENSION; }
    {Numeric} { yybegin(YYINITIAL); return BatchTypes.NUMERIC; }
}

<FOR> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(FOR); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }

    \/[drlf] { yybegin(FOR); return BatchTypes.EXTENSION; }

    \%\%[a-zA-Z] { yybegin(FOR); return BatchTypes.FOR_VARIABLE; }
    in { yybegin(FOR); return BatchTypes.IN_COMMAND; }
    do { yybegin(YYINITIAL); return BatchTypes.DO_COMMAND; }

    \([\s\S]*\) { yybegin(FOR_COLLECTION); yypushback(yylength() - 1); return BatchTypes.OPEN_PAREN; }

    eol=\w { yybegin(FOR); return BatchTypes.PLAINTEXT; }
    skip=\d+ { yybegin(FOR); return BatchTypes.PLAINTEXT; }
    delims=[\w{Operator}\=]? { yybegin(FOR); return BatchTypes.PLAINTEXT; }
    tokens=\d(\-\d)?(\,\d(\-\d)?)*\*? { yybegin(FOR); return BatchTypes.PLAINTEXT; }
    usebackq { yybegin(FOR); return BatchTypes.PLAINTEXT; }

    {StringLiteral} { yybegin(FOR); return BatchTypes.STRING; }

    {Token}+ { yybegin(FOR); return TokenType.BAD_CHARACTER; }
}

<FOR_COLLECTION> {
    {LineTerminator}+ { yybegin(FOR_COLLECTION); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(FOR_COLLECTION); return TokenType.WHITE_SPACE; }

    \) { yybegin(FOR); return BatchTypes.CLOSE_PAREN; }

    {StringLiteral} { yybegin(FOR_COLLECTION); return BatchTypes.STRING; }

    {Token}+ { yybegin(FOR); yypushback(yylength()); return BatchTypes.PLAINTEXT; }
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

    {ComparisonOperator} { yybegin(IF); return BatchTypes.COMPARISON_OPERATOR; }

    ERRORLEVEL { yybegin(IF_ERRORLEVEL); return BatchTypes.ERRORLEVEL_TOKEN; }
    EXIST | DEFINED { yybegin(IF_EXIST); return BatchTypes.EXIST_TOKEN; }

    {StringLiteral} { yybegin(IF_STANDARD); return BatchTypes.STRING; }
    {Token}+ { tokenOrigin.push(IF_STANDARD); yypushback(yylength()); yybegin(TOKEN); }
}

<IF_ERRORLEVEL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_ERRORLEVEL); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {Numeric} { yybegin(IF_ERRORLEVEL); return BatchTypes.NUMERIC; }
    \([\s\S]+\) { yybegin(YYINITIAL); yypushback(yylength() - 1); return BatchTypes.OPEN_PAREN; }
    {Token}+ { yybegin(YYINITIAL); yypushback(yylength()); }
}

<IF_EXIST> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_EXIST); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {StringLiteral} { yybegin(YYINITIAL); return BatchTypes.STRING; }
    \([\s\S]+\) { yybegin(YYINITIAL); yypushback(yylength() - 1); return BatchTypes.OPEN_PAREN; }

    // TODO: have a special isVariable function with stack to determine origin
    {Token}+ { tokenOrigin.push(YYINITIAL); yypushback(yylength()); yybegin(TOKEN); }
}

<IF_STANDARD> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(IF_STANDARD); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }

    {StringLiteral} { yybegin(IF_STANDARD); return BatchTypes.STRING; }
    {Numeric} { yybegin(IF_STANDARD); return BatchTypes.NUMERIC; }
    {ComparisonOperator} | == { yybegin(IF_STANDARD); return BatchTypes.COMPARISON_OPERATOR; }
    \([\s\S]+\) { yybegin(YYINITIAL); yypushback(yylength() - 1); return BatchTypes.OPEN_PAREN; }
    {Token}+ { tokenOrigin.push(YYINITIAL); yypushback(yylength()); yybegin(TOKEN); }
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

    \/[ap][\ \t]*[^\=\+\-\*] { yybegin(SET); yypushback(yylength() - 2); return BatchTypes.EXTENSION; }

    {Token}+\= { yybegin(SET); yypushback(1); return BatchTypes.VARIABLE; }
    {Token}+[\ \t] { tokenOrigin.push(SET); yypushback(1); yybegin(BAD_WHITESPACE); return BatchTypes.VARIABLE; }

    {Token}+{Operator}\= { yybegin(SET); yypushback(2); return BatchTypes.VARIABLE; }

    {Operator}?\=[\ \t] { tokenOrigin.push(SET_VALUE); yypushback(1); yybegin(BAD_WHITESPACE); return BatchTypes.ASSIGNMENT; }
    {Operator}?\= { yybegin(SET_VALUE); return BatchTypes.ASSIGNMENT; }
}

<SET_LOCAL> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {WhiteSpace} { yybegin(SET_LOCAL); return TokenType.WHITE_SPACE; }
    {Token}+ { yybegin(SET_LOCAL); return BatchTypes.SETLOCAL_PARAMETER; }
}

<SET_VALUE> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SET_VALUE); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    {StringLiteral} { yybegin(SET_VALUE); return BatchTypes.STRING; }
    {ArgLiteral} { yybegin(SET_VALUE); return BatchTypes.NUMERIC; }
    {Numeric} { yybegin(SET_VALUE); return BatchTypes.NUMERIC; }
    {Token}+ { tokenOrigin.push(SET_VALUE); yybegin(TOKEN); yypushback(yylength()); }
    \= { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
}

<SHIFT> {
    {LineTerminator}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {WhiteSpace} { yybegin(SHIFT); return TokenType.WHITE_SPACE; }
    {CommandTerminator} { yybegin(YYINITIAL); yypushback(yylength()); }
    \/[0-8] { yybegin(YYINITIAL); return BatchTypes.EXTENSION; }
}

<TOKEN> {
    {LineTerminator}+ { yybegin(tokenOrigin.pop()); yypushback(yylength()); }
    {WhiteSpace} { yybegin(tokenOrigin.pop()); yypushback(yylength()); }
    {CommandTerminator} { yybegin(tokenOrigin.pop()); yypushback(yylength()); }
    \%[\w]+\% {yybegin(tokenOrigin.pop()); return BatchTypes.VARIABLE; }
    \![\w]+\! { yybegin(tokenOrigin.pop()); return BatchTypes.VARIABLE; }
    {Token}+ { yybegin(tokenOrigin.pop()); return BatchTypes.PLAINTEXT; }
}

<BAD_WHITESPACE> {
    [\ \t]+ { yybegin(tokenOrigin.pop()); return TokenType.BAD_CHARACTER; }
}

{Token}+ { return TokenType.BAD_CHARACTER; }
. { return TokenType.BAD_CHARACTER; }