import java.util.*;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> positions = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        boolean found = false;

        
        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }


        for (List<Integer> indices : positions.values()) {
            if (indices.size() >= 3) {
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int a = indices.get(i);
                    int b = indices.get(i+1);
                    int c = indices.get(i+2);
                    int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    if (dist < minDist) {
                        minDist = dist;
                        found = true;
                    }
                }
            }
        }

        return found ? minDist : -1;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 1, 1, 3};
        System.out.println(sol.minimumDistance(nums)); 
    }
}