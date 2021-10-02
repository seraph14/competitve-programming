class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length, i = 0;
        while (i < nums.length) {
            if (i < k && nums[i] == val) {
                swap(i, k - 1, nums);
                k--;
            } else {
                i++;    
            }
            
        }
        return k;
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
