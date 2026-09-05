class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] maxPrev = new int[nums.length];
        int[] minNext = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxPrev[i] = i > 0
                    ? Math.max(maxPrev[i - 1], nums[i])
                    : nums[i];

            minNext[nums.length - i - 1] = i > 0
                    ? Math.min(minNext[nums.length - i],
                               nums[nums.length - i - 1])
                    : nums[nums.length - i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxPrev[i] - minNext[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}

