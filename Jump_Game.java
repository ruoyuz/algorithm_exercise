public class Solution {
    public boolean canJump(int[] A) {
        if (A.length <= 1) return true;
        int curMax = 0;
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i > max) break;
        	curMax = A[i] + i;
        	if (curMax > max) {
        		max = curMax;
        	}
        	if (max >= A.length - 1) return true;
        }
	return false;
    }
}
