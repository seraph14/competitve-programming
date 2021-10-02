import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        quickSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void quickSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        int pivot = arr[n - 1];
        List<Integer> L = new ArrayList<>();
        List<Integer> E = new ArrayList<>();
        List<Integer> G = new ArrayList<>();

        // divide
        int i = 0;
        while (i < arr.length) {
            if (arr[i] < pivot) {
                L.add(arr[i]);
            } else if (arr[i] > pivot) {
                G.add(arr[i]);
            } else {
                E.add(arr[i]);
            }
            i++;
        }

        // conquer
        int[] l = L.stream().mapToInt(elem -> elem).toArray();
        int[] g = G.stream().mapToInt(elem -> elem).toArray();
        quickSort(l);
        quickSort(g);

        // merge 
        i = 0;
        int j = 0;
        while (j < l.length) {
            arr[i++] = l[j++]; 
        }

        j = 0;
        while (j < E.size()) {
            arr[i++] = E.get(j++); 
        }

        j = 0;
        while (j < g.length) {
            arr[i++] = g[j++]; 
        }
    }
}
