public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = -1;
            }
        }
        return stepOut(obstacleGrid,1,1,map);
    }

    public int stepOut(int[][] grid, int i, int j, int[][] map){
        int m = grid.length;
        int n = grid[0].length;
        if(i>m||j>n) return 0;
        if(grid[i-1][j-1]==1) return 0;
        if(i==m&&j==n) return 1;
        if(map[i-1][j-1]!=-1) return map[i-1][j-1];
        else{
            int r = stepOut(grid,i+1,j,map)+stepOut(grid,i,j+1,map);
            map[i-1][j-1]=r;
            return r;
        }
    }
}
