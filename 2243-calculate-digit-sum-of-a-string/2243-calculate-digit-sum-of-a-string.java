class Solution {
    public String digitSum(String s, int k) {
        return helper(new StringBuilder(s),k);
    }
    public String helper(StringBuilder s,int k){
        if(s.length()<=k)return s.toString();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i+=k){
            if(i+k<s.length())str.append(sumofDigit(new StringBuilder(s.substring(i,i+k))));
            else str.append(sumofDigit(new StringBuilder(s.substring(i,s.length()))));
        }
        if(str.length()>k)return helper(str,k);
        return str.toString();
    }
    public String sumofDigit(StringBuilder s){
        int sum=0;
        for(char cur:s.toString().toCharArray()){
            sum+=cur-'0';
        }
        return sum+"";
    }
}