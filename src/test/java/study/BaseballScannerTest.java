package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballScannerTest {

    @Test
    @DisplayName("execute(): 사용자 입력 성공")
    void execute(){
        // given
        String input = "456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        List<Integer> response = scanner.execute();

        // then
        assertEquals(response.get(0), 4);
        assertEquals(response.get(1), 5);
        assertEquals(response.get(2), 6);
    }

    @Test
    @DisplayName("execute(): 공백이 포함된 숫자 입력으로 예외 발생")
    void executeContainEmpty_exception(){
        // given
        String input = "4 6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::execute);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("execute(): 숫자 3자리 이상을 입력으로 예외 발생")
    void executeInputOverSizeThree_exception(){
        // given
        String input = "123456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::execute);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("execute(): 문자열 입력으로 예외 발생")
    void executeInputString_exception(){
        // given
        String input = "문자열";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, scanner::execute);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("execute(): 공백 입력으로 예외 발생")
    void executeInputEmpty_exception(){
        // given
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::execute);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("checkLength(): 숫자 3자리 검증 성공")
    void checkLength(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        String response = scanner.checkLength(input);

        // then
        assertEquals(response, input);
    }

    @Test
    @DisplayName("checkLength(): 숫자 3자리 이상을 입력으로 예외 발생")
    void checkLengthInputOverSizeThree_exception(){
        // given
        String input = "123456";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, () -> scanner.checkLength(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("parseStringToInt(): 문자열 숫자로 변환 성공")
    void parseStringToInt(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        int response = scanner.parseStringToInt(input);

        // then
        assertEquals(response, 123);
    }

    @Test
    @DisplayName("parseStringToInt(): 문자열 숫자 변환 실패로 예외 발생")
    void parseInputString_exception(){
        // given
        String input = "문자열";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> scanner.parseStringToInt(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("convertList(): 문자열을 숫자 리스트로 변환 성공")
    void convertList(){
        // given
        String input = "123";

        // when
        BaseballScanner scanner = new BaseballScanner();
        List<Integer> response = scanner.convertList(input);

        // then
        assertEquals(response.get(0), 1);
        assertEquals(response.get(1), 2);
        assertEquals(response.get(2), 3);
    }

    @Test
    @DisplayName("convertList(): 문자열 숫자 리스트 변환 실패로 예외 발생")
    void convertListInputString_exception(){
        // given
        String input = "문자열";

        // when
        BaseballScanner scanner = new BaseballScanner();
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> scanner.convertList(input));

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("isReplayScanner(): 재게임 여부 1 입력으로 true 반환")
    void isReplayInput1(){
        // given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        boolean response = scanner.isReplay();

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("isReplayScanner(): 재게임 여부 2 입력으로 false 반환")
    void isReplayInput2(){
        // given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        boolean response = scanner.isReplay();

        // then
        assertFalse(response);
    }

    @Test
    @DisplayName("isReplayScanner(): 문자열 입력으로 예외 발생")
    void isReplayInputString_exception(){
        // given
        String input = "문자열";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::isReplay);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_REPLAY.getMessage());
    }


    @Test
    @DisplayName("isReplayScanner(): 숫자 2자리 입력")
    void isReplayInputTwoNumber_exception(){
        String input = "34";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::isReplay);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_REPLAY.getMessage());
    }

    @Test
    @DisplayName("execute(): 공백 입력으로 예외 발생")
    void isReplayInputEmpty_exception(){
        // given
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        BaseballScanner scanner = new BaseballScanner();
        NoSuchElementException fail = assertThrows(NoSuchElementException.class, scanner::isReplay);

        // then
        assertEquals(fail.getMessage(), ErrorCode.INVALID_INPUT_REPLAY.getMessage());
    }

}
