public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = A.length;
        int i=0,j=0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(i<l){
            j = i;
            while(j<l&&A[j]==A[i]){
                if(j-i<2) list.add(A[j]);
                j++;
            }
            i = j;
        }
        int n = list.size();
        for(int k=0;k<n;k++) A[k]=list.get(k);
        return n;
    }
}
