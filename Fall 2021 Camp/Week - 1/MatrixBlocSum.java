class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        for (int row = 0; row < mat.length; row++) {
            int col = 0;
            if (row > 0) {
                mat[row][col] += mat[row-1][col];
            }
            col++;
            
            while (col < mat[row].length) {
                if (row == 0) {
                    mat[row][col] = mat[row][col-1] + mat[row][col];
                } else if (col - 1 < 0) {
                    mat[row][col] = mat[row][col] + mat[row-1][col] + mat[row][0] - mat[row-1][0];
                }  else {
                    mat[row][col] = mat[row][col] + mat[row-1][col] + mat[row][col-1] - mat[row-1][col-1];
                }
                col++;   
            }
        }
        
        int[][] res = new int[mat.length][mat[0].length];
        int r1, c1, r2, c2;
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                r1 = Math.max(0, row - k);
                r2 = Math.min(res.length - 1, row + k);
                c1 = Math.max(0, col - k);
                c2 = Math.min(res[row].length - 1, col + k);
                res[row][col] = sumRegion(r1, c1, r2, c2, mat);
            }
        }
        
        return res;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2, int[][] mat) {
        int a1=0, a2=0, common=0;
        if (row1 > 0) {
            a1 = mat[row1-1][col2];
        }

        if (col1 > 0) {
            a2 = mat[row2][col1-1];
        }

        if (row1 > 0 && col1 > 0) {
            common = mat[row1-1][col1-1];
        }

        return mat[row2][col2] - a1 - a2 + common; 
    }
}
