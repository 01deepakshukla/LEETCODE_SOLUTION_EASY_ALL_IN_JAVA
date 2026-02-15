class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carry) {
                    sb.insert(0, 1);
                    carry = false;
                } else
                    sb.insert(0, 0);
            } else if ((a.charAt(i) == '0' && b.charAt(j) == '1') || (a.charAt(i) == '1' && b.charAt(j) == '0')) {
                if (carry)
                    sb.insert(0, 0);
                else
                    sb.insert(0, 1);
            } else {
                if (carry)
                    sb.insert(0, 1);
                else {
                    sb.insert(0, 0);
                    carry = true;
                }
            }
            i--;
            j--;
        }
        if (j < 0) {
            if (carry) {
                while (i >= 0 && a.charAt(i) == '1') {
                    sb.insert(0, 0);
                    i--;
                }
                sb.insert(0, 1);
                i--;
            }
            while (i >= 0)
                sb.insert(0, a.charAt(i--));
        } else if (i < 0) {
            if (carry) {
                while (j >= 0 && b.charAt(j) == '1') {
                    sb.insert(0, 0);
                    j--;
                }
                sb.insert(0, 1);
                j--;
            }
            while (j >= 0)
                sb.insert(0, b.charAt(j--));
        }
        return sb.toString();
    }
}