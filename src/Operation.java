public class Operation {
    public void calk(int x, char operation, int y) {
        int result;
        if (operation == '+') {
            result = x + y;
            System.out.println(result);
        } else if (operation == '-') {
            result = x - y;
            System.out.println(result);
        } else if (operation == '*') {
            result = x * y;
            System.out.println(result);
        } else if (operation == '/') {
            result = x / y;
            System.out.println(result);
        }


    }
}
