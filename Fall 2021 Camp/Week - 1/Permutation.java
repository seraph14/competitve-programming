class Solution {
    List<List<Integer>> perm = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return perm;
        int[] temp = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp[i] = nums[i];
        }
        
        List<Integer> temp2 = new ArrayList<>();
        
        int currElem = nums[nums.length-1];
        if (perm.size() == 0) {
            temp2.add(currElem);
            perm.add(temp2);
        } else {
            List<List<Integer>> newPerm = new ArrayList<>();
            for (List<Integer> curr : perm) {
                for (int i = 0; i <= curr.size(); i++) {
                    temp2 = new ArrayList<>(curr);
                    temp2.add(i, currElem);
                    newPerm.add(temp2);
                }
            }
            
            perm = new ArrayList<>(newPerm);
        }
            
        permute(temp);
        
        return perm;
    }
}
