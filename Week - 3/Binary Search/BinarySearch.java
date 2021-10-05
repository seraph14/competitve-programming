class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        int mid = (l + r) / 2;
        while (l < r && nums[mid] != target) {
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } 
            mid = (l + r) / 2;
        }
        
        return (r - l > 0) ? mid : -1;
    }
}
