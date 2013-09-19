public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean m=false;
        int l = digits.length();
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        for(int i=0 ;i<l; i++){
            char c = digits.charAt(i);
            if(c=='#') m=!m;
            else{
                char[] map = letterMap(c,m);
                ArrayList<String> r2 = new ArrayList<String>();
                for(char j:map){
                    for(String s:result) r2.add(s+j);
                }
                result = r2;
                m = false;
            }
        }
        return result;
    }
    
    public static char[] letterMap(char i, boolean m){
        char[] result;
        switch(i){
            case '1':
                result = new char[] {i};
                return result;
            case '2':
                result = new char[] {'a','b','c'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '3':
                result = new char[] {'d','e','f'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '4':
                result = new char[] {'g','h','i'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '5':
                result = new char[] {'j','k','l'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '6':
                result = new char[] {'m','n','o'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '7':
                result = new char[] {'p','q','r','s'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '8':
                result = new char[] {'t','u','v'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '9':
                result = new char[] {'w','x','y','z'};
                if(m) for(int j=0; j<result.length;j++) result[j]-=32;
                return result;
            case '0':
                result = new char[] {' '};
                return result;
            case '*':
                result = new char[] {'+'};
                return result;
            default:
                result = new char[] {i};
                return result;
        }
    }
}
