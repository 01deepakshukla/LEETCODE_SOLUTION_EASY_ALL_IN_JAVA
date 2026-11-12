class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int decreasing = 1;
        int increasing = 1;

        int decMax = 1;
        int incMax = 1;

        for(int i = 1; i < nums.length; ++i) {
            // 🔴 Track the strictly decreasing subarray
            if(nums[i - 1] > nums[i]) {
                decreasing++;
                decMax = Math.max(decMax, decreasing);
            }
            else {
                decreasing = 1;
            }

            // 🟢 Track the strictly increasing subarray
            if(nums[i - 1] < nums[i]) {
                increasing++;
                incMax = Math.max(incMax, increasing);
            }
            else {
                increasing = 1;
            }
        }

        return Math.max(incMax, decMax);
    }
}