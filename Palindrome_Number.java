public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        if(x<10) return true;
        int y=x, nd=0;
        while(y!=0){
            nd++;
            y/=10;
        }
        y=x;
        int a=0;
        for(int i=0; i<nd/2; i++){
            a = a*10+y%10;
            y /= 10;
        }
        if(nd%2==1) y/=10;
        return y==a;
    }
}
