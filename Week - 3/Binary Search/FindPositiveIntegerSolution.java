/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        int start, end, mid, y;
        for (int x = 1; x <= 1000; x++) {
            start = 1;
            end = 1000;
            while (start <= end) {
                mid = (start) + ((end - start) / 2);
                y = mid;
                if (customfunction.f(x, y) == z) {
                    temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    list.add(temp);
                    break;
                } else if (customfunction.f(x, y) > z) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }            
        }
        return list;
    }
}
