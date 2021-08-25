class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int j, days;
        for (int i = answer.length - 1; i >= 0; i--) {
            j = i;
            days = 0;
            while (j < answer.length &&
                   temperatures[j] <= temperatures[i]) {
                j++;
                days++;
            }
            if (j < answer.length) {
                answer[i] = days;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
