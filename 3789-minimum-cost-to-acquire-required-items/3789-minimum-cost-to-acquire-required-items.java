class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long ans = Long.MAX_VALUE;

        int[] choices = {
            0,
            Math.min(need1, need2),
            need1,
            need2
        };

        for (int x : choices) {
            long cost = 0;
            cost += (long) x * costBoth;
            cost += (long) Math.max(0, need1 - x) * cost1;
            cost += (long) Math.max(0, need2 - x) * cost2;
            ans = Math.min(ans, cost);
        }

        return ans;
    }
}