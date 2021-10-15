class Solution {
    HashMap<Integer, Integer> memory = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int ways = 0;
        
        if (!memory.containsKey(n-2)) {
            memory.put(n-2, climbStairs(n - 2));
        } 
        if (!memory.containsKey(n-1)) {
            memory.put(n-1, climbStairs(n - 1));
        }
        
        ways = memory.get(n-1) + memory.get(n-2);
        
        return ways;
    }
}
