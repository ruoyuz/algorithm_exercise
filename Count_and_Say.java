public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "1";
        for(int i=1;i<n;i++){
            result=Next(result);
        }
        return result;
    }
    
    public String Next(String s){
        int l=s.length();
        int N=1, v=(int) s.charAt(0)-48, v0=v;
        String result="";
        for(int i=1;i<l;i++){
            v = (int) s.charAt(i)-48;
            if(v==v0) N++;
            else{
                result += N;
                result += v0;
                v0=v;
                N=1;
            }
        }
        result += N;
        result += v;
        return result;
    }
}
