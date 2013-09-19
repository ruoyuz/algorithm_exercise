public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
            m*=i;
        }

        return getPerm(n,k-1,m,list);
    }
    
    public String getPerm(int n, int k, int m, ArrayList<Integer> list){
        StringBuilder s = new StringBuilder();
        if(n==1) return ""+list.get(0);
        s.append(list.get(k/(m/n)));
        list.remove(k/(m/n));
        s.append(getPerm(n-1,k%(m/n),m/n,list));
        return s.toString();
    }
}
