class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Arrays.sort(points, Comparator.comparingInt(a -> calculateDistance(a)));
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }
    
    public int calculateDistance(int[] arr) {
        return (int) Math.pow(arr[0], 2) + (int) Math.pow(arr[1], 2);
    }  
}
