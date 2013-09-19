public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        if(m<1) return 0;
        int n = matrix[0].length;
        if(n<1) return 0;
        int[][] cache = new int[m][n];
        
        for(int j=0;j<n;j++){
            int l=0;
            for(int i=0;i<m;i++){
                if(matrix[i][j]=='1') cache[i][j]=++l;
                else l=0;
            }
        }
        
        int max=0;
        for(int i=0;i<m;i++){
            max = Math.max(max,findMaxRect(cache[i]));
        }
        return max;
    }
    
    public int findMaxRect(int[] histo){
        int l=histo.length, max=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<l;i++){
            if((stack.isEmpty()||histo[i]>=histo[stack.peek()])&&histo[i]!=0) stack.push(i);
            else{
                int j=i;
                while(!stack.isEmpty()&&histo[i]<histo[stack.peek()]){
                    j = stack.pop();
                    int h = histo[j];
                    max = Math.max(max, (i-j)*h);
                }
                histo[j] = histo[i];
                if(histo[j]!=0) stack.push(j);
            }
        }
        while(!stack.isEmpty()){
            int i = stack.pop();
            int h = histo[i];
            max = Math.max(max,(l-i)*h);
        }
        return max;
    }
}
