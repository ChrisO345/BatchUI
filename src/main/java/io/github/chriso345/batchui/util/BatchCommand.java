package io.github.chriso345.batchui.util;

public enum BatchCommand {
    ASSOC("assoc"),
    ATTRIB("attrib"),
    BREAK("break"),
    BCDEDIT("bcdedit"),
    CACLS("cacls"),
    CALL("call"),
    CD("cd"),
    CHCP("chcp"),
    CHDIR("chdir"),
    CHKDSK("chkdsk"),
    CHKNTFS("chkntfs"),
    CLS("cls"),
    CMD("cmd"),
    COLOR("color"),
    COMP("comp"),
    COMPACT("compact"),
    CONVERT("convert"),
    COPY("copy"),
    DATE("date"),
    DEL("del"),
    DIR("dir"),
    DISKPART("diskpart"),
    DOSKEY("doskey"),
    DRIVERQUERY("driverquery"),
    ECHO("echo"),
    ENDLOCAL("endlocal"),
    ERASE("erase"),
    EXIT("exit"),
    FC("fc"),
    FIND("find"),
    FINDSTR("findstr"),
    FOR("for"),
    FORMAT("format"),
    FSUTIL("fsutil"),
    FTYPE("ftype"),
    GOTO("goto"),
    GPRESULT("gpresult"),
    GRAFTABL("graftabl"),
    HELP("help"),
    ICACLS("icacls"),
    IF("if"),
    LABEL("label"),
    MD("md"),
    MKDIR("mkdir"),
    MKLINK("mklink"),
    MODE("mode"),
    MORE("more"),
    MOVE("move"),
    OPENFILES("openfiles"),
    PATH("path"),
    PAUSE("pause"),
    POPD("popd"),
    PRINT("print"),
    PROMPT("prompt"),
    PUSHD("pushd"),
    RD("rd"),
    RECOVER("recover"),
    REM("rem"),
    REN("ren"),
    RENAME("rename"),
    REPLACE("replace"),
    RMDIR("rmdir"),
    ROBOCOPY("robocopy"),
    SET("set"),
    SETLOCAL("setlocal"),
    SC("sc"),
    SCHTASKS("schtasks"),
    SHIFT("shift"),
    SHUTDOWN("shutdown"),
    SORT("sort"),
    START("start"),
    SUBST("subst"),
    SYSTEMINFO("systeminfo"),
    TASKLIST("tasklist"),
    TASKKILL("taskkill"),
    TIME("time"),
    TITLE("title"),
    TREE("tree"),
    TYPE("type"),
    VER("ver"),
    VERIFY("verify"),
    VOL("vol"),
    XCOPY("xcopy"),
    WMIC("wmic");

    private final String command;

    BatchCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public String getCommand(boolean uppercase) {
        return uppercase ? command.toUpperCase() : command;
    }
}

