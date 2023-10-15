class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> tria = new ArrayList<>(numRows);
        for(int r = 0; r < numRows; r++){
            List<Integer>cols = new ArrayList<>(Collections.nCopies(r+1, 1));
            
            for(int c = 1; c<r; c++){
                cols.set(c, tria.get(r-1).get(c-1) + tria.get(r-1).get(c));
            }
            tria.add(cols);
        }
        return tria; 
    }
}