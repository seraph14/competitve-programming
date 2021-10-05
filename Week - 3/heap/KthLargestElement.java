class KthLargest {
    PriorityQueue<Integer> pQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pQueue = new PriorityQueue<>(k);
        for (int num : nums)
            this.pQueue.add(num);
        this.k = k;
    }
    
    public int add(int val) {
        this.pQueue.offer(val);
        while (pQueue.size() > k) {
            this.pQueue.poll();
        }
        
        return pQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
