class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int max = 0, maxChar = 0;
        for (char c : tasks) {
            map[c - 'A']++;
            if (map[c - 'A'] > max) {
                max = map[c - 'A'];
                maxChar = c - 'A';
            }
        }
        
        max--;
        int idle_slots = max * n;
        for (int i = 0; i < map.length; i++) {
            if (i != maxChar) {
                idle_slots -= Math.min(map[i], max);    
            }
        }
        
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
