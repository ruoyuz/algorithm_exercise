public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x==0) return 0;
        if(x==1) return 1;
        
        int l=1, r=x;
        if(x==Integer.MAX_VALUE){
            l=2;
            r=x/2;
        }
        while(l<r){
            l*=2;
            r/=2;
        }
        l/=2;
        r*=2;
        while(l+1<r){
            int m = (l+r)/2; 
            if(x==m*m) return m;
            if(m*m>0&&x>m*m) l=m;
            else r=m;
        }
        return l;
    }
}
