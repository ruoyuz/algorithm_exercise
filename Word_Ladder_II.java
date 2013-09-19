public class Solution {
     public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(start.equals(end)){
            ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
            ArrayList<String> list = new ArrayList<String>();
            list.add(start);
            ret.add(list);
            return ret;
        }
        
        dict.add(start);
        dict.add(end);
        int l = start.length(), sizeL=dict.size();
        /*
        HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
        for(String word:dict){
            if(word.equals(end)) continue;
            HashSet<String> set = new HashSet<String>();
            for(String newWord:getWords(word)){
                if(dict.contains(newWord)) set.add(newWord);
            }
            map.put(word,set);
        }
        */
        
        HashMap<String, HashSet<String>> next = new HashMap<String, HashSet<String>>();
        HashMap<String, HashSet<String>> current = new HashMap<String, HashSet<String>>();
        HashMap<String, HashSet<String>> storage = new HashMap<String, HashSet<String>>();
        
        current.put(start,null);
        
        while(!current.isEmpty()){
            for(String word:current.keySet()){
                if(!dict.contains(word)) continue;
                for(String nextWord:buildSet(word,dict)){
                    if(current.containsKey(nextWord)) continue;
                    if(next.containsKey(nextWord)){
                        HashSet<String> set = next.get(nextWord);
                        set.add(word);
                        next.put(nextWord,set);
                    }
                    else{
                        HashSet<String> set = new HashSet<String>();
                        set.add(word);
                        next.put(nextWord,set);
                    }
                }
            }
            
            for(String word:current.keySet()){
                if(dict.contains(word)) dict.remove(word);
            }
            
            storage.putAll(current);
            if(storage.containsKey(end)) break;
            current = next;
            next = new HashMap<String, HashSet<String>>();
        }
        
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        buildPath(end, storage, list, result);
        return result;
    }
    
    public static void buildPath(String tail, HashMap<String, HashSet<String>> current, ArrayList<String> list, ArrayList<ArrayList<String>> result){
        if(!current.containsKey(tail)) return;
        list.add(0,tail);
        if(current.get(tail)==null) result.add(new ArrayList<String>(list));
        else{
            for(String s:current.get(tail)){
                buildPath(s,current,list,result);
            }
        }
        list.remove(0);
        return;
    }

    public static ArrayList<String> getWords(String s){
        char[] ch = s.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            char c = ch[i];
            for(char a='a';a<='z';a++){
                if(a==c) continue;
                ch[i] = a;
                result.add(new String(ch));
            }
            ch[i] = c;
        }
    return result;
    }
    
    public static HashSet<String> buildSet(String word, HashSet<String> dict){
        HashSet<String> set = new HashSet<String>();
        for(String newWord:getWords(word)){
            if(dict.contains(newWord)) set.add(newWord);
        }
        return set;
    }
}



