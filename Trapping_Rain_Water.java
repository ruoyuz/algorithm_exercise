public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = A.length;
        if(l<2) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result=0, h=A[0];
        stack.push(h);
        for(int i=1;i<l;i++){
            if(h>A[i]){
                stack.push(A[i]);
            }
            else{
                while(!stack.isEmpty()){
                    result+=(h-stack.pop());
                }
                h=A[i];
                stack.push(h);
            }
        }
        
        while(!stack.isEmpty()) stack.pop();
        
        h=A[l-1];
        stack.push(h);
        
        for(int i=l-2;i>-1;i--){
            if(h<A[i]){
                while(!stack.isEmpty()){
                    result+=(h-stack.pop());
                }
                h=A[i];
                stack.push(h);
            }
            else{
                stack.push(A[i]);
            }
        }
        return result;
    }
}
