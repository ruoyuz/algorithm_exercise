public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = height.length, max=0;
        int[] vol = new int[l];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<l;i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                if(height[i]>=height[stack.peek()]) stack.push(i);
                else {
                    while(!stack.isEmpty()&&height[i]<height[stack.peek()]){
                        int j = stack.pop();
                        vol[j] += (i-j)*height[j];
                    }
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            vol[j] += (l-j)*height[j];
        }
        
        for(int i=l-1;i>=0;i--){
            if(stack.isEmpty()) stack.push(i);
            else{
                if(height[i]>=height[stack.peek()]) stack.push(i);
                else {
                    while(!stack.isEmpty()&&height[i]<height[stack.peek()]){
                        int j = stack.pop();
                        vol[j] += (j-i-1)*height[j];
                    }
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            vol[j] += j*height[j];
        }
        
        for(int m:vol) if(m>max) max=m;
        return max;
    }
}
