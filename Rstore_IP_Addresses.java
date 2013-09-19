public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();
        restore(s,0,3,new StringBuilder(),list);
        return list;
    }
    
    public void restore(String s, int i, int n, StringBuilder sb, ArrayList<String> list){
        int l=s.length();
        if(i>l||n<0) return;
        if(l-i<4&&n==0){
            if(!isValid(s.substring(i,l))) return;
            sb.append(s.substring(i,l));
            String ss = sb.toString();
            if(!list.contains(ss)) list.add(ss);
            return;
        }
        if(i+3<l&&isValid(s.substring(i,i+3))){
            StringBuilder nsb = new StringBuilder(sb);
            nsb.append(s.substring(i,i+3));
            nsb.append('.');
            restore(s,i+3,n-1,nsb,list);
        }
        if(i+2<l&&isValid(s.substring(i,i+2))){
            StringBuilder nsb = new StringBuilder(sb);
            nsb.append(s.substring(i,i+2));
            nsb.append('.');
            restore(s,i+2,n-1,nsb,list);
        }
        if(i+1<l&&isValid(s.substring(i,i+1))){
            StringBuilder nsb = new StringBuilder(sb);
            nsb.append(s.substring(i,i+1));
            nsb.append('.');
            restore(s,i+1,n-1,nsb,list);
        }
        return;
    }
    
    public boolean isValid(String s){
        int l=s.length();
        int n=Integer.parseInt(s);
        if(n>-1&&n<10&&l==1) return true;
        if(n>9&&n<100&&l==2) return true;
        if(n>99&&n<256&&l==3) return true;
        return false;
    }
}
