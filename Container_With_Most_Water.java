public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0, i=0, j=height.length-1;
        while(i<j){
            int a=height[i], b=height[j];
            int temp=Math.min(a,b)*(j-i);
            if(max<temp) max=temp;
            if(a>=b) j--;
            if(a<b) i++;
        }
        return max;
    }
}
