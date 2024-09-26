package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.exception.DivisionZeroException;
import study.exception.InvalidFormatException;
import study.exception.enumclass.ErrorCode;
import study.exception.InvalidInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "2 - 3 / 4 + 7, 7", "10 + 3 * 86 - 20, 1098"})
    @DisplayName("올바른 문자열 입력을 통해 올바른 계산 결과가 나온 경우")
    void stringCalculator_success(String input, int expected){
        StringCalculator calculator = new StringCalculator(input);
        assertEquals(calculator.getTotal(), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"d + 3 * 4 / 2", "2 - ( / 4 + 7", "10 + 3 * 86 - #", "6 + number * 5 / 20"})
    @DisplayName("입력한 문자가 숫자가 아닌 경우 InvalidInputException 발생")
    void inputNotNumberAtFirst_invalidInputException(String input){
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new StringCalculator(input));

        assertEquals(exception.getMessage(), ErrorCode.INVALID_INPUT.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"3 / 0", "3 + 2 / 0", "4 * 2 / 0 + 7"})
    @DisplayName("0으로 나눌 경우 DivisionZeroException 발생")
    void divisionZero_divisionZeroException(String input){
        DivisionZeroException exception = assertThrows(DivisionZeroException.class,
                () -> new StringCalculator(input));

        assertEquals(exception.getMessage(), ErrorCode.DIVISION_ZERO.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"3 / ", "65 + 2 *", "2 - 3 +     "})
    @DisplayName("완벽하지 않은 수식을 입력할 경우 InvalidFormatException 발생")
    void notPerfectFormat_InvalidFormatException(String input){
        InvalidFormatException exception = assertThrows(InvalidFormatException.class,
                () -> new StringCalculator(input));

        assertEquals(exception.getMessage(), ErrorCode.INVALID_FORMAT.getMessage());
    }
}
