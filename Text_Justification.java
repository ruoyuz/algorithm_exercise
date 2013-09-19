public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l = words.length;
        int i = 0, currentL=0, n=0;
        Queue<String> q = new LinkedList<String>();
        ArrayList<String> result = new ArrayList<String>();
        
        while(i<l){
            String word = words[i];
            if(q.isEmpty()){
                q.add(word);
                currentL += word.length();
                n++;
                i++;
            }
            else{
                if(currentL+word.length()+n<=L){
                    q.add(word);
                    currentL += word.length();
                    n++;
                    i++;
                }
                else{
                    if(n==1){
                        String w = q.remove();
                        for(int j=0;j<L-currentL;j++) w+=" ";
                        result.add(w);
                        currentL=0;
                        n=0;
                    }
                    else{
                        int normal = (L-currentL)/(n-1);
                        int addition = (L-currentL)%(n-1);
                        String line = "";
                        for(int j=0;j<n-1;j++){
                            line += q.remove();
                            for(int k=0;k<normal;k++) line+=" ";
                            if(j<addition) line+=" ";
                        }
                        line += q.remove();
                        result.add(line);
                        currentL=0;
                        n=0;
                    }
                }
            }
        }
        if(!q.isEmpty()){
            String line = "";
            for(int j=0;j<n-1;j++) line+=q.remove()+" ";
            line+=q.remove();
            for(int j=0;j<L-currentL-(n-1);j++) line+=" ";
            result.add(line);
        }
        return result;
    }
}
