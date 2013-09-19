public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        if(l3!=l1+l2) return false;
        //if(l1==0&&s2.equals(s3)||l2==0&&s1.equals(s3)) return true;
        HashMap<Integer[],Boolean> map = new HashMap<Integer[],Boolean>();
        return checkInterleave(s1,s2,s3,0,0,map);
    }
    
    public boolean checkInterleave(String s1, String s2, String s3, int i, int j, HashMap<Integer[],Boolean> map){
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        int k=i+j;
        
        if(map.containsKey(new Integer[]{i,j})) return map.get(new Integer[]{i,j});
        
        while(k<l3){
            if(i<l1&&j<l2&&s1.charAt(i)==s2.charAt(j)&&s1.charAt(i)==s3.charAt(k)){
                return checkInterleave(s1,s2,s3,i+1,j,map)||checkInterleave(s1,s2,s3,i,j+1,map);
            }
            else if(i<l1&&s1.charAt(i)==s3.charAt(k)) return checkInterleave(s1,s2,s3,i+1,j,map);
            else if(j<l2&&s2.charAt(j)==s3.charAt(k)) return checkInterleave(s1,s2,s3,i,j+1,map);
            else{
                map.put(new Integer[]{i,j},false);
                return false;
            }
        }
        map.put(new Integer[]{i,j},true);
        return true;
    }
}
