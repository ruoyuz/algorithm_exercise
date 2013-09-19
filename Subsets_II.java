public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);
        for(int i:num){
            while(!result.isEmpty()){
                ArrayList<Integer> list = result.remove(0);
                ArrayList<Integer> newlist = new ArrayList<Integer>(list);
                newlist.add(i);
                if(!temp.contains(list)) temp.add(list);
                if(!temp.contains(newlist)) temp.add(newlist);
            }
            result = temp;
            temp = new ArrayList<ArrayList<Integer>>();
        }
        return result;
    }
}
