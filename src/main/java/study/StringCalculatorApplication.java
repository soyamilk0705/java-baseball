package study;

import java.util.Scanner;

public class StringCalculatorApplication {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("수식을 입력해주세요: ");
        String value = scanner.nextLine();

        StringCalculator calculator = new StringCalculator(value);
        System.out.println("계산 결과 : " + calculator.getTotal());
    }
}
