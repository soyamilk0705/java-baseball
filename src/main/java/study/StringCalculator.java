package study;
import study.exception.DivisionZeroException;
import study.exception.InvalidFormatException;
import study.exception.enumclass.ErrorCode;
import study.exception.InvalidInputException;

import java.util.Scanner;


public class StringCalculator {
    private int total;

    public StringCalculator(String value){
        String[] values = value.split(" ");

        try{
            total = Integer.parseInt(values[0]);

            for (int i=1; i<values.length; i+=2){
                String nowValue = values[i];
                int nextValue = Integer.parseInt(values[i+1]);

                calculator(nowValue, nextValue);
            }
        } catch (NumberFormatException e){
            throw new InvalidInputException(ErrorCode.INVALID_INPUT);
        } catch (ArithmeticException e) {
            throw new DivisionZeroException(ErrorCode.DIVISION_ZERO);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new InvalidFormatException(ErrorCode.INVALID_FORMAT);
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


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
