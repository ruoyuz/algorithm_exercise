public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=prices.length;
        if(l<2) return 0;
        int max=prices[0],min=prices[0], profit=0;
        int[] profits = new int[l];
        
        for(int i=0;i<l;i++){
            if(prices[i]>max){
                max = prices[i];
                profits[i] = max-min;
            }
            else if(prices[i]<min){
                min = prices[i];
                max = min;
            }
            if(i>0) profits[i] = Math.max(profits[i],profits[i-1]);
        }
        
        max=prices[l-1];
        min=prices[l-1];
        for(int i=l-1;i>-1;i--){
            if(prices[i]<min){
                min = prices[i];
                profits[i] += max-min;
            }
            else if(prices[i]>max){
                max = prices[i];
                min = max;
            }
            if(i<l-1) profits[i] = Math.max(profits[i],profits[i+1]);
            if(profit<profits[i]) profit = profits[i];
        }
        
        return profit;
    }
}

