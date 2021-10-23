class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {sr, sc});
        
        int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[] temp;
        int row, col;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            row = temp[0];
            col = temp[1];
            
            image[row][col] = newColor;
            
            for (int[] direction : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;
                
                if (isValidMove(newRow, newCol, image, oldColor)) 
                    stack.push(new int[] {newRow, newCol});
            }
        }
        
        return image;
        
    }
    
    public boolean isValidMove(int newRow, int newCol, int[][] image, int oldColor) {
        int m = image.length;
        int n = image[0].length;
        return !(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) &&
            image[newRow][newCol] == oldColor;
    }
}
