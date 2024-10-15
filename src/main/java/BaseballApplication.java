import study.Baseball;
import study.BaseballScanner;

public class BaseballApplication {
    public static void main(String[] args){
        Baseball baseball = new Baseball();
        boolean isReplay = true;

        while(isReplay){
            String result = baseball.play();
            System.out.println(result);

            BaseballScanner scanner = new BaseballScanner();
            isReplay = scanner.isReplay();
        }

        System.out.println("게임이 종료되었습니다.");


    }
}
