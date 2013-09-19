public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> stack = new Stack<String>();

        int i=0, j=0;
        while(i<=j&&j<=path.length()){
            if(j==path.length()){
                String s = path.substring(i,j)+"/";
                if(!s.equals("/")&&!s.equals("./")){
                    if(s.equals("../")){
                        if(!stack.isEmpty()) stack.pop();
                    }
                    else{
                        stack.push(s);
                    }
                }
                break;
            }
            else{
                char ci = path.charAt(i);
                char cj = path.charAt(j);
                if(cj=='/'){
                    j++;
                    String s = path.substring(i,j);
                    if(!s.equals("/")&&!s.equals("./")){
                        if(s.equals("../")){
                            if(!stack.isEmpty()) stack.pop();
                        }
                        else{
                            stack.push(s);
                        }
                    }
                    i=j;
                    if(j==path.length()) break;
                }
                else j++;
            }
        }

        String result = "";
        while(!stack.isEmpty()) result = stack.pop()+result;
        result = "/" + result;
        return result.length()==1?result:result.substring(0,result.length()-1);
    }
}
