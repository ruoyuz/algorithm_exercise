public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(divisor==0) return 0;
        boolean neg = false;
        long longDividend = dividend;
        long longDivisor = divisor;        
        if(longDividend<0){
            longDividend = -longDividend;
            neg = !neg;
        }
        if(longDivisor<0){
            longDivisor = -longDivisor;
            neg = !neg;
        }
        
        int result = div(longDividend,longDivisor);
        return neg?-result:result;
    }
    
    public int div(long dividend, long divisor){
        if(dividend<divisor) return 0;
        int i=1;
        long oldDivisor = divisor;
        while(true){
            divisor <<= 1;
            if(divisor<0) break;
            if(dividend>divisor) i+=i;
            else break;
        }
        divisor>>>=1;
        dividend -= divisor;
        return i+div(dividend,oldDivisor);
    }
}
