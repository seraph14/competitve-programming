class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int divisor = 1, mid, start = 1, end = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > end) {
                end = num;
            }
        }
        int sum;
        while (start <= end) {
            mid = (start) + ((end - start) / 2);
            sum = 0;
            for (int num : nums) {
                sum += Math.ceil(((double) num) / mid);
            }
            
            if (sum <= threshold) {
                divisor = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return divisor;
    }
}
