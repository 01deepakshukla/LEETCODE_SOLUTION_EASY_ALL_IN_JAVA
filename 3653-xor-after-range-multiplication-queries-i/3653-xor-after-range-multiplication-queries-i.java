class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int M = 1_000_000_007;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int idx = l; idx <= r; idx += k) {
                long val = (1L * nums[idx] * v) % M;
                nums[idx] = (int) val;
            }
        }

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}