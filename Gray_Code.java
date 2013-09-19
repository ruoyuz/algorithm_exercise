public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>(result);
            int pow = (int) Math.pow(2,i);
            int size = result.size();
            for(int j=0;j<size;j++){
                result.add(temp.remove(temp.size()-1)+pow);
            }
        }
        return result;
    }
}
