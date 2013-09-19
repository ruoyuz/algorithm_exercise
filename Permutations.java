public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l=num.length;
        if(l<1) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<ArrayList<Integer>> temp = new LinkedList<ArrayList<Integer>>();
        
        for(int i=0;i<l;i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(num[i]);
            temp.add(a);
        }
        
        while(!temp.isEmpty()){
            ArrayList<Integer> a = temp.poll();
            if(a.size()==l) result.add(a);
            else{
                for(int i=0;i<l;i++){
                    if(!a.contains(num[i])){
                        ArrayList<Integer> b = new ArrayList<Integer>(a);
                        b.add(num[i]);
                        temp.add(b);
                    }
                }
            }
        }
        return result;
    }
}
