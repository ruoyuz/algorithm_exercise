public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=s.length();
        if(l<1) return false;
        
        int a=0,b=l-1;
        while(a<=b){
            if(s.charAt(a)==' ') a++;
            else if(s.charAt(b)==' ') b--;
            else break;
        }
        
        boolean num1=false,num2=false,dot=false,exp=false,sign1=false,sign2=false;
        for(int i=a;i<=b;i++){
            char c = s.charAt(i);    
            if(exp){
                if(c=='.'||c=='e') return false;
                else if(isNum(c)) num2 = true;
                else if(c=='+'||c=='-'){
                    if(!num2&&!sign2) sign2=true;
                    else return false;
                }
                else return false;
            }
            else{
                if(isNum(c)) num1 = true;
                else if(c=='+'||c=='-'){
                    if(num1||dot||sign1) return false;
                    else sign1 = true;
                }
                else if(c=='.'){
                    if(dot) return false;
                    else dot = true;
                }
                else if(c=='e') exp = true;
                else return false;
            }
        }
        if(num1){
            if((exp&&num2)||(!exp&&!num2)) return true;
        }
        return false;
    }
    
    public boolean isNum(char c){
        char[] table = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        for(int i=0;i<10;i++){
            if(c==table[i]) return true;
        }
        return false;
    }
}
