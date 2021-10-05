class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b)-> b-a);
        for (int stone : stones) {
            pQueue.add(stone);
        }
        
        int a = 0, b = 0;
        while (pQueue.size() > 1) {
            a = pQueue.poll();
            b = pQueue.poll();
            if (a != b) {
                pQueue.add(a - b);
            } 
        }
        return (pQueue.isEmpty()) ? 0 : pQueue.poll();
    }
}
