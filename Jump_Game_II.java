public class Solution {
    public int jump(int[] A) {
        int l=A.length;
        if(l<1) return -1;
        
        int step=0;
        for(int i=1, max=A[0], mark=0;i<l;i++){
            if(i>mark){
                if(i>max) return -1;
                mark=max;
                step++;
            }
            max=Math.max(max,A[i]+i);
        }
        return step;
    }
}
