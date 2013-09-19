public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> newLevel = new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(j==0) newLevel.add(1);
                else if(j==i-1) newLevel.add(1);
                else newLevel.add(level.get(j-1)+level.get(j));
            }
            result.add(newLevel);
            level = newLevel;
        }
        return result;
    }
}
