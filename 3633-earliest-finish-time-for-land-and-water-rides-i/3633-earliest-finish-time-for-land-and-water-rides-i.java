class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m=landStartTime.length;
        int n=waterStartTime.length;
        
        int minl=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minl=Math.min(minl,landStartTime[i]+landDuration[i]);
        }
        
        int minw=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minw=Math.min(minw,waterStartTime[i]+waterDuration[i]);
        }
        
        int ans=Integer.MAX_VALUE;
        
        for(int j=0;j<n;j++){
            int totalTime=Math.max(minl,waterStartTime[j])+waterDuration[j];
            ans=Math.min(ans,totalTime);
        }
        
        for(int i=0;i<m;i++){
            int totalTime=Math.max(minw,landStartTime[i])+landDuration[i];
            ans=Math.min(ans,totalTime);
        }
        
        return ans;
    }
}