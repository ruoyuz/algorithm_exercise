public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int mark=1;
        if(x==0) return x;
        if(x<0) {mark=-1; x*=-1;}
        int result=0;
        while(x!=0){
            result = result*10+x%10;
            x/=10;
        }
        return result*mark;
    }
}
