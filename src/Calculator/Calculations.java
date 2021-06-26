package Calculator;

import java.util.Arrays;
import java.util.List;

public class Calculations {
    private int num1, num2;     //числа в выражении
    private String operator;    //оператор в выражении, допускается: +-*/

    //---выполнение целочисленного арифметического выражения
    private int calcExp(int x, String operation, int y) {
        int res;
        switch (operation) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }

    //---public метод проверок и  вывод результата
    public String result(String exp) throws CalcException {
        boolean isRomanExp;     // ---Признак, что числа римские
        Parser parser = new Parser();

        //---разбиваем исходное выражение String по разделителю " "
        List<String> expItems = Arrays.asList(exp.split(" "));

        //---проверка, что создалось 3 элемента: число1, оператор, число2, иначе исключение
        if (expItems.size() != 3) {
            throw new CalcException("ОШИБКА. Выражение должно иметь вид: \"Число1 Операция Число2\", разделенные пробелом...");
        }

        //--- проверка оператора, должен быть: + - * /
        if (parser.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new CalcException("ОШИБКА. Оператор '" + expItems.get(1) + "' не корректен, должен быть: + - * / ");
        }

        //---проверка чисел, должны быть оба арабские или оба римские
        if (parser.isNumeric(expItems.get(0)) && parser.isNumeric(expItems.get(2))) {      //---проверяем, что оба числа арабские
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parser.isRoman(expItems.get(0)) && parser.isRoman(expItems.get(2))) {   //---проверяем, что оба числа римские
            num1 = parser.romeToArabConvert(expItems.get(0));
            num2 = parser.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {    //--- числа не соответствуют
            throw new CalcException("ОШИБКА. Числа должны быть оба арабские или оба римские");
        }

        //---проверка чисел, должны быть от 1 до 10 включительно
        if (!(num1 >= 1 && num1 <= 10)) {
            throw new CalcException("ОШИБКА. Число #1 должно быть от 1 до 10 или от I до X включительно");
        }

        if (!(num2 >= 1 && num2 <= 10)) {
            throw new CalcException("ОШИБКА. Число #2 должно быть от 1 до 10 или от I до X включительно");
        }

        //--- получаем результат
        int res = calcExp(num1, operator, num2);

        //--- если числа римские, то конвертируем в римские и возвращаем результат
        if (isRomanExp) {
            String sign = res < 0 ? "-" : "";
            return sign + parser.arabToRomeConvert(Math.abs(res));
        }

        //--- возвращаем в ответ - арабское число
        return String.valueOf(res);
    }

}

