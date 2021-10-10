class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Stack<List<Integer>> stack = new Stack<>();
        
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        
        List<Integer> temp = new ArrayList<>(2);
        temp.add(click[0]);
        temp.add(click[1]);
        stack.push(temp);
        
        while (!stack.isEmpty()) {
            temp = stack.pop();
            row = temp.get(0);
            col = temp.get(1);
            
            int mines = 0;
            int[][] unrevealed = new int[8][2];
            int count = 0, r, c;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    r = row + i;
                    c = col + j;
                    if (r < 0 || c < 0 || r >= board.length || c >= board[row].length) 
                        continue;
                    
                    if (board[r][c] == 'M') {
                        mines++;
                    } else if (board[r][c] == 'E') {
                        unrevealed[count][0] = r;
                        unrevealed[count][1] = c;
                        count++;
                    } 
                    
                }
            }


            if (mines > 0) {
                board[row][col] = (char) (mines + '0');
            } else {
                board[row][col] = 'B';
                for (int j = 0; j < count; j++) {
                    temp = new ArrayList<>(2);
                    temp.add(unrevealed[j][0]);
                    temp.add(unrevealed[j][1]);
                    stack.push(temp);
                }
            }
        }
        
        return board;
    }
}
