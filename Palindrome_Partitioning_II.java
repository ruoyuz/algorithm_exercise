public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] cut = new int[s.length()+1];
        for(int i=0;i<=s.length();i++) cut[i] = i;
        
        boolean[][] mat = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) mat[i][i]=true;
        
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||mat[i+1][j-1])) mat[i][j] = true;
            }
        }
        
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(mat[i][j]){
                    cut[j+1] = Math.min(cut[j+1],cut[i]+(j+1==s.length()?0:1));
                }
            }
        }
        return cut[s.length()];
    }
}
