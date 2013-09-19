public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int ls=S.length(), lt=T.length();
        
        int[] n = new int[lt+1];
        n[lt]=1;
        
        for(int i=ls-1;i>=0;i--){
            for(int j=0;j<lt;j++){
                if(S.charAt(i)==T.charAt(j)) n[j] += n[j+1];
            }
        }
        return n[0];
    }
}
