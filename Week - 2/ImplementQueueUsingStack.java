class MyQueue {
    Stack<Integer> primary;
    Stack<Integer> temp;
    /** Initialize your data structure here. */
    public MyQueue() {
        primary = new Stack<>();
        temp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        primary.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = -1;
        while (!primary.isEmpty()) {
            res = primary.pop();
            if (!primary.isEmpty()) {
                temp.push(res);   
            }
        }
        while (!temp.isEmpty()) {
            primary.push(temp.pop());
        }
        return res;
        
    }
    
    /** Get the front element. */
    public int peek() {
        int res = -1;
        while (!primary.isEmpty()) {
            res = primary.pop();
            temp.push(res);   
        }
        while (!temp.isEmpty()) {
            primary.push(temp.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return primary.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
