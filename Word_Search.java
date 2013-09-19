public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        int n = board[0].length;
        int l = word.length();
        boolean[][] check = new boolean[m][n];
        
        if(l<1) return false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,word,check,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, boolean[][] check, int i, int j, int k){
        
        int m = board.length;
        int n = board[0].length;
        int l = word.length();
        
        if(k>=l) return true;
        if(i<0||j<0||i>=m||j>=n||check[i][j]) return false;
        else if(board[i][j]!=word.charAt(k)) {
            return false;
        }
        else{
            check[i][j] = true;
            boolean result =  search(board,word,check,i+1,j,k+1)||search(board,word,check,i-1,j,k+1)||search(board,word,check,i,j+1,k+1)||search(board,word,check,i,j-1,k+1);
            check[i][j] = false;
            return result;
        }
    }
}
