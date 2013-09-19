public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length<1) return null;
        Arrays.sort(num);
        return permute(num, 0, new boolean[num.length]);
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num, int l, boolean[] used){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(l==num.length) result.add(new ArrayList<Integer>());
        else for(int i=0;i<num.length;i++){
                if(used[i] || i>0&&num[i]==num[i-1]&&used[i-1]) continue;
                used[i] = true;
                for(ArrayList<Integer> a:permute(num,l+1,used)){
                    a.add(0,num[i]);
                    result.add(a);
                }
                used[i] = false;
        }
        return result;
    }
}
