package Calculator;

public class Operation {
    public void calk(int x, char operation, int y) {
        int result;
        switch (operation) {
            case '+':
                result = x + y;
                System.out.println(result);
                break;
            case '-':
                result = x - y;
                System.out.println(result);
                break;
            case '*':
                result = x * y;
                System.out.println(result);
                break;
            case '/':
                result = x / y;
                System.out.println(result);
                break;
        }


    }
}
