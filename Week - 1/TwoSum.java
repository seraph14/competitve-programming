class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, temp;
        int result[] = new int[2];
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            temp = target-nums[i];
            
            if (numbers.containsKey(temp)) {
                result[0] = i;
                result[1] = numbers.get(temp);
            } else {
                numbers.put(nums[i], i);
            } 
        } return result;
    }
}
