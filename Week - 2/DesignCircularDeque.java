class MyCircularDeque {
    int[] deque;
    int front;
    int rear;
    int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        size = 0;
        front = 0;
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        boolean success = false;
        int temp;
        if (this.isEmpty()) {
            deque[front] = value;
            rear = front;
            success = true;
        } else if (!this.isFull()) {
            if (front == 0) {
                temp = (front + deque.length - 1) % deque.length;    
            } else {
                temp = (front - 1) % deque.length;
            }
            
            if (size < deque.length && temp >= 0) {
                deque[temp] = value;
                front = temp;
                success = true;
            }
        }
        
        if (success)
            size++;
        return success;
        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        boolean success = false;
        int temp;
        if (this.isEmpty()) {
            front = 0;
            rear = 0;
            deque[front] = value;
            success = true;
        } else if (!this.isFull()) {
            temp = (rear + 1) % deque.length;
            if (size < deque.length) {
                deque[temp] = value;
                rear = temp;
                success = true;
            }
        }
        
        if (success)
            size++;
        return success;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        boolean success = false;
        if (!this.isEmpty()) {
            deque[front] = -2;
            if (size - 1 == deque.length) {
                rear = 0;
                front = 0;
            } else if (size - 1 == 1) {
                front = (front + 1) % deque.length;
                rear = front;
            } else {
                front = (front + 1) % deque.length;
            }
            success = true;
        }
        
        if (success)
            size--;
        return success;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        boolean success = false;
        int temp;
        if (!this.isEmpty()) {
            deque[rear] = -2;
            if (rear == 0) {
                temp = (rear - 1 + deque.length) % deque.length;
            } else {
                temp = (rear - 1) % deque.length;    
            }
            
            if (size - 1 == deque.length) {
                front = 0;
                rear = 0;
            } else if (size - 1 == 1) {
                rear = temp;
                front = rear;
            } else {
                rear = temp;
            }
            success = true;
        }
        
        if (success)
            size--;
        return success;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()) 
            return -1;
        return deque[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()) 
            return -1;
        return deque[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == deque.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
