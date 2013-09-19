public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0, j=A.length-1, swap;
        while(i<=j){
            if(A[i]!=elem) i++;
            else if(A[j]==elem) j--;
            else {
                swap = A[i];
                A[i] = A[j];
                A[j] = swap;
            }
        }
        return i;
    }
}
