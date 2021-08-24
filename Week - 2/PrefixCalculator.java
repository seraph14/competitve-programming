import java.util.Stack;

public class PrefixCalculator {
    public static void main(String[] args) {
        String exp = "+ 9 * 12 6";
        System.out.println(calculatePrefix(exp));
    }

    public static int calculatePrefix(String expression) {
        Stack<String> stack = new Stack<>();
        String[] prefix = expression.split(" ");
        int x, y;
        for (int i = 0; i < prefix.length; i++) {
            if (stack.isEmpty()) {
                stack.push(prefix[i]);
            } else if (!isOperator(prefix[i]) && !isOperator(stack.peek())) {
                y = Integer.parseInt(prefix[i]);
                x = Integer.parseInt(stack.pop());
                stack.push(evaluate(x, y, stack.pop()));
            } else {
                stack.push(prefix[i]);
            }
        }

        if (!stack.isEmpty()) {
            y = Integer.parseInt(stack.pop());
            x = Integer.parseInt(stack.pop());
            stack.push(evaluate(x, y, stack.pop()));
        }
        return Integer.parseInt(stack.pop());
    }

    public static String evaluate(int x, int y, String op) {
        int res;
        char c = op.charAt(0);
        switch (c) {
            case '+':
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
            case '/':
                res = x / y;
                break;
            case '*':
                res = x * y;
                break;
            default:
                res = 0;
        }
        return res + "";
    }

    public static boolean isOperator(String op) {
        boolean res;
        op = op.trim();
        char c = op.charAt(0);
        switch (c) {
            case '+':
            case '-':
            case '/':
            case '*':
                res = true;
                break;
            default:
                res = false;
        }
        return res;
    }
}
