package Calculator;

import java.util.Scanner;


public class CalculatorExec {
    public static void main(String[] args) {

        System.out.println("Программа позволяет вычислять целые числа типа 'Число1 действие(+, -, *, /) Число2' Диапазон от 1 до 10 и от I до X" );
        System.out.println("Введите выражение: ");
        Operation obj = new Operation();
        Scanner num = new Scanner(System.in);
        Integer a = num.nextInt();
        char mathOperation = num.next().charAt(0);
        Integer b = num.nextInt();

        obj.calk(a, mathOperation, b);

    }
}
