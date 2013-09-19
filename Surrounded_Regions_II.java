public class Solution {

    public class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        if(m<3) return;
        int n = board[0].length;
        if(n<3) return;

        Queue<Point> q = new LinkedList<Point>();

        for(int i=0;i<m;i++){
            if(board[i][0]=='O') q.add(new Point(i,0));
            if(board[i][n-1]=='O')  q.add(new Point(i,n-1));
        }
    for(int j=0;j<n;j++){
            if(board[0][j]=='O') q.add(new Point(0,j));
            if(board[m-1][j]=='O') q.add(new Point(m-1,j));
        }

        while(q.peek()!=null){
            Point p = q.remove();
            board[p.x][p.y] = '*';

            if(p.x>0&&board[p.x-1][p.y]=='O'){
                q.add(new Point(p.x-1,p.y));
            }
            if(p.x<m-1&&board[p.x+1][p.y]=='O'){
                q.add(new Point(p.x+1,p.y));
            }
            if(p.y>0&&board[p.x][p.y-1]=='O'){
                q.add(new Point(p.x,p.y-1));
            }
            if(p.y<n-1&&board[p.x][p.y+1]=='O'){
                q.add(new Point(p.x,p.y+1));
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='X') board[i][j] = board[i][j]=='O'?'X':'O';
            }
        }
    }
}

