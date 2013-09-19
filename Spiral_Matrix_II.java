public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] mat = new int[n][n];
        int i=0,j=0,k=1;
        while(k<=Math.pow(n,2)){
            while(j<n&&i<n&&mat[i][j]==0) mat[i][j++] = k++;
            j--;i++;
            while(i<n&&j>=0&&mat[i][j]==0) mat[i++][j] = k++;
            i--;j--;
            while(j>=0&&i>=0&&mat[i][j]==0) mat[i][j--] = k++;
            j++;i--;
            while(i>=0&&j<n&&mat[i][j]==0) mat[i--][j] = k++;
            i++;j++;
        }
        return mat;
    }
}
