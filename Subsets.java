public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        Arrays.sort(S);
        next.add(first);
        
        for(int i:S){
            ArrayList<ArrayList<Integer>> current = next;
            next = new ArrayList<ArrayList<Integer>>();
            while(!current.isEmpty()){
                ArrayList<Integer> list = current.remove(0);
                if(!list.contains(i)){
                    ArrayList<Integer> newlist = new ArrayList<Integer>(list);
                    newlist.add(i);
                    next.add(newlist);
                }
                next.add(list);
            }
        }
        return next;
    }
}
