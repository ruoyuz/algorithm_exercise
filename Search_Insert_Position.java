public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=A.length;
        if(l<1) return 0;
        
        int lo=0, hi=l-1;
        if(target>A[hi]) return l;
        else{
            while(lo<hi){
                int mid = (lo+hi)/2;
                if(target>A[mid]) lo=mid+1;
                else hi=mid;
            }
        }
        return lo;
    }
}
