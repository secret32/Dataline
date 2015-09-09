package org.sec.dataline.exception;

/**
 * @author zhou_wei
 * @since v0.1
 */
class DatalineException extends RuntimeException {

    private int code;
    private String message;

    public DatalineException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ". Code=" + code + ", Message=" + message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
