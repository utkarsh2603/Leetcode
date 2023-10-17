import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        StringBuilder st = new StringBuilder();
        char[] arr = s.toCharArray();

        if (s.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i]) || (i == 0 && (arr[i] == '-' || arr[i] == '+'))) {
                st.append(arr[i]);
            } else {
                break;
            }
        }

        if (st.length() == 0 || (st.length() == 1 && (st.charAt(0) == '-' || st.charAt(0) == '+'))) {
            return 0;
        }

        BigInteger result = new BigInteger(st.toString());

        if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        } else if (result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }

        return result.intValue();
    }
}