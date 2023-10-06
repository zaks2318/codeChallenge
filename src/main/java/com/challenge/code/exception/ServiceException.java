package com.challenge.code.exception;

public class ServiceException extends Exception {

    private int status;
    private int code;
    private String message;

    public ServiceException(int status, int code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message);
        this.message = message;
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
