package study;

public enum ErrorCode {

    INVALID_INPUT(1, "3자리 숫자를 입력해주세요."),
    INVALID_INPUT_NUMBER(2, "숫자만 입력 가능합니다."),
    INVALID_INPUT_REPLAY(3, "1 또는 2 숫자만 입력 가능합니다.");


    private final int id;
    private final String message;

    ErrorCode(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
