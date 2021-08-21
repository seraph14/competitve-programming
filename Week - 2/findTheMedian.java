class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
    // Write your code here
      // TODO: Once you learn a sorting algorithm with O(nlogn) implement here
      // int j, current;  
      // for (int i = 1; i < arr.size(); i++) {
      //   current = arr.get(i);
      //   j = i - 1;
      //   while (j >= 0 && arr.get(j) > current) {
      //     arr.set(j + 1, arr.get(j));
      //     j--;
      //   }
      //   arr.set(j + 1, current);
      // }
      Collections.sort(arr);
      return arr.get(arr.size() / 2);
    }

}
