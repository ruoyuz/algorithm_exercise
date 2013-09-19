public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows<=0) return "";
        if(nRows==1) return s;
        StringBuilder result = new StringBuilder();
        int len=s.length();
        for(int i=0; i<len; i+=(nRows-1)*2){
            result.append(s.charAt(i));
        }
        for(int n=2; n<nRows; n++){
            for(int i=n-1; i<len; i+=(nRows-1)*2){
                result.append(s.charAt(i));
                int j = i+(nRows-n)*2;
                if(j<len) result.append(s.charAt(j));
            }
        }
        for(int i=nRows-1; i<len; i+=(nRows-1)*2){
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
