public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        next.add(comb);
        
        for(int i=0;i<k;i++){
            current = next;
            next = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> list:current){
                for(int j=n;j>0;j--){
                    if(list.isEmpty()||j<list.get(0)){
                        ArrayList<Integer> newlist = new ArrayList<Integer>(list);
                        newlist.add(0,j);
                        next.add(newlist);
                    }
                }
            }
        }
        return next;
    }
}
