class MyStack {
    Queue<Integer> primary;
    Queue<Integer> temp;
    /** Initialize your data structure here. */
    public MyStack() {
        primary = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        primary.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = -1;
        while (primary.size() != 0) {
            res = primary.remove();
            if (primary.size() != 0) {
                temp.add(res);
            }
        }
        
        while (temp.size() != 0) {
            primary.add(temp.remove());
        }
        
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        int res = -1;
        while (primary.size() != 0) {
            res = primary.remove();
            temp.add(res);
        }
        
        while (temp.size() != 0) {
            primary.add(temp.remove());
        }
        
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return primary.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
