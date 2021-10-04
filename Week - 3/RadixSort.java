import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3221,1,10,9680, 577,9420,7,5622,4793,2030,3138,82,2599,743,4127};
        radixSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void radixSort(int[] arr) {
        Queue<Integer>[] bucket = new Queue[10];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int ith = 0;
        while (ith < (max + "").length()) {
            for (int num : arr) {
                String str = num + "";
                int digit = 0;
                if (ith < str.length()) {
                    digit = Integer.parseInt(str.charAt(str.length() - 1 - ith) + ""); 
                }
                if (bucket[digit] == null) {
                    bucket[digit] = new LinkedList<>();
                }
                bucket[digit].add(num);
            }
            
            int i = 0;
            for (Queue<Integer> list : bucket) {
                while (list != null && !list.isEmpty()) {
                    arr[i] = list.remove();
                    i++;
                }
            }
            ith++;
        }
    }
}
