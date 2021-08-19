public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9,-1,3,2,0,1};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int current, j;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            } 
            arr[j + 1] = current; 
        }
    }
}
