class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int j;
        for (int i = 0; i < arr.length; i++) {
            j = 0;
            while (arr[j] != i + 1) {
                j++;
            }
            list.add(j+1);
            reverseSubArray(j, arr);
            list.add(arr.length - i);
            reverseSubArray(arr.length - i - 1, arr);
        }
        list.add(arr.length);
        reverseSubArray(arr.length - 1, arr);
        return list;
        
    }
    
    public void reverseSubArray(int end, int[] arr) {
        int temp, beg = 0; 
        while (beg < end && beg != end) {
            temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
            beg++; end--;
        }
    }
}
