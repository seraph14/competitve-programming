public class BubbleSort {
    public static void main(String[] args) {
        int[] unsorted = {3,4,2,1,0};
        bubleSort(unsorted);
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        
    }

    public static void bubleSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] > arr[i]) {
                    swap(i-1, i, arr);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    public static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}