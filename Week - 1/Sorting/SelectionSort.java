public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,0};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
        minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, arr);
        }
    }

    public static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
