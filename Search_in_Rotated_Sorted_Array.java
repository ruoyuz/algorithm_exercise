public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = A.length;
        if(l<1) return -1;
        int lo=0, hi=l-1;
        while(lo<hi){
            int mid=(hi+lo)/2;
            int a=A[lo], b=A[mid], c=A[hi];
            if(c>a){
                if(target<=b) hi=mid;
                else lo=mid+1;
            }
            else if(b>=a){
                if(target<a || target>b) lo=mid+1;
                else hi=mid;
            }
            else {
                if(target<=b || target>=a) hi=mid;
                else lo=mid+1;
            }
        }
        return target==A[lo]?lo:-1;
    }
}
