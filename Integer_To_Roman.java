public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=num;
        StringBuilder s = new StringBuilder();
        while(!(n-1000<0)) {s.append("M");n-=1000;}
        while(!(n-900<0)) {s.append("CM");n-=900;}
        while(!(n-500<0)) {s.append("D");n-=500;}
        while(!(n-400<0)) {s.append("CD");n-=400;}
        while(!(n-100<0)) {s.append("C");n-=100;}
        while(!(n-90<0)) {s.append("XC");n-=90;}
        while(!(n-50<0)) {s.append("L");n-=50;}
        while(!(n-40<0)) {s.append("XL");n-=40;}
        while(!(n-10<0)) {s.append("X");n-=10;}
        while(!(n-9<0)) {s.append("IX");n-=9;}
        while(!(n-5<0)) {s.append("V");n-=5;}
        while(!(n-4<0)) {s.append("IV");n-=4;}
        while(!(n-1<0)) {s.append("I");n-=1;}
        return s.toString();
    }
}
