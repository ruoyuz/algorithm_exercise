public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        if(m<1) return 0;
        int n = grid[0].length;
        if(n<1) return 0;
        int[] min = new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) min[j] += grid[i][j];
                else if(i==0) min[j] = min[j-1] + grid[i][j];
                else{
                    min[j] = grid[i][j] + Math.min(min[j-1],min[j]);
                }
            }
        }
        return min[n-1];
    }
}

// Old stupid solution:

/*
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int a = grid.length;
        int b = grid[0].length;
        int[][] minSum = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        getMin(grid,0,0,0,minSum);
        return minSum[a-1][b-1];
    }
    public void getMin(int[][] grid, int i, int j, int n, int[][] minSum){
        int a = grid.length;
        int b = grid[0].length;
        if(i>a-1) return;
        if(j>b-1) return;
        n += grid[i][j];
        if(n>=minSum[i][j]) return;
        else minSum[i][j] = n;
        getMin(grid, i+1, j, minSum[i][j], minSum);
        getMin(grid, i, j+1, minSum[i][j], minSum);
    }
}

*/
