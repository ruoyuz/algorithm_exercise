public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int la=strs.length;
        ArrayList<String> result = new ArrayList<String>();
        if(la<2) return result;
        HashMap<String, ArrayList<String>> Map = new HashMap<String, ArrayList<String>>();
        
        for(int i=0;i<la;i++){
            char[] cset = strs[i].toCharArray();
            Arrays.sort(cset);
            String s = new String(cset);
            if(!Map.containsKey(s)){
                ArrayList<String> a = new ArrayList<String>();
                a.add(strs[i]);
                Map.put(s,a);
            }
            else{
                ArrayList<String> a = Map.get(s);
                a.add(strs[i]);
                //Map.put(s,a);
            }
        }
        for(ArrayList<String> a:Map.values()){
            if(a.size()>1){
                for(String s:a){
                    result.add(s);
                }
            }
        }
        return result;
    }
}
