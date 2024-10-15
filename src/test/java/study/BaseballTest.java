package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BaseballTest {

    @Test
    @DisplayName("3스트라이크")
    void play3Strike(){
        // given
        Baseball baseball = Mockito.spy(new Baseball());

        List<Integer> answerList = Arrays.asList(1, 2, 3);
        when(baseball.getAnswer()).thenReturn(answerList);

        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String response = baseball.play();

        // then
        assertEquals(response, "3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }


    @Test
    @DisplayName("checkAnswer(): 3 스트라이크")
    void checkAnswer_3Strike(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(3, 5, 6);

        // when
        Baseball baseball = new Baseball();
        boolean response = baseball.checkAnswer(inputList, answerList);

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("checkAnswer(): 3 스트라이크 아닌 경우")
    void checkAnswerNot3Strike(){
        // given
        List<Integer> inputList = Arrays.asList(3, 5, 6);
        List<Integer> answerList = Arrays.asList(3, 8, 1);

        // when
        Baseball baseball = new Baseball();
        boolean response = baseball.checkAnswer(inputList, answerList);

        // then
        assertFalse(response);
    }


    @Test
    @DisplayName("getAnswer() 성공: 랜덤 3자리 수 생성")
    void getAnswer(){
        // given
        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.getAnswer();

        // then
        assertEquals(response.size(), 3);
        assertNotNull(response.get(0));
        assertNotNull(response.get(1));
        assertNotNull(response.get(2));
        assertNotEquals(response.get(0), response.get(1));
        assertNotEquals(response.get(0), response.get(2));
        assertNotEquals(response.get(1), response.get(2));
    }

    @Test
    @DisplayName("addUniqueNumber(): 리스트에 중복된 숫자 존재하지 않을 경우 리스트에 추가")
    void addUniqueNumber(){
        // given
        int num = 3;
        List<Integer> answers = new ArrayList<>();
        answers.add(4);
        answers.add(1);

        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.addUniqueNumber(num, answers);

        // then
        assertEquals(response.size(), 3);
        assertEquals(response.get(0), answers.get(0));
        assertEquals(response.get(1), answers.get(1));
        assertEquals(response.get(2), num);
    }

    @Test
    @DisplayName("addUniqueNumber(): 리스트에 중복 숫자 존재하는 경우 리스트에 추가 안됨")
    void addDuplicatedNumber(){
        // given
        int num = 1;
        List<Integer> answers = new ArrayList<>();
        answers.add(4);
        answers.add(1);

        // when
        Baseball baseball = new Baseball();
        List<Integer> response = baseball.addUniqueNumber(num, answers);

        // then
        assertEquals(response.size(), answers.size());
        assertEquals(response.get(0), answers.get(0));
        assertEquals(response.get(1), answers.get(1));
    }


    @RepeatedTest(10) // 10번 반복 테스트
    @DisplayName("getRandomNumber() 성공: 1부터 9까지 랜덤 수 생성 성공")
    void getRandomNumber(){
        // given
        // when
        Baseball baseball = new Baseball();
        int response = baseball.getRandomNumber();

        // then
        System.out.println("response : " + response);
        assertTrue(response > 0 && response <= 9);
    }
}
