class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<Integer>(),0);
        return result;
    }
    public void helper(int[] arr,int target,List<Integer> templist,int start){
        if(target==0){
            result.add(new ArrayList<>(templist));
        }else if(target>0){
            for(int i=start;i<arr.length;i++){
                if (i > start && arr[i] == arr[i - 1]) {
                    continue;
                }
                templist.add(arr[i]);
                helper(arr,target-arr[i],templist,i+1);
                templist.remove(templist.size()-1);
            }
        }
    }
}