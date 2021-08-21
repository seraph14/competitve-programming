class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
      // int j, temp;
      // for (int i = 1; i < prices.size(); i++) {
      //   temp = prices.get(i);
      //   j = i - 1;
      //   while (j >= 0 && prices.get(j) > temp) {
      //     prices.set(j+1, prices.get(j));
      //     j--;
      //   }
      //   prices.set(j+1, temp);
      // }
      Collections.sort(prices);
      
      int i = 0;
      int maxToys = 0, sum = 0;
      while (i < prices.size() && sum <= k) {
        sum += prices.get(i);
        if (sum <= k)
          maxToys++;
        i++;
      }
      return maxToys;
    }

}
