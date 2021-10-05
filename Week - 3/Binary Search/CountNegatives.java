class Solution {
    public int countNegatives(int[][] grid) {
        int col = grid[0].length - 1, row = 0, count = 0;
        while (col >= 0 && row < grid.length) {
            if (grid[row][col] < 0) {
                count += grid.length - row;
                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}
