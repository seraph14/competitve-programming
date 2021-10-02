import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] s1 = Arrays.copyOfRange(arr, 0, mid); 
        int[] s2 = Arrays.copyOfRange(arr, mid, n);
        mergeSort(s1);
        mergeSort(s2);
        int i = 0, j = 0;
        while (i + j < arr.length) {
            if (j == s2.length || (i < s1.length && s1[i] < s2[j])) {
                arr[i+j] = s1[i++];
            } else {
                arr[i+j] = s2[j++];
            }
        }
    }
}