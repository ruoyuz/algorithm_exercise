public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(l<3) return result;
        Arrays.sort(num);
        for(int i=0;i<l-2;i++){
            ArrayList<ArrayList<Integer>> list = twoSum(num,0-num[i],i);
            if(num[i]<=0){
                for(ArrayList<Integer> li:list){
                    li.add(0,num[i]);
                    if(!result.contains(li)) result.add(li);
                }
            }
        }
	return result;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int[] sortedNum, int target, int i){
        int l=sortedNum.length;
        int a=i+1, b=l-1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        while(a<b){
            if(sortedNum[a]>target) return list;
            if(sortedNum[a]+sortedNum[b]>target) b--;
            else if(sortedNum[a]+sortedNum[b]<target) a++;
            else{
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(sortedNum[a++]);
                li.add(sortedNum[b--]);
                list.add(li);
            }
	}
	return list;
    }
}

