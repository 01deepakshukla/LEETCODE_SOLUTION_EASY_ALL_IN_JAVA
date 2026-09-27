class Solution {

    public String reverseParentheses(String s) {

        int n = s.length();

        // Store the matching parenthesis for each parenthesis.
        int[] link = new int[n];

        Stack<Integer> stk = new Stack<>();

        // Match opening and closing parentheses.
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                stk.push(i);

            } else if (s.charAt(i) == ')') {

                link[i] = stk.pop();
                link[link[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        // Traverse the string.
        // dir = 1  -> move forward
        // dir = -1 -> move backward
        for (int i = 0, dir = 1; i < n; i += dir) {

            if (s.charAt(i) >= 'a') {

                // Append normal characters.
                sb.append(s.charAt(i));

            } else {

                // Jump to the matching parenthesis
                // and reverse the traversal direction.
                i = link[i];
                dir = -dir;
            }
        }

        return sb.toString();
    }
}