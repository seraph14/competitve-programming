class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] arr = new int[rows*cols][2];
        int d1, d2, k, count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                d1 = calcDistance(i, j, rCenter, cCenter);
                k = count - 1;
                while (k >= 0 && calcDistance(arr[k][0], arr[k][1], rCenter, cCenter) > d1) {
                    arr[k+1][0] = arr[k][0];
                    arr[k+1][1] = arr[k][1];
                    k--;
                }
                arr[k+1][0] = i;
                arr[k+1][1] = j;
                count++;
            }
        }
        return arr;
    }
    
    public int calcDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
