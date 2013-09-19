public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = num.length;
        HashMap<Integer, Integer> map_up = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map_down = new HashMap<Integer, Integer>();
        for(int i=0;i<l;i++){
            int v = num[i];
            map_up.put(v,v);
            map_down.put(v,v);
        }
        
        for(int i=0;i<l;i++){
            int v = num[i];
            if(v!=Integer.MAX_VALUE&&map_up.containsKey(v+1)){
                map_up.put(v,map_up.get(v+1));
            }
            if(v!=Integer.MIN_VALUE&&map_down.containsKey(v-1)){
                map_down.put(v,map_down.get(v-1));
            }
        }
        
        int max = 0;
        for(int i=0;i<l;i++){
            int key = num[i];
            if(key==map_up.get(key)){
                int upper = key;
                int lower = key;
                while(lower!=map_down.get(lower)){
                    lower = map_down.get(lower);
                }
                max = Math.max(max,upper-lower+1);
            }
        }
        return max;
    }
}
