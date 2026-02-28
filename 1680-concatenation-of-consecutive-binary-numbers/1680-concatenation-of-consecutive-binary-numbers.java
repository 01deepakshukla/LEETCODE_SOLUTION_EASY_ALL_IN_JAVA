class Solution {
    private int calVal(String s){
        int mod=1000000007;
        int ans=0;
        int pos=0;
        for(int i=0;i<s.length();i++){
            ans = (ans * 2 + (s.charAt(i) - '0')) % mod;
        }
        System.out.println(ans);
        return ans;
    }
    public int concatenatedBinary(int n) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            String s=Integer.toBinaryString(i);
            sb.append(s);
        }
        int val=calVal(sb.toString());
        return val;
    }
}