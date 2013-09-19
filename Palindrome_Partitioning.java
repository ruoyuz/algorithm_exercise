public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer[], Boolean> map = new HashMap<Integer[], Boolean>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        getPartitions(s,0,map,new ArrayList<String>(),result);
        return result;
    }
    
    public void getPartitions(String s, int p, HashMap<Integer[], Boolean> map, ArrayList<String> list, ArrayList<ArrayList<String>> result){
        if(p==s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i=s.length();i>p;i--){
            if(isPalindrome(s,p,i,map)){
                list.add(s.substring(p,i));
                getPartitions(s,i,map,list,result);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int l, int r, HashMap<Integer[], Boolean> map){
        if(l>=r) return false;
        Integer[] pair = new Integer[]{l,r};
        if(map.containsKey(pair)) return map.get(pair);
        int i=(r-l-1)/2+l, j=(r-l)/2+l;
        while(i>=l&&j<r){
            if(s.charAt(i)!=s.charAt(j)){
                map.put(pair,false);
                return false;
            }
            else{
                i--;
                j++;
            }
        }
        map.put(pair,true);
        return true;
    }
}
