class Solution {
    private List<Integer> grayCode = new ArrayList<>();
    private final Set<Integer> visited = new HashSet<>();
    public List<Integer> grayCode(int n) {
        backTrack(0, new ArrayList<>(), n, (int) Math.pow(2, n));
        return grayCode;
    }

    private void backTrack(int state, List<Integer> code, int n, int size) {
        if(!grayCode.isEmpty() || code.size() >= size) return;
        code.add(state);
        visited.add(state);
        for (int i = 0; i < n; i++) {
            int newState = flipBit(state, i);
            if(code.size() == size && newState == 0) this.grayCode = new ArrayList<>(code);
            if(!grayCode.isEmpty()) return;
            if(!visited.contains(newState)) backTrack(newState, code, n, size);
        }
        visited.remove(state);
        code.remove(code.size()-1);
    }

    private int flipBit(int state, int i) {
        return state ^ (1 << i);
    }
}