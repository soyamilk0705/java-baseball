package study.exception;


import study.exception.enumclass.ErrorCode;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
