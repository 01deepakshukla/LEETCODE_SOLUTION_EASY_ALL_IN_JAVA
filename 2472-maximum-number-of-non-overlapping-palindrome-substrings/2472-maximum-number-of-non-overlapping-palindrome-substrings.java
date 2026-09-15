class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length(), result = 0, start = 0;
        for (int right = k - 1; right < n; right++) {
            int left = right - k + 1;
            if (left >= start && check(s, left, right)) {
                result++;
                start = right + 1;
                continue;
            }
            left = right - k;
            if (left >= start && check(s, left, right)) {
                result++;
                start = right + 1;
            }
        }
        return result;
    }
    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}