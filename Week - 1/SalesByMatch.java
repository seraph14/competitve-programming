class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
      HashMap<Integer, Integer> dict = new HashMap<>();
      int pairs = 0, temp;
      for (int i = 0; i < n; i++) {
        if (dict.containsKey(ar.get(i))) {
          temp = dict.get(ar.get(i));
          dict.put(ar.get(i), ++temp);
          if (temp / 2 == 1) {
            dict.put(ar.get(i), 0);
            pairs++;
          } 
        } else {
          dict.put(ar.get(i), 1);
        }
      }
      return pairs;
    }

}
