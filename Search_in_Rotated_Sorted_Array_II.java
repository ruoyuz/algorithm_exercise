public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = A.length;
        if(l<1) return false;
        int lo=0, hi=l-1;
        while(lo<hi){
            int mid=(hi+lo)/2;
            int a=A[lo], b=A[mid], c=A[hi];
            if(a==b&&b==c){
                for(int i=lo;i<=hi;i++){
                    if(target==A[i]) return true;
                }
                return false;
            }
            else if(c>a){
                if(target>b) lo=mid+1;
                else hi=mid;
            }
            else{
                if(b>=a&&b>=c){
                    if(target>b||target<=c) lo=mid+1;
                    else hi=mid;
                }
                else{
                    if(target<=b||target>=a) hi=mid;
                    else lo=mid+1;
                }
            }
        }
        return target==A[lo]?true:false;
    }
}

