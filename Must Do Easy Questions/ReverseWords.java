class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String temp;
        for (int i = 0; i < arr.length; i++) {
            temp = "";
            for (int j = arr[i].length() - 1; j >= 0; j--) {
                temp += arr[i].charAt(j);
            } 
            arr[i] = temp;
        }
        
        return String.join(" ", arr);
    }
}
