public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        /*
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(map.containsKey(c)) map.put(c,map.get(c)+1);
            else map.put(c,1);
        }
        
        
        int i=0, j=0, l=-1, r=S.length();
        boolean shrink = false;
        
        while(i<=j&&j<=S.length()){
            
            shrink = true;
            for(Integer v:map.values()){
                if(v>0){
                    shrink = false;
                    break;
                }
            }
            
            if(shrink){
                if(j-i<r-l){
                    r=j;
                    l=i;
                }
                char ci = S.charAt(i);
                if(!map.containsKey(ci)) i++;
                else{
                    map.put(ci,map.get(ci)+1);
                    i++;
                }
            }
            else{
                if(j==S.length()) break;
                char cj = S.charAt(j);
                if(!map.containsKey(cj)) j++;
                else{
                    map.put(cj,map.get(cj)-1);
                    j++;
                }
            }
        }
        */

	return l==-1?"":S.substring(l,r);
    }
}
