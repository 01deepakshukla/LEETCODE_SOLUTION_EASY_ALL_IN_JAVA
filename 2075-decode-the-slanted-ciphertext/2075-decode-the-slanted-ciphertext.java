import java.util.*;

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        if (n == 0) return "";

        int cols = n / rows;
        StringBuilder ans = new StringBuilder();
        Map<Integer, List<Character>> map = new TreeMap<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Only take valid diagonal cells
                if (col >= row) {
                    int key = col - row;

                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(encodedText.charAt(row * cols + col));
                }
            }
        }

        // Build result from diagonals
        for (List<Character> list : map.values()) {
            for (char ch : list) {
                ans.append(ch);
            }
        }

        // Remove trailing spaces
        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.toString();
    }
}

