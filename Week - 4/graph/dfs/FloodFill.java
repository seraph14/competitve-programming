class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = sr, col = sc;
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(sr);
        temp.add(sc);
        stack.push(temp);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp == null) continue;
            
            row = temp.get(0);
            col = temp.get(1);
            
            System.out.println(row + " " + col);
            if (image[row][col] == oldColor) {
                image[row][col] = newColor;
            }
            
            if (row + 1 < m && image[row+1][col] == oldColor) {
                temp = new ArrayList<>();
                temp.add(row + 1);
                temp.add(col);
                stack.push(temp);
            } 
            if (col + 1 < n && image[row][col+1] == oldColor) {
                temp = new ArrayList<>();
                temp.add(row);
                temp.add(col + 1);
                stack.push(temp);
            } 
            if (row - 1 >= 0 && image[row-1][col] == oldColor) {
                temp = new ArrayList<>();
                temp.add(row - 1);
                temp.add(col);
                stack.push(temp);
            } 
            if (col - 1 >= 0 && image[row][col-1] == oldColor) {
                temp = new ArrayList<>();
                temp.add(row);
                temp.add(col - 1);
                stack.push(temp);
            } 
        }
        
        return image;
        
    }
}
