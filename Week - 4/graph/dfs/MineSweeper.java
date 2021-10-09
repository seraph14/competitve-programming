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
            int i = 0;
            if (row + 1 < board.length) {
                if (col + 1 < board[row].length) {
                    if (board[row+1][col+1] == 'M') {
                        mines++;
                    } else if (board[row+1][col+1] == 'E') {
                        unrevealed[i][0] = row+1;
                        unrevealed[i][1] = col+1;
                        i++;
                    } 
                }

                if (col - 1 >= 0) {
                    if (board[row+1][col-1] == 'M') {
                        mines++;
                    } else if (board[row+1][col-1] == 'E') {
                        unrevealed[i][0] = row+1;
                        unrevealed[i][1] = col-1;
                        i++;
                    } 
                }

                if (board[row+1][col] == 'M') {
                    mines++;
                } else if (board[row+1][col] == 'E') {
                    unrevealed[i][0] = row+1;
                    unrevealed[i][1] = col;
                    i++;
                }
            }

            if (row - 1 >= 0) {
                if (col + 1 < board[row].length) {
                    if (board[row-1][col+1] == 'M') {
                        mines++;
                    } else if (board[row-1][col+1] == 'E') {
                        unrevealed[i][0] = row-1;
                        unrevealed[i][1] = col+1;
                        i++;
                    } 
                }

                if (col - 1 >= 0) {
                    if (board[row-1][col-1] == 'M') {
                        mines++;
                    } else if (board[row-1][col-1] == 'E') {
                        unrevealed[i][0] = row-1;
                        unrevealed[i][1] = col-1;
                        i++;
                    } 
                }
                if (board[row-1][col] == 'M') {
                    mines++;
                } else if (board[row-1][col] == 'E') {
                    unrevealed[i][0] = row-1;
                    unrevealed[i][1] = col;
                    i++;
                }
            }

            if (col + 1 < board[row].length) {
                if (board[row][col+1] == 'M') {
                    mines++;
                } else if (board[row][col+1] == 'E') {
                    unrevealed[i][0] = row;
                    unrevealed[i][1] = col+1;
                    i++;
                }
            }

            if (col - 1 >= 0) {
                if (board[row][col-1] == 'M') {
                    mines++;
                } else if (board[row][col-1] == 'E') {
                    unrevealed[i][0] = row;
                    unrevealed[i][1] = col-1;
                    i++;
                }
            }



            if (mines > 0) {
                board[row][col] = (char) (mines + '0');
            } else {
                board[row][col] = 'B';
                for (int j = 0; j < i; j++) {
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
