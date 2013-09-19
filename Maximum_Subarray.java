public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=Math.max(0,A[0]), tempMax=Math.max(0,A[0]), singleMax=A[0];
        for(int i=1;i<A.length;i++){
            singleMax = Math.max(singleMax,A[i]);
            tempMax = Math.max(0,tempMax+A[i]);
            max = Math.max(singleMax,Math.max(max,tempMax));
        }
        return singleMax>0?max:singleMax;
    }
}
