public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        char[] left = {'(','{','['};
        char[] right = {')','}',']'};
        for(int i=0, l=s.length();i<l;i++){
            for(int j=0; j<left.length;j++){
                if(s.charAt(i)==left[j]) stack.push(left[j]);
                else if(s.charAt(i)==right[j]){
                    if(stack.isEmpty()) return false;
                    else if(stack.peek()==left[j]) stack.pop();
                    else return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
