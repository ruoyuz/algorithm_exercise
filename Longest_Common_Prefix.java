public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=strs.length;
        if(len==0) return "";
        String pre=strs[0];
        for(int i=0;i<len;i++){
            if(pre.length()==0) return "";
            int j=0;
            String current=strs[i];
            while(j<pre.length()&&j<current.length()) 
                if(pre.charAt(j)==current.charAt(j)) j++;
                else break;
            if(j!=pre.length()) pre=pre.substring(0,j);
        }
        return pre;
    }
}
