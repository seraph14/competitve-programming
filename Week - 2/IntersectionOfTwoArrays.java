class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> dict = new HashMap<>();
        for (int ele : nums1) {
            if (!dict.containsKey(ele)) {
                dict.put(ele, false);
            }
        }
        int count = 0;
        for (int ele : nums2) {
            if (dict.containsKey(ele) && !dict.get(ele)) {
                dict.put(ele, true);
                count++;
            }
        }
        
        int[] arr = new int[count];
        int i = 0;
        for (int key : dict.keySet()) {
            if (dict.get(key)) {
                arr[i] = (key);
                i++;
            }   
        }
        
        return arr;
    }
}
