package study;

import java.util.List;

public class BaseballGame {
    private final BaseballScanner scanner;
    private final Baseball baseball;

    public BaseballGame(BaseballScanner scanner, Baseball baseball){
        this.scanner = scanner;
        this.baseball = baseball;
    }

    public String playGame(){
        boolean collect = false;

        while(!collect){
            List<Integer> userInput = scanner.askNumbers();
            BaseballScore score = baseball.play(userInput);

            System.out.println(score.printScore());
            collect = score.isThreeStrike();
        }

        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public boolean isReplay(){
        int input = scanner.askReplay();
        return input != 2;
    }

    public String endGame(){
        return "게임이 종료되었습니다.";
    }

}
