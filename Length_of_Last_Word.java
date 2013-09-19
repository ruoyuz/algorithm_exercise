public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=s.length();
        int tail=l-1, head=tail;
        
        while(tail>=0&&s.charAt(tail)==' ') tail--;
        head = tail;
        while(head>=0&&s.charAt(head)!=' ') head--;
        
        return tail-head;
    }
}
