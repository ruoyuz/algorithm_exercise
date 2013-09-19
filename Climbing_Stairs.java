public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] a = new int[n+1];
        a[0] = 1;
        return step(n,a);
    }
    
    public int step(int n, int[] a){
        if(n<0) return 0;
        if(a[n]!=0) return a[n];
        a[n] = step(n-1,a)+step(n-2,a);
        return a[n];
    }
}
