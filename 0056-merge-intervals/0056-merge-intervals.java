class Solution {

    public int[][] merge(int[][] intervals) {
        // array[i] will point to the largest interval containing i
        int[][] array = new int[10001][];

        // This will go down by 1 whenever we merge intervals.
        int numIntervals = intervals.length;

        for (int[] interval : intervals) {
            int[] lastMerged = null;
            for (int i = interval[0]; i <= interval[1]; i++) {
                // Check if this i is part of a prior interval.
                if (array[i] != null) {
                    // If so, we need to merge intervals.
                    if (lastMerged != array[i]) {
                        numIntervals--;
                        lastMerged = array[i];
    
                        // Check if the prior interval started before this one.
                        if (array[i][0] < i) {
                            // If so, update those pointers to this new interval.
                            for (int j = array[i][0]; j < interval[0]; j++) {
                                array[j] = interval;
                            }
                            // Update this interval's lower bound.
                            interval[0] = array[i][0];
                        }
                        // Update this interval's higher bound if necessary.
                        interval[1] = Math.max(interval[1], array[i][1]);
                    }
                }
                // Indicate that i is in this (possibly updated) interval.
                array[i] = interval;
            }
        }
        
        // Put the final intervals into an array to return.
        int[][] results = new int[numIntervals][];
        int[] lastInterval = null;
        for (int i = 0, j = 0; j < numIntervals; i++) {
            if (array[i] != null && array[i] != lastInterval) {
                lastInterval = array[i];
                results[j++] = lastInterval;
            }
        }

        return results;
    }
}