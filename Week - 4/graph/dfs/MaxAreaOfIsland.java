class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int tempArea = 0;
        int m = grid.length;
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>(2);
        int row, col;
        
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    temp = new ArrayList<>(2);
                    temp.add(i);
                    temp.add(j);
                    stack.push(temp);
                }
            }
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            row = temp.get(0);
            col = temp.get(1);
            tempArea = 0;
            Stack<List<Integer>> areaStack = new Stack<>();
            areaStack.push(temp);
            while (!areaStack.isEmpty()) {
                temp = areaStack.pop();
                row = temp.get(0);
                col = temp.get(1);
                if (grid[row][col] == 0)
                    continue;
                grid[row][col] = 0;
                tempArea++;
                if (row + 1 < m && grid[row+1][col] == 1) {
                    temp = new ArrayList<>(2);
                    temp.add(row + 1);
                    temp.add(col);
                    areaStack.push(temp);
                } 

                if (row - 1 >= 0 && grid[row-1][col] == 1) {
                    temp = new ArrayList<>(2);
                    temp.add(row - 1);
                    temp.add(col);
                    areaStack.push(temp);
                } 

                if (col + 1 < grid[row].length && grid[row][col+1] == 1) {
                    temp = new ArrayList<>(2);
                    temp.add(row);
                    temp.add(col + 1);
                    areaStack.push(temp);
                }

                if (col - 1 >= 0 && grid[row][col-1] == 1) {
                    temp = new ArrayList<>(2);
                    temp.add(row);
                    temp.add(col - 1);
                    areaStack.push(temp);
                }

            }
            if (tempArea > maxArea) 
                maxArea = tempArea;

        }
        return maxArea;
    }
}
