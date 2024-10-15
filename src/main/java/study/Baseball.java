package study;

import java.util.*;

public class Baseball {
    public String play(){
        List<Integer> answerList = getAnswer();
        boolean collect = false;

        BaseballScanner scanner = new BaseballScanner();
        System.out.println(answerList.toString());

        while(!collect){
            List<Integer> input = scanner.execute();
            collect = checkAnswer(input, answerList);
        }

        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }


    public boolean checkAnswer(List<Integer> inputList, List<Integer> answerList){
        BaseballScore score = new BaseballScore();

        for (int i=0; i<inputList.size(); i++){
            int index = answerList.indexOf(inputList.get(i));
            score.checkScore(index, i);
        }

        System.out.println(score.printScore());

        return score.isThreeStrike();
    }


    public List<Integer> getAnswer() {
        List<Integer> answers = new ArrayList<>();

        while(answers.size() < 3){
            int num = getRandomNumber();
            answers = addUniqueNumber(num, answers);
        }

        return answers;

    }

    public List<Integer> addUniqueNumber(int num, List<Integer> answers){
        if (answers.stream().anyMatch(n -> n == num)){
            return answers;
        }

        answers.add(num);
        return answers;
    }

    public int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(9)+1;
    }
}
