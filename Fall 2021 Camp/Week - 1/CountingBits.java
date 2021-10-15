class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n >= 1)
            ans[1] = 1;  
       
        
        int pointer = 0;
        int power = 2;
        
        for (int i = 2; i < n+1; i++) {
            if (Math.pow(2, power) == i) {
                power++;
                pointer = 0;
            }
                
            ans[i] = ans[pointer++] + 1;
        }
        return ans;
    }
}
