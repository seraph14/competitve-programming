class Solution {
    public int hIndex(int[] citations) {
        int h = 0, start = 0, end = citations.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (citations[mid] >= (citations.length - mid)) {
                h = citations.length - mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return h;
    }
}
