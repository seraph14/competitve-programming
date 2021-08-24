class MinStack {
    ArrayList<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            min = val;
        } else {
            if (val < min) {
                min = val;
            }
        }
        stack.add(val);
    }
    
    public void pop() {
        if (this.top() == min) {
            min = stack.get(0);
            for (int i = 1; i < stack.size() - 1; i++) {
                if (stack.get(i) < min) {
                    min = stack.get(i);
                }
            }
        }
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
