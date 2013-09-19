public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        return comSum(candidates,target,0,list);
    }
    
    public ArrayList<ArrayList<Integer>> comSum(int[] candidates, int target, int a, ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=a;i<candidates.length;i++){
            if(candidates[i]==target){
                ArrayList<Integer> newList = new ArrayList<Integer>(list);
                newList.add(candidates[i]);
                if(!result.contains(newList)) result.add(newList);
            }
            else if(candidates[i]<target){
                ArrayList<Integer> newList = new ArrayList<Integer>(list);
                newList.add(candidates[i]);
                for(ArrayList<Integer> l:comSum(candidates,target-candidates[i],i,newList)){
                    if(!result.contains(l)) result.add(l);
                }
            }
            else break;
        }
        return result;
    }
}
