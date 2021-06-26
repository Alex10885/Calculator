package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorExec {

    public static void main(String[] args) {


        try {
            System.out.println("Калькулятор для выражений вида: \"Число1 Операция Число2\", через пробел. Допускаются числа от 1 до 10 или от I до X включительно. Операции: + - * /");
            while (true) {
                System.out.print("Введите выражение: ");
                BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
                String calcString = bReader.readLine();
                if (!calcString.equals("exit")) {
                    Calculations calc = new Calculations();
                    String result = calc.result(calcString);
                    System.out.println("Ответ: " + result);
                } else {
                    System.exit(0);
                }
            }
        } catch (CalcException | IOException e) {

        }
    }


}
