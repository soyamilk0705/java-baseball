package study.exception;

import study.exception.enumclass.ErrorCode;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
