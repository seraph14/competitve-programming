class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> operands = new Stack<>();
        int evaluation, x, y;
        
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                x = Integer.parseInt(operands.pop());
                y = Integer.parseInt(operands.pop());
                evaluation = eval(y, x, tokens[i]);
                operands.push("" + evaluation);
            } else {
                operands.push(tokens[i]);
            }
        } return Integer.parseInt(operands.pop());
        
    }
    
    public boolean isOperator(String x) {
        switch (x) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                return false;
        }
    }
    
    public int eval(int x, int y, String op) {
        int evaluation;
        switch(op) {
            case "+":
                evaluation = x + y;
                break;
            case "-":
                evaluation = x - y;
                break;
            case "/":
                evaluation = x / y;
                break;
            case "*":
                evaluation = x * y;
                break;
            default:
                evaluation = -99;
        } return evaluation;
    }
}
