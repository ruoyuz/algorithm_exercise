public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        if(l3!=l1+l2) return false;
        if(l1==0) return s2.equals(s3);
        if(l2==0) return s1.equals(s3);
        
        boolean[][] map = new boolean[l1+1][l2+1];

        for(int i=0;i<l1+1;i++){
            for(int j=0;j<l2+1;j++){
                if((i==0&&j==0)||(i-1>=0&&map[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(j-1>=0&&map[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1))){
                    map[i][j] = true;
                }
                else map[i][j] = false;
            }
        }
        return map[l1][l2];
    }
}
