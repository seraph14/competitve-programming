public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs.length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int currCost = costs[i][j];
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < 3; k++) {
                    min = Math.min(min, currCost + costs[i - 1][(j + k) % 3]);
                    costs[i][j] = min;
                }
            }
        }

        int row = costs.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, costs[row][i]);
        }

        return min;
    }
}
