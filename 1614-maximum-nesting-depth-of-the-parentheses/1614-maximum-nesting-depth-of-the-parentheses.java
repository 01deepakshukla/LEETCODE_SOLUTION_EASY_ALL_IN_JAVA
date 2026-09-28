class Solution {
    public int maxDepth(String s) {
        int max=0;
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')stack.push(c);
            else if(c==')')stack.pop();
            if(max<stack.size())max=stack.size();
        }
        return max;
    }
}