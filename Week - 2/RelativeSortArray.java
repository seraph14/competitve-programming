class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int elem : arr1) {
            if (dict.containsKey(elem)) {
                dict.put(elem, dict.get(elem) + 1);
            } else {
                dict.put(elem, 1);
            }
        }
        
        int[] result = new int[arr1.length];
        int i = 0;
        for (int elem : arr2) {
            while (dict.get(elem) > 0) {
                result[i] = elem;
                dict.put(elem, dict.get(elem) - 1);
                i++;
            } 
            dict.remove(elem);
        }
        
        int k = i;
        if (dict.size() > 0) {
            ArrayList<Integer> left = new ArrayList<>();
            for (Integer key: dict.keySet()) {
                while (dict.get(key) > 0) {
                    left.add(key);
                    dict.put(key, dict.get(key) - 1);
                }
            }

            Collections.sort(left);

            for (int elem : left) {
                result[k] = elem;
                k++;
            }
        }
        return result;
    }
}
