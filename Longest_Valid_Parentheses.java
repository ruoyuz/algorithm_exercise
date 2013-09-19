public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = s.length();
        if(l<2) return 0;
        
        Stack<Integer> left = new Stack<Integer>();
        int last=-1, maxN=0;
        
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(c=='('){
                left.push(i);
            }
            else if(c==')'){
                if(left.isEmpty()){
                    last=i;
                }
                else{
                    left.pop();
                    maxN=left.isEmpty()?Math.max(maxN,i-last):Math.max(maxN,i-left.peek());
                }
            }
        }
        
        return maxN;
    }
}
