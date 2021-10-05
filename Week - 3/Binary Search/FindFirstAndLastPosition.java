class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
                end = mid;
                while (start > 0 && nums[start-1] == target) {
                    start--;
                }
                
                while (end < nums.length - 1 && nums[end+1] == target) {
                    end++;
                }
                
                range[0] = start;
                range[1] = end;
                return range;
            }
        }
        return range;
    }
}
