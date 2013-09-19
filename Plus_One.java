public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = digits.length;
        if(!plusNext(digits,l-1)) return digits;
        else{
            int[] result = new int[l+1];
            result[0] = 1;
            return result;
        }
    }
    
    public boolean plusNext(int[] a, int i){
        int l = a.length;
        if(i<0) return true;
        if(a[i]<9){
            a[i] += 1;
            return false;
        }
        else{
            a[i] = 0;
            return plusNext(a,i-1);
        }
    }
}
