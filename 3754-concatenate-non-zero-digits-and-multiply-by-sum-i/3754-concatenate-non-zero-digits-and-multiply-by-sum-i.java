class Solution {
    public long sumAndMultiply(int n) {
        if(n<=0)return 0;
        int sum=0;
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int rem=n%10;
            if(rem==0){
                n/=10;
                continue;
            }
            sb.append(rem);
            sum+=rem;
            n/=10;
        }
        return Long.parseLong(sb.reverse().toString())*sum;
    }
}