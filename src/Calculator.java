import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Operation obj = new Operation();
        Scanner num = new Scanner(System.in);
        Integer a = num.nextInt();
        char mathOperation = num.next().charAt(0);
        Integer b = num.nextInt();

        obj.calk(a, mathOperation, b);

    }
}
