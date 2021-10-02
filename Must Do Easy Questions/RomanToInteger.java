class Solution {
    public int romanToInt(String s) {
        int num = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch(c) {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'I') {
                        num -= 2;
                    }
                    break;
                case 'X':
                    num += 10;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'I') {
                        num -= 2;
                    }
                    break;
                case 'L':
                    num += 50;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'X') {
                        num -= 20;
                    }
                    break;
                case 'C':
                    num += 100;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'X') {
                        num -= 20;
                    }
                    break;
                case 'D':
                    num += 500;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'C') {
                        num -= 200;
                    }
                    break;
                case 'M':
                    num += 1000;
                    if (i - 1 >= 0 && s.charAt(i-1) == 'C') {
                        num -= 200;
                    }
                    break;
            }
        }
        return num;
    }
}
