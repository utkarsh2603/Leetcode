public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        dfs(1, n, k, temp);
        return ans;
    }

    private void dfs(int i, int n, int k, List<Integer> temp) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i > n) return;
        dfs(i + 1, n, k, temp);
        temp.add(i);
        dfs(i + 1, n, k - 1, temp);
        temp.remove(temp.size() - 1);
    }
}