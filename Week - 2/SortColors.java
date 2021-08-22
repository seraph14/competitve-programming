class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]] = colors[nums[i]] + 1;
        }
        int i = 0, j = 0;
        while (i < 3) {
            if (colors[i] != 0) {
                nums[j] = i;
                colors[i]--;
                j++;
                if (colors[i] == 0) {
                    i++;
                }    
            } else {
                i++;
            }
            
        }
    }
}
