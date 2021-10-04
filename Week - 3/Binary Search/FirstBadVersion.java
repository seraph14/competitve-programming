/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid, bad = n;
        while (r - l > 0) { 
            mid = ((r - l) / 2) + l;    
            if (isBadVersion(mid)) {
                r = mid;    
                if (mid < bad) {
                    bad = mid;
                }
            } else {
                if (l == mid) {
                    mid++;
                } 
                l = mid;
            }
        }
        return bad;
    }
}
