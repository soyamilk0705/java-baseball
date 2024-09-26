package study.exception;

import study.exception.enumclass.ErrorCode;

public class DivisionZeroException extends RuntimeException{
    public DivisionZeroException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
