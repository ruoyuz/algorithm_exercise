public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return uniqueTrees(1,n);
    }
    
    public int uniqueTrees(int s, int n){
        if(s>=n) return 1;
        
        int result = 0;
        for(int i=s;i<=n;i++){
            result += uniqueTrees(s,i-1)*uniqueTrees(i+1,n);
        }
        return result;
    }
}
