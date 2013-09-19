public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Double> Map = new HashMap<Integer,Double>();
        return pow2(x,n,Map);
    }
    
    public double pow2(double x, int n, HashMap<Integer,Double> Map){
        if(n==0) return 1.0;
        if(x==0.0) return 0.0;
        if(n==1) return x;
        if(n==-1) return 1/x;
        
        if(Map.containsKey(n)) return Map.get(n);
        else{
            double r = pow2(x,n/2,Map)*pow2(x,n/2,Map)*pow2(x,n%2,Map);
            Map.put(n,r);
            return r;
        }
    }
}
