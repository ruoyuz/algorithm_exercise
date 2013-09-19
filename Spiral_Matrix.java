public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=matrix.length;
        if(m<1) return new ArrayList<Integer>();
        int n=matrix[0].length;

        ArrayList<Integer> result = new ArrayList<Integer>();
        spiral(matrix, result, 0, m-1, 0, n-1);
        return result;
    }
        
    public void spiral(int[][] matrix, ArrayList<Integer> result, int u, int d, int l, int r){
        if(u>d||l>r) return;
        if(u==d) {for(int i=l;i<=r;i++) result.add(matrix[u][i]);return;}
        else if(l==r) {for(int i=u;i<=d;i++) result.add(matrix[i][l]);return;}
        else{
            int i=u, j=l;
            while(j<r) result.add(matrix[i][j++]);
            while(i<d) result.add(matrix[i++][j]);
            while(j>l) result.add(matrix[i][j--]);
            while(i>u) result.add(matrix[i--][j]);
            u++;r--;d--;l++;
        }
        spiral(matrix, result, u, d, l, r);
    }
}
