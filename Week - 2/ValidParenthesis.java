class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean valid = true;
        char c;
        for (int i = 0; i < s.length() && valid; i++) {
            c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (!stack.isEmpty()) {
                switch (c) {
                    case ')':
                        valid = stack.pop() == '(';
                        break;
                    case ']':
                        valid = stack.pop() == '[';
                        break;
                    case '}':
                        valid = stack.pop() == '{';
                }
            } else {
                valid = false;
            }
        }
        return stack.isEmpty() && valid;
    }
}
