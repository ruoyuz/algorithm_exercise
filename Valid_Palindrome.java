public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = s.length();
        if(l<1) return true;
        int i=0, j=l-1;
        while(i<j){
            if(s.charAt(i)<'0'||(s.charAt(i)>'9'&&s.charAt(i)<'A')||(s.charAt(i)>'Z'&&s.charAt(i)<'a')||s.charAt(i)>'z') {
                i++;
                continue;
            }
            if(s.charAt(j)<'0'||(s.charAt(j)>'9'&&s.charAt(j)<'A')||(s.charAt(j)>'Z'&&s.charAt(j)<'a')||s.charAt(j)>'z') {
                j--;
                continue;
            }
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a>='A'&&a<='Z') a += 32;
            if(b>='A'&&b<='Z') b += 32;
            if(a!=b) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
