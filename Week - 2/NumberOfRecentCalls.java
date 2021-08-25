class RecentCounter {
    int num;
    Queue<Integer> queue;
    int min;
    public RecentCounter() {
        num = 0;
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        int low, high, current;
        if (queue.size() == 0) {
            queue.add(t);
            num++;
        } else {
            low = t - 3000;
            high = t;
            current = queue.peek();
            while (queue.size() > 0 && low > current) {
                queue.remove();
                num--;
                if (queue.size() > 0) {
                    current = queue.peek();    
                }
            } 
            num++;
            queue.add(t);
        }
        return num;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
