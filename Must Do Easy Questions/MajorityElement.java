class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majority;
        if (nums[nums.length / 2] == nums[nums.length - 1]) {
            majority = nums[nums.length - 1];
        } else {
            majority = nums[(nums.length / 2) - 1];
        }
        return majority;
    }
}
