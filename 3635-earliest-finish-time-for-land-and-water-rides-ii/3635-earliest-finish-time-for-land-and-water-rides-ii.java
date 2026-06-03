class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        // Earliest finishing time among all land rides
        int minLengthLand = Integer.MAX_VALUE;

        // Minimum total finish time for Land -> Water order
        int minTotalLand = Integer.MAX_VALUE;

        // Find the earliest land ride completion time
        for (int i = 0; i < landStartTime.length; i++) {
            minLengthLand = Math.min(
                minLengthLand,
                landStartTime[i] + landDuration[i]
            );
        }

        // Try taking each water ride after the earliest land ride
        for (int i = 0; i < waterStartTime.length; i++) {

            // Water ride can start only after both:
            // 1. Water ride is available
            // 2. Land ride has finished
            int start = Math.max(waterStartTime[i], minLengthLand);

            // Update minimum finish time
            minTotalLand = Math.min(
                minTotalLand,
                start + waterDuration[i]
            );
        }

        // Earliest finishing time among all water rides
        int minLengthWater = Integer.MAX_VALUE;

        // Minimum total finish time for Water -> Land order
        int minTotalWater = Integer.MAX_VALUE;

        // Find the earliest water ride completion time
        for (int i = 0; i < waterStartTime.length; i++) {
            minLengthWater = Math.min(
                minLengthWater,
                waterStartTime[i] + waterDuration[i]
            );
        }

        // Try taking each land ride after the earliest water ride
        for (int i = 0; i < landStartTime.length; i++) {

            // Land ride can start only after both:
            // 1. Land ride is available
            // 2. Water ride has finished
            int start = Math.max(landStartTime[i], minLengthWater);

            // Update minimum finish time
            minTotalWater = Math.min(
                minTotalWater,
                start + landDuration[i]
            );
        }

        // Return the best result among both orders
        return Math.min(minTotalLand, minTotalWater);
    }
}