public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int currentUnit = 0;
        int u, num = 0;
        for(int i = s.length()-1;i>=0;i--){
            u = decodeUnit(s.charAt(i));
            if(currentUnit>u) num -= u;
            else num+=u;
            currentUnit = u;
        }
        return num;
    }
    
    private static int decodeUnit(char c){
        switch(c){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }  
}
