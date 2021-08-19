class Solution {
    public int reverse(int x) {
        long i = 0;
        boolean isNeg = (x < 0)? true: false;
        x = (isNeg)? -x: x;
        while (x > 0 && i <= Integer.MAX_VALUE) {
            i = i * 10 + x % 10;    
            x = x / 10;
        }
        if (i > Integer.MAX_VALUE)
            i = 0;
        return (isNeg)? (int) -i: (int) i;
    }
}
