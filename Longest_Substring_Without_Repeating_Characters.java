/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return 0;
        int result=0;
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        int i=0,j=0;
        for(i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hs.containsKey(c)){
                int p = hs.get(c);
                int l = i-j;
                if(l>result) result=l;
                if(j<p+1) j=p+1;
            }
            hs.put(c,i);
        }
        if(i-j>result) return i-j;
        return result;
    }
}
