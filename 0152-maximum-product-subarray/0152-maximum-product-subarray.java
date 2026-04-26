class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0],mn=nums[0],mx=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<0) {
                int t=mx;
                mx=mn;
                mn=t;
            }
            mx=Math.max(nums[i],mx*nums[i]);
            mn=Math.min(nums[i],mn*nums[i]);
            ans=Math.max(ans,mx);
        }
        return ans;
    }
}