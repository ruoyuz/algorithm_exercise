public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = s.length();
        if(l<1) return 0;
        int[] cache = new int[l];
        for(int i=0;i<l;i++) cache[i]=-1;
        return nextDecode(s,0,cache);
    }
    
    public int nextDecode(String s, int i, int[] cache){
        int l=s.length();
        if(i>l) return 0;
        if(i==l) return 1;
        int n = 0;
        if(cache[i]!=-1) return cache[i];
        if(i==l-1){
            if(isValid(s.substring(i,i+1))) n+=1;
        }
        else{
            if(isValid(s.substring(i,i+1))) n+=nextDecode(s, i+1, cache);
            if(isValid(s.substring(i,i+2))) n+=nextDecode(s, i+2, cache);
        }
        cache[i] = n;
        return n;
    }
    
    public boolean isValid(String s){
        int n = Integer.parseInt(s);
        if(n>0&&n<10&&s.length()==1) return true;
        if(n>9&&n<27&&s.length()==2) return true;
        return false;
    }
}
