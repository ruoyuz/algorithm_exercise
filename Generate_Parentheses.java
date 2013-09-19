public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> r1 = new ArrayList<String>();
        r1.add("");
        for(int i=0; i<n; i++){
            ArrayList<String> r2 = new ArrayList<String>();
            for(String s:r1){
                for(int j=0;j<=s.length();j++){
                    StringBuilder sb = new StringBuilder(s);
                    sb.insert(j,"()");
                    String sbs = sb.toString();
                    if(!r2.contains(sbs)) r2.add(sbs);
                }
            }
            r1 = r2;
        }
        return r1;
    }
}
