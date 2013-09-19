public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int[] Rows = new int[n];
        ArrayList<String[]> result = new ArrayList<String[]>();
        solve(Rows, result, 0);
        return result;
    }
    
    public void solve(int[] Rows, ArrayList<String[]> result, int i){
        int n = Rows.length;
        if(i==n) addResult(Rows, result);
        else{
            for(int j=0;j<n;j++){
                Rows[i] = j;
                if(isValid(Rows,i,j)) solve(Rows, result, i+1);
            }
        }
    }
    
    public void addResult(int[] Rows, ArrayList<String[]> result){
        int n = Rows.length;
        String[] strs = new String[n];
        for(int i=0;i<n;i++){
            StringBuilder line = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==Rows[i]) line.append('Q');
                else line.append('.');
            }
            strs[i] = line.toString();
        }
        result.add(strs);
    }
    
    public boolean isValid(int[] Rows, int i, int j){
        int n = Rows.length;
        for(int a=0;a<i;a++){
            int row=a;
            int col=Rows[a];
            if(col==j) return false;
            int drow = i-a;
            int dcol = Math.abs(j-col);
            if(drow==dcol) return false;
        }
        return true;

    }
}
