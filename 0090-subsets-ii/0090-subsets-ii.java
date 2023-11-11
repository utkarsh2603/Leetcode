class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(list,temp,nums,0);
        return list;
    }
    private void helper(List<List<Integer>> list,List<Integer> temp,int[] nums,int start)
    {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) 
        {
            if (i == start || (i > start && nums[i] != nums[i - 1]))
            {
                temp.add(nums[i]);
                helper(list,temp,nums,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}