public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=A.length;
        int[] result = {-1,-1};
        if(l<1) return result;
        
        int lo1=0, hi1=l-1, lo2=0, hi2=l, mid1, mid2;
        while(lo1<hi1){
            mid1=(lo1+hi1)/2;
            if(target>A[mid1]) lo1=mid1+1;
            else hi1=mid1;
        }
        
        while(lo2<hi2){
            mid2=(lo2+hi2)/2;
            if(target<A[mid2]) hi2=mid2-1;
            else lo2=mid2;
        }
        
        if(A[lo1]==target){
            result[0]=lo1;
            result[1]=lo2;
        }
        
        return result;
    }
}
