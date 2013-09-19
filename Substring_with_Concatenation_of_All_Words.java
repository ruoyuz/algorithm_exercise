public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ls=S.length(), ll=L.length;
        int lw = ll==0?0:L[0].length();
        int i=0;
        
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for(String s:L){
            if(words.containsKey(s)) words.put(s,words.get(s)+1);
            else words.put(s,1);
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while(i<=ls-lw*ll){
            String subi = S.substring(i,i+lw);
            if(words.containsKey(subi)){
                if(words.size()==1&&words.get(subi)==1){
                    result.add(i);
                    i++;
                    continue;
                }
                HashMap<String, Integer> map = new HashMap<String, Integer>(words);
                map.put(subi,map.get(subi)-1);
                int j=i+lw;
                while(j<i+lw*ll){
                    String subj=S.substring(j,j+lw);
                    if(map.containsKey(subj)){
                        if(map.get(subj)==0){
                            break;
                        }
                        else{
                            map.put(subj,map.get(subj)-1);
                            j += lw;
                        }
                    }
                    else break;
                    
                    if(j==i+lw*ll) result.add(i);
                }
            }
            i++;
        }
        return result;
    }
}
