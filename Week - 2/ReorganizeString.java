class Solution {
    public String reorganizeString(String s) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (dict.containsKey((int) c)) {
                dict.put((int) c, dict.get((int) c) + 1);
            } else {
                dict.put((int) c, 1);
            }
        }
        
        int[][] sortedCount = new int[dict.size()][2];
        int[] temp;
        int i = 0;
        for (int key : dict.keySet()) {
            temp = new int[2];
            temp[0] = key;
            temp[1] = dict.get(key);
            sortedCount[i] = temp;
            i++;
        }
        
        Arrays.sort(sortedCount, Comparator.comparingInt(a -> a[1]));
        boolean valid = true;
        
        char[] res;
        res = new char[s.length()];
        int j = sortedCount.length - 1;
        for (i = 0; i < res.length; i += 2) {
            while (sortedCount[j][1] == 0) {
                j--;
            }
            res[i] = (char) sortedCount[j][0];
            sortedCount[j][1]--;        
        }

        j = sortedCount.length - 1;
        for (i = 1; i < res.length; i += 2) {
            while (sortedCount[j][1] == 0) {
                j--;
            }
            res[i] = (char) sortedCount[j][0];
            sortedCount[j][1]--;        
        }    
        for (i = 1; i < res.length; i++) {
            if (res[i-1] == res[i]) {
                valid = false;
                break;
            }
        }
        if (valid)
            return new String(res);
        return "";
    }
}
