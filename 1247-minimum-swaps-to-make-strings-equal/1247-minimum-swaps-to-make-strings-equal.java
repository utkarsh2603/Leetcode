class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
		// validate the input
        if (n != m) {
            return -1;
        }
        
        int xmis = 0;  // mismatch where s1[i] has 'x'
        int ymis = 0;  // mismatch where s1[i] has 'y'
        
		// count mismatches
        for (int i = n-1; i >= 0; i--) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xmis++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                ymis++;
            }
        }
        
		// impossible
		// (1) there should be even numbers of those types of exchanges, in which the first strategy suffices. OR
		// (2) there should be odd numbers of those types of exchanges, in which we apply the fisrt strategy
		// then we apply the second strategy to finish things off
        if (xmis % 2 != ymis % 2) {
            return -1;
        }
        
        int ans = xmis / 2 + ymis / 2; // apply the first strategy
        if (xmis % 2 == 1) {
            ans += 2; // if a mismatch remains, we apply the second strategy
        }
        
        return ans;
    }
}