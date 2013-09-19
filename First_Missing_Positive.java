public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        HashMap<Integer,Integer> right = new HashMap<Integer,Integer>();
        
        int key=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                right.put(A[i],A[i]);
                if(A[i]<key) key = A[i];
            }
        }
        
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                if(right.containsKey(A[i]+1)) right.put(A[i],right.get(A[i]+1));
            }
        }
        
        if(!right.containsKey(1)) return 1;
        else key = 1;
        
        while(key!=right.get(key)){
            key = right.get(key);
        }
        
        return key+1;
        
    }
}
