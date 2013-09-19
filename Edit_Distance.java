public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1=word1.length(), l2=word2.length();
        
        int[][] distance = new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++) distance[i][0] = i;
        for(int i=1;i<=l2;i++) distance[0][i] = i;
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                int replace = (word1.charAt(i-1)==word2.charAt(j-1)?0:1) + distance[i-1][j-1];
                int delete = distance[i-1][j] + 1;
                int insert = distance[i][j-1] + 1;
                
                distance[i][j] = (delete<insert?delete:insert)<replace?(delete<insert?delete:insert):replace;
            }
        }
        
        return distance[l1][l2];
    }
}
