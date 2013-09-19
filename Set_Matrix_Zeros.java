public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                } 
            }
        }
        int[] rzero = new int[n];
        for(int i=0;i<m;i++){
            if(row[i]) matrix[i]=rzero;
            else for(int j=0;j<n;j++){
                if(col[j]) matrix[i][j]=0;
            }
        }
    }
}
