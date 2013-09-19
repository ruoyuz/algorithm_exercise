public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] map = new int[m][n];
        return stepOut(m,n,1,1,map);
    }
    
    public int stepOut(int m, int n, int i, int j, int[][] map){
        if(i>m) return 0;
        if(j>n) return 0;
        if(i==m&&j==n) return 1;
        if(map[i-1][j-1]!=0) return map[i-1][j-1];
        else{
            int r = stepOut(m,n,i+1,j,map)+stepOut(m,n,i,j+1,map);
            map[i-1][j-1]=r;
            return r;
        }
    }
}
