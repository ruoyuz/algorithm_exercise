public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        if(m<3) return;
        int n = board[0].length;
        if(n<3) return;

        boolean[][] checked = new boolean[m][n];
        for(int i=0;i<m;i++){
            check(board,i,0,checked);
            check(board,i,n-1,checked);
        }     
        for(int j=0;j<n;j++){
            check(board,0,j,checked);
            check(board,m-1,j,checked);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!checked[i][j]&&board[i][j]!='X') board[i][j]='X';
            }
        }
    }

    public void check(char[][] board, int i, int j, boolean[][] checked){
        int m = board.length;
        int n = board[0].length;
        
        if(i<0||j<0||i>=m||j>=n) return;
        if(checked[i][j]) return;
        if(board[i][j]=='O'){
            checked[i][j] = true;
            check(board,i-1,j,checked);
            check(board,i+1,j,checked);
            check(board,i,j-1,checked);
            check(board,i,j+1,checked);
        }
        else return;
    }
}

