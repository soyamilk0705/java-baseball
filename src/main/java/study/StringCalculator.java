package study;
import java.util.Scanner;


public class StringCalculator {
    private String[] values;
    private int total;

    public StringCalculator(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        values = value.split(" ");

        total = Integer.parseInt(values[0]);

        for (int i=1; i<values.length; i+=2){
            String nowValue = values[i];
            int nextValue = Integer.parseInt(values[i+1]);

            calculator(nowValue, nextValue);
            System.out.println(total);
        }
    }

    public void calculator(String nowValue, int nextValue){
        switch (nowValue){
            case "+":
                total += nextValue;
                break;
            case "-":
                total -= nextValue;
                break;
            case "*":
                total *= nextValue;
                break;
            case "/":
                total /= nextValue;
                break;
        }
    }


    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
