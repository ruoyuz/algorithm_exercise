public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        String result = "";
        for(int i=0; i<len; i++){
            String ss = getPal(s, i, i);
            if(ss.length()>result.length()) result=ss;
        }
        for(int i=0; i<len-1; i++){
            String ss = getPal(s, i, i+1);
            if(ss.length()>result.length()) result=ss;
        }
        return result;
    }
    
    public static String getPal(String s,int i, int j){
        int l=i, r=j;
        while(s.charAt(l)==s.charAt(r)){
            if(l==0 || r==s.length()-1) return s.substring(l,r+1);
            l--;
            r++;
        }
        l++;
        r--;
        return s.substring(l,r+1);
    }
}
