import java.util.*;

class Solution {
    public static int has1(String s, int n) {
        int cnt = 1, len = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                cnt = Math.max(cnt, len);
                len = 1;
            }
        }
        return Math.max(cnt, len);
    }

    static final long bias = 1L << 18;
    static final int shift = 32;

    // Pack two integers into one long key
    static long pack(int x, int y) {
        return ((long) (x + bias) << shift) | (long) (y + bias);
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int ans = has1(s, n);

        Map<Long, Integer> ab = new HashMap<>(n);
        Map<Long, Integer> bc = new HashMap<>(n);
        Map<Long, Integer> ca = new HashMap<>(n);
        Map<Long, Integer> abc = new HashMap<>(n);

        // Initial state: index -1
        abc.put(pack(0, 0), -1);
        ab.put(pack(0, 0), -1); // (A-B, C)
        bc.put(pack(0, 0), -1); // (B-C, A)
        ca.put(pack(0, 0), -1); // (C-A, B)

        int[] cnt = new int[3]; // counts of 'a','b','c'

        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            int A = cnt[0], B = cnt[1], C = cnt[2];

            // 3-letter balance: A = B = C
            long key = pack(B - A, C - A);
            if (abc.containsKey(key)) {
                ans = Math.max(ans, i - abc.get(key));
            } else {
                abc.put(key, i);
            }

            // 2-letter balance: A = B and NO C
            key = pack(A - B, C);
            if (ab.containsKey(key)) {
                ans = Math.max(ans, i - ab.get(key));
            } else {
                ab.put(key, i);
            }

            // 2-letter balance: B = C and NO A
            key = pack(B - C, A);
            if (bc.containsKey(key)) {
                ans = Math.max(ans, i - bc.get(key));
            } else {
                bc.put(key, i);
            }

            // 2-letter balance: C = A and NO B
            key = pack(C - A, B);
            if (ca.containsKey(key)) {
                ans = Math.max(ans, i - ca.get(key));
            } else {
                ca.put(key, i);
            }
        }

        return ans;
    }
}