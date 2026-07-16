class Solution {
    int gcd(int a, int b) {
        if( b == 0) return a; 
        return gcd(b, a % b); 
    }
    public long gcdSum(int[] nums) {
        int n = nums.length; 
        int[] pref = new int[n]; 
        int mx = 0; 
        for(int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]); 
            pref[i] = gcd(mx, nums[i]); 
        }

        Arrays.sort(pref); 
        int l = 0, r = n - 1; 
        long ans = 0; 
        while(l < r) {
            ans += (long)gcd(pref[l++], pref[r--]); 
        }
        return ans; 
    }
}