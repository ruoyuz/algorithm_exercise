public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 0;
        else if(A.length==1) return 1;
        int n=0;
        for(int i=1; i<A.length; i++){
            if(A[n]!=A[i]) A[++n] = A[i];
        }
        return n+1;
    }
}
