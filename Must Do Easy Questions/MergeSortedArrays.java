class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k;
        int temp;
        while (i < nums1.length && j < n) {
            if (i < m && nums1[i] <= nums2[j]) {
                i++;
            } else if (i < m) {
                temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                k = j + 1;
                while (k < n && nums2[k - 1] > nums2[k]) {
                    swap(k-1, k, nums2);
                    k++;
                }
                i++;
            } else {
                nums1[i] = nums2[j];
                i++; j++;
            }
            
            
        }
    }
    
    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
