class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> dict = new HashMap<>();
        boolean res = false;
        
        for (char c: s.toCharArray()) {
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }
        
        for (char c : t.toCharArray()) {
            if (!dict.containsKey(c)) {
                dict.put(c, 1);
                break;
            } else {
                dict.put(c, dict.get(c) - 1);
            }
        }
        
        for (char key : dict.keySet()) {
            if (dict.get(key) > 0) {
                res = false;
                break;
            } else {
                res = true;
            }
        }
        
        return res;
    }
}
