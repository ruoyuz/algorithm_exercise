public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=prices.length;
        if(l<2) return 0;
        int profit=0, buy=0;
        boolean hold = false;
        
        for(int i=0;i<l;i++){
            if(i<l-1&&!hold&&prices[i]<prices[i+1]){
                hold = true;
                buy = prices[i];
            }
            else if(hold&&(i<l-1&&(prices[i]>prices[i+1])||(i==l-1&&prices[l-1]>buy))){
                hold = false;
                profit += prices[i]-buy;
            }
        }
        return profit;
    }
}


