package study;

import java.util.*;

public class BaseballScanner {
    private final Scanner scanner;

    public BaseballScanner(){
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> execute() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input;

        try{
            input = checkLength(scanner.next());
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException(ErrorCode.INVALID_INPUT.getMessage());
        }

        return convertList(input);
    }

    public String checkLength(String input){
        input = input.replace(" ", "");

        if (input.length() != 3){
            throw new NoSuchElementException(ErrorCode.INVALID_INPUT.getMessage());
        }
        return input;
    }

    public List<Integer> convertList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] inputArr = input.split("");

        for (String str: inputArr){
            int number = parseStringToInt(str);
            numbers.add(number);
        }

        return numbers;
    }

    public int parseStringToInt(String str){
        int result;

        try{
            result = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            throw new NumberFormatException(ErrorCode.INVALID_INPUT_NUMBER.getMessage());
        }

        return result;
    }

    public boolean isReplay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input;

        try{
            input = scanner.nextInt();
        } catch (NoSuchElementException ex){
            throw new NoSuchElementException(ErrorCode.INVALID_INPUT_REPLAY.getMessage());
        }

        if (input == 2){
            return false;
        } else if(input != 1){
            throw new NoSuchElementException(ErrorCode.INVALID_INPUT_REPLAY.getMessage());
        }

        return true;

    }

    public void close(){
        scanner.close();
    }
}
