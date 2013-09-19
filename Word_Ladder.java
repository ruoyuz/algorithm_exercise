public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = start.length();
        dict.add(start);
        dict.add(end);
        HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
        for(String word:dict){
            HashSet<String> set = new HashSet<String>();
            for(int i=0;i<l;i++){
                for(char c='a';c<='z';c++){
                    if(c!=word.charAt(i)){
                        String newWord = replaceChar(word,c,i);
                        if(dict.contains(newWord)) set.add(newWord);
                    }
                }
            }
            map.put(word,set);
        }
        
        Queue<String> startQ = new LinkedList<String>();
        startQ.add(start);
        Queue<String> endQ = new LinkedList<String>();
        endQ.add(end);
        
        int startL = 1;
        int endL = 0;
        
        HashSet<String> startV = new HashSet<String>();
        HashSet<String> endV = new HashSet<String>();
        
        startV.add(start);
        endV.add(end);
        
        while(true){
            HashSet<String> newSQ = new HashSet<String>();
            HashSet<String> newEQ = new HashSet<String>();
            
            while(!startQ.isEmpty()){
                String word = startQ.remove();
                if(endV.contains(word)) return startL+endL;
                for(String nextWord:map.get(word)){
                    if(!startV.contains(nextWord)&&!newSQ.contains(nextWord)){
                        newSQ.add(nextWord);
                        startV.add(nextWord);
                    }
                }
            }
            startL++;
            
            while(!endQ.isEmpty()){
                String word = endQ.remove();
                if(startV.contains(word)) return startL+endL;
                for(String nextWord:map.get(word)){
                    if(!endV.contains(nextWord)&&!newEQ.contains(nextWord)){
                        newEQ.add(nextWord);
                        endV.add(nextWord);
                    }
                }
            }
            endL++;
            
            startQ = new LinkedList<String>(newSQ);
            endQ = new LinkedList<String>(newEQ);

            if(startL+endL>dict.size()) break;
        }
        return 0;
    }
    
    public String replaceChar(String s, char c, int i){
        char[] ch = s.toCharArray();
        ch[i] = c;
        return new String(ch);
    }
}
