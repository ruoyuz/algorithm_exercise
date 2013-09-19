public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=m-1,k=n-1;
        while(i<j){
            int mid = (i+j+1)/2;
            if(target>=matrix[mid][0]) i=mid;
            else j=mid-1;
        }
        i=0;
        while(i<k){
            int mid = (i+k+1)/2;
            if(target>=matrix[j][mid]) i=mid;
            else k=mid-1;
        }
        if(target==matrix[j][k]) return true;
        else return false;
    }
}
