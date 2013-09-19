public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length<2) return;
        int tail=num.length-1, head=tail;
        while(head>0){
            if(num[head-1]<num[head]) break;
            head--;
        }
        if(head>0){
            int k = nextIndex(num, head, tail);
            exch(num, head-1, k);
        }
        partSort(num, head, tail);
    }
    
    public void partSort(int[] a, int i, int j){
        int[] b = new int[j-i+1];
        for(int k=0;k<b.length;k++){
            b[k] = a[i+k];
        }
        Arrays.sort(b);
        for(int k=0;k<b.length;k++){
            a[i+k] = b[k];
        }
    }
    
    public void exch(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public int nextIndex(int[] a, int i, int j){
        partSort(a,i,j);
        for(int s=i;s<=j;s++){
            if(a[s]>a[i-1]) return s;
        }
        return i-1;
    }
}
