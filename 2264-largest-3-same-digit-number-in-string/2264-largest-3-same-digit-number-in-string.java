public class Solution {
    public String largestGoodInteger(String num) {
        String ans = ""; // Initialize an empty string to store the result
        String empty = ""; // Initialize an empty string for a special case
        int temp = 0; // Initialize a variable to store the largest digit found
        boolean check = true; // Initialize a flag to check for a specific condition

        // Loop through the string to find the largest digit occurring thrice consecutively
        for (int i = 0; i < num.length() - 2; i++) {
            // Check if the current digit is the same as the next two digits
            if (i + 2 < num.length() && num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                // Convert the character digit to its integer equivalent and update 'temp'
                temp = Math.max(temp, num.charAt(i) - '0');
                check = false; // Update the flag to indicate the condition was met
            }
        }

        // If the condition was met (i.e., a triplet was found)
        if (!check) {
            // Append the largest digit found three times to the 'ans' string
            for (int i = 0; i < 3; i++) {
                ans += temp;
            }
        } else { // If no such triplet found
            return empty; // Return the empty string
        }

        return ans; // Return the result containing the largest good integer
    } 
}