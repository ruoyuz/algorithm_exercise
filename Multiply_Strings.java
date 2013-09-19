public class Solution {
    public String multiply(String num1, String num2) {
        int l1=num1.length(), l2=num2.length();
        if(l1<1 || l2<1) return "";
        
        if(l1<l2) return multiply(num2, num1);
        
        String result="0", temp, zeros="";
        for(int i=l2-1;i>=0;i--){
            int n = (int) num2.charAt(i) - 48;
            temp = mult(num1,n);
            temp += zeros;
            result = add(result, temp);
            zeros += "0";
        }
        return result;
    }
    
    public String mult(String num1, int num2) {
        String result="0";
        for(int i=0;i<num2;i++){
            result = add(result,num1);
        }
        return result;
    }
    
        
    public String add(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l1=num1.length(), l2=num2.length();
        if(l1<1 || l2<1) return "";
        
        String result="";
        int p1=l1-1, p2=l2-1, i=0, carry=0;
        while(p1>=0&&p2>=0){
            i = ((int) num1.charAt(p1) + (int) num2.charAt(p2) + carry -96)%10;
            carry = ((int) num1.charAt(p1) + (int) num2.charAt(p2) + carry -96)/10;
            result = i+result;
            p1--;
            p2--;
        }
        while(p1>=0){
            i = ((int) num1.charAt(p1) + carry -48)%10;
            carry = ((int) num1.charAt(p1) + carry -48)/10;
            result = i+result;
            p1--;
        }
        while(p2>=0){
            i = ((int) num2.charAt(p2) + carry - 48)%10;
            carry = ((int) num2.charAt(p2) + carry - 48)/10;
            result = i+result;
            p2--;
        }
        if(carry!=0) result = carry+result;
        return result;
    }
}
