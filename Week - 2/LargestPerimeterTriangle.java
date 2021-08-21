class Solution {
    public int largestPerimeter(int[] nums) {
        int p = 0, a, b, c;
        Arrays.sort(nums);
        int length = nums.length - 3;
        for (int i = length; i >= 0; i--) {
            a = nums[i]; b = nums[i+1]; c = nums[i+2];
            if (a + b > c && a + c > b && b + c > a && p < a + b + c) {
                p = a + b + c;
            }
        }   
        return p;
    }
}
