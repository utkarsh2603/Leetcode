public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int size = nums.length; // Number of binary strings in the input array

        // Sort the input array in lexicographical order
        Arrays.sort(nums);

        int pointer = 0; // Pointer to track the expected decimal value for the next binary string

        // Iterate through the sorted binary strings
        for (int i = 0; i < size; ++i) {
            // Convert the current binary string to decimal
            long decimalValue = Long.parseLong(nums[i], 2);

            // Check if the decimal value matches the expected value
            if (decimalValue == pointer)
                pointer++;
            else
                // If not, return the binary representation of the expected value with appropriate length
                return String.format("%" + size + "s", Long.toBinaryString(pointer)).replace(' ', '0');
        }

        // If no unique binary string is found, return the binary representation of the next expected value
        return String.format("%" + size + "s", Long.toBinaryString(pointer)).replace(' ', '0');
    }
}