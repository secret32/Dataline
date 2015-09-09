package org.sec.dataline.exception;

/**
 * @author zhou_wei
 * @since v0.1
 */
public enum ErrorCode {

    ERROR_FILE(1001, "error file"),
    INVALID_FILE(1002, "invalid class file"),

    ERROR_MAGIC(2001, "invalid magic number"),
    ;

    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public DatalineException toException() {
        return new DatalineException(code, message);
    }

}
