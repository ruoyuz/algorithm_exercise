public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack==null || needle==null) return null;
        int lh=haystack.length(), ln=needle.length();
        if(ln==0) return haystack;
        if(lh==0) return null;
        if(ln>lh) return null;
        
        for(int i=0;i<=lh-ln;i++){
            if(haystack.substring(i,i+ln).equals(needle)) return haystack.substring(i);
        }
        
        return null;
    }
}
