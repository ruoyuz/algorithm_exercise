/* Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 */

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        int[] index = new int[numbers.length];
        for(int x=0; x<numbers.length; x++){
            index[x] = x;
        }   
        mergeSort(numbers, index);
        for(int i=0; i<numbers.length; i++){
            int j=binarySearch(numbers, target-numbers[i]);
            if(j>-1){
                if(index[i]>index[j]){
                    result[0] = index[j]+1;
                    result[1] = index[i]+1;
                    return result;
                }
                else if(index[i]<index[j]){
                    result[0] = index[i]+1;
                    result[1] = index[j]+1;
                    return result;
                }
            }
        }
        return result;
    }
    
    public static void mergeSort(int[] array, int[] ind){
        int lo=0, hi=array.length-1;
        int[] aux = new int[array.length];
        int[] indAux = new int[array.length];
        mergeSort(array, aux, ind, indAux, lo, hi);
    }
    
    public static void mergeSort(int[] array, int[] aux, int[] ind, int[] indAux, int lo, int hi){
        if(hi<=lo) return;
        int mid = (lo+hi)/2;
        mergeSort(array, aux, ind, indAux, lo, mid);
        mergeSort(array, aux, ind, indAux, mid+1, hi);
        for(int x=lo; x<=hi; x++){
            aux[x] = array[x];
            indAux[x] = ind[x];
        }
        int i=lo, j=mid+1;
        for(int k=lo; k<=hi; k++){
            if(i>mid) {array[k]=aux[j]; ind[k]=indAux[j++];}
            else if(j>hi) {array[k]=aux[i]; ind[k]=indAux[i++];}
            else if(aux[i]<=aux[j]) {array[k]=aux[i]; ind[k]=indAux[i++];}
            else {array[k]=aux[j]; ind[k]=indAux[j++];}
        }
    }
    
    public static int binarySearch(int[] array, int t){
        int lo = 0;
        int hi = array.length;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(array[mid]>t) hi=mid;
            else if(array[mid]<t) lo = mid+1;
            else return mid;
        }
        return -1;
    }
}
