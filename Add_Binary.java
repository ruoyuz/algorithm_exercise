public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=a.length(), n=b.length();
        if(m<n) return addBinary(b,a);
        StringBuilder r = new StringBuilder();
        char carry = '0';
        
        for(int i=n-1;i>=0;i--){
            if(a.charAt(i+m-n)==b.charAt(i)){
                r.insert(0,carry);
                carry='0';
                if(b.charAt(i)=='1') carry='1';
            }
            else{
                if(carry=='0') r.insert(0,'1');
                else r.insert(0,'0');
            }
        }
        for(int i=m-n-1;i>=0;i--){
            if(carry=='0') r.insert(0,a.charAt(i));
            else{
                if(a.charAt(i)=='1') r.insert(0,'0');
                else {
                    r.insert(0,'1');
                    carry='0';
                }
            }
        }
        if(carry=='1') r.insert(0,'1');
        return r.toString();
    }
}
