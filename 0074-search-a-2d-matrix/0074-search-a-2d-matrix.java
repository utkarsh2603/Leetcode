class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binaryRows(matrix, target, 0, matrix.length-1);
    }
    public boolean binaryRows(int[][] matrix, int target, int start_r, int end_r) {
        int mid_r = start_r + (end_r - start_r) / 2;
        if(start_r > end_r) return false;
        if(binary(matrix[mid_r], target, 0, matrix[0].length-1)) return true;
        else if(matrix[mid_r][0] > target)
            return binaryRows(matrix, target, start_r, mid_r - 1);
        else return binaryRows(matrix, target, mid_r + 1, end_r);
    }
    public boolean binary(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if(start > end) return false;
        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return binary(arr, target, start, mid - 1);
        else return binary(arr, target, mid + 1, end);
    }
}