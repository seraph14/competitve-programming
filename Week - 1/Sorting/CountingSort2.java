class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
      List<Integer> answer = new ArrayList<>();
      int max = arr.get(0);
      for (Integer i : arr) {
        if (max < i) 
          max = i;
      }
      System.out.println(max);
      int[] count = new int[max + 1];
      for (Integer i: arr) {
        count[i] = count[i] + 1;
      }
      int i = 0;
      while (i < count.length) {
        if (count[i] == 0) {
          i++;
        } else {
          answer.add(i);
          count[i] = count[i] - 1;
        } 
      }
      return answer;
    }

}
