public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        for(int i=1;i<=rowIndex+1;i++){
            for(int j=i-2;j>0;j--){
                int val = level.get(j-1)+level.get(j);
                level.set(j,val);
            }
            level.add(1);
        }
        return level;
    }
}
