import java.util.*;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
    
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDistance = Integer.MAX_VALUE;
        
        for (List<Integer> positions : map.values()) {
            if (positions.size() >= 3) {
                for (int i = 0; i <= positions.size() - 3; i++) {
                    int a = positions.get(i);
                    int b = positions.get(i + 1);
                    int c = positions.get(i + 2);
                    int distance = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}