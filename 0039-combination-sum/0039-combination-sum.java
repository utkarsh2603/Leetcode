class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        // Arrays.sort(candidates);
        sum(answer, new ArrayList<>(), candidates, target, candidates.length - 1);
        return answer;
    }

    public void sum(List<List<Integer>> answer, List<Integer> list, int[] candidates, int target, int index) {
        if (index == -1) {
            if (target == 0)
                answer.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[index]);
        sum(answer, list, candidates, target - candidates[index], index);
        list.remove(list.size() - 1);
        sum(answer, list, candidates, target, index - 1);
    }
}