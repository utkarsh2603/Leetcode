class Solution {
    public int[] findArray(int[] pref) {
        int[] new_arr = new int[pref.length];
        new_arr[0] = pref[0];
        for(int i=pref.length-1; i>0; i--){
            new_arr[i] = pref[i]^pref[i-1];
        }

        return new_arr;
    }
}