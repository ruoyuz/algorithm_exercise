public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0;i<n;i++) A[m+i] = B[i];
        inSort(A,m+n);
    }
    
    public void inSort(int[] A, int l){
        for(int i=0;i<l;i++){
            for(int j=i;j>0;j--){
                if(A[j]>=A[j-1]) break;
                swap(A,j,j-1);
            }
        }
    }
    
    public void swap(int[] A, int i, int j){
        int swap = A[i];
        A[i] = A[j];
        A[j] = swap;
    }
}
