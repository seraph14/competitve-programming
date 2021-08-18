public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9,-1,3,2,0,1};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int lastSortedIndex = 0;
        int temp;
        for (int j = 1; j < arr.length; j++) {
            temp = arr[lastSortedIndex+1];
            for (int i = lastSortedIndex; i >= 0; i--) {
                if (arr[i] > temp) {
                    lastSortedIndex++;
                    swap(i, i+1, arr);
                } else {
                    insert(lastSortedIndex, j, arr);
                    lastSortedIndex++;
                    break;
                }
            } 
            lastSortedIndex = j;
        }
    }

    public static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void insert(int insertIndex, int elemIndex, int[] arr) {
        for (int i = elemIndex; i > insertIndex; i--) {
            swap(i, i-1, arr);
        } 
    }
}
