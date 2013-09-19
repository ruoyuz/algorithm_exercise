public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=prices.length;
        if(l<2) return 0;
        
        int max=prices[l-1], min=prices[0], profit=0;
        int[] maxs=new int[l], mins=new int[l];
        for(int i=0,j=l-i-1;i<l;j=l-1-(++i)){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[j]);
            mins[i] = min;
            maxs[j] = max;
        }
        for(int i=0;i<l;i++){
            profit = Math.max(profit,maxs[i]-mins[i]);
        }
        return profit;
    }
}
