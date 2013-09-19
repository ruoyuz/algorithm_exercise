public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = board.length;
        if(l<1) return false;
        ArrayList<ArrayList<Character>> Rows = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> Cols = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> Blocks = new ArrayList<ArrayList<Character>>();
        
        for(int i=0;i<l;i++){
            ArrayList<Character> list1 = new ArrayList<Character>();
            ArrayList<Character> list2 = new ArrayList<Character>();
            ArrayList<Character> list3 = new ArrayList<Character>();
            Rows.add(list1);
            Cols.add(list2);
            Blocks.add(list3);
        }
        
        for(int i=0;i<l;i++){
            ArrayList<Character> row = Rows.get(i);
            for(int j=0;j<l;j++){
                ArrayList<Character> col = Cols.get(j);
                ArrayList<Character> block = Blocks.get(i/3+(j/3)*3);
                char c = board[i][j];
                if(c!='.'){
                    if(row.contains(c)) return false;
                    else row.add(c);
                    if(col.contains(c)) return false;
                    else col.add(c);
                    if(block.contains(c)) return false;
                    else block.add(c);
                }
            }
        }
        return true;
    }
}
