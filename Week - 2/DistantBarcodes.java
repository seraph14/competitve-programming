class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int barcode : barcodes) {
            if (dict.containsKey(barcode)) {
                dict.put(barcode, dict.get(barcode) + 1);
            } else {
                dict.put(barcode, 1);
            }
        }
        
        int[][] sortedCount = new int[dict.size()][2];
        int[] temp;
        int i = 0;
        for (int key : dict.keySet()) {
            temp = new int[2];
            temp[0] = key;
            temp[1] = dict.get(key);
            sortedCount[i] = temp;
            i++;
        }
        
        Arrays.sort(sortedCount, Comparator.comparingInt(a -> a[1]));
        int j = sortedCount.length - 1;
        for (i = 0; i < barcodes.length; i += 2) {
            while (sortedCount[j][1] == 0) {
                j--;
            }
            barcodes[i] = sortedCount[j][0];
            sortedCount[j][1]--;    
        }
        
        j = sortedCount.length - 1;
        for (i = 1; i < barcodes.length; i += 2) {
            while (sortedCount[j][1] == 0) {
                j--;
            }
            barcodes[i] = sortedCount[j][0];
            sortedCount[j][1]--;
        }
        return barcodes;
    }
}
