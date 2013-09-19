/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        intervals.add(newInterval);
        return merge(intervals);
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = intervals.size();
        int[] left = new int[n];
        int[] right = new int[n];
        
        int i=0;
        for(Interval intv : intervals){
            left[i]=intv.start;
            right[i]=intv.end;
            i++;
        }
        
        Arrays.sort(left);
        Arrays.sort(right);
        
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        int a=0,b=0,l=0,r=0;
        while(a<n||b<n){
            if(a<n && left[a]<=right[b]) stack.push(left[a++]);
            else if(b<n && (a==n||right[b]<left[a])) {
                l=stack.pop();
                r=right[b];
                b++;
            }
            if(stack.isEmpty()) result.add(new Interval(l,r));
        }
        return result;
    }
}
