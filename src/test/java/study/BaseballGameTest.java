package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseballGameTest {

    @Test
    @DisplayName("playGame(): 3 스트라이크")
    void playGame3Strike(){
        // given
        List<Integer> userInput = Arrays.asList(1, 2, 3);

        BaseballScanner scanner = mock(BaseballScanner.class);
        Baseball baseball = mock(Baseball.class);
        BaseballGame game = new BaseballGame(scanner, baseball);

        when(scanner.askNumbers()).thenReturn(userInput);
        when(baseball.play(userInput)).thenReturn(new BaseballScore(3, 0, 0));


        // when
        String response = game.playGame();

        // then
        assertEquals(response, "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    @Test
    @DisplayName("isReplayScanner(): 재게임 여부 1 입력으로 true 반환")
    void isReplayInput1(){
        // given
        BaseballScanner scanner = mock(BaseballScanner.class);
        Baseball baseball = mock(Baseball.class);
        BaseballGame game = new BaseballGame(scanner, baseball);

        when(scanner.askReplay()).thenReturn(1);

        // when
        boolean response = game.isReplay();

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("isReplayScanner(): 재게임 여부 2 입력으로 false 반환")
    void isReplayInput2(){
        // given
        BaseballScanner scanner = mock(BaseballScanner.class);
        Baseball baseball = mock(Baseball.class);
        BaseballGame game = new BaseballGame(scanner, baseball);

        when(scanner.askReplay()).thenReturn(2);

        // when
        boolean response = game.isReplay();

        // then
        assertFalse(response);
    }



}
