class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        int[] temp = new int[3];
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = 1;
        grid[0][0] = 1;
        queue.add(temp);
        
        int row, col, d, prevRow, prevCol;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            row = temp[0];
            col = temp[1];
            d = temp[2];
            
            
            
            if (row == grid.length - 1 && col == grid[row].length - 1) {
                return d;
            }
            
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[row].length)
                        continue;
                    if (grid[r][c] == 0) {
                        temp = new int[3];
                        temp[0] = r;
                        temp[1] = c;
                        temp[2] = d + 1;
                        
                        grid[r][c] = 1;
                        queue.add(temp);
                    }
                }
            }
            
            
        }
        
        return -1;
    }
}
