class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Initialize an array of count with the size 26...
        int[] counter = new int[128];
        // Traverse a loop through the entire String of magazine where char ch stores the char at the index of magazine...
        for (final char ch : magazine.toCharArray())
            ++counter[ch];
        // Run another for loop for ransomNote...
        for (final char ch : ransomNote.toCharArray())
             // If the charachter doesn't exists in magazine for ransomNote, we return false...
            if (--counter[ch] < 0)
                return false;
        return true;      // If nothing goes wrong, return true...
    }
}