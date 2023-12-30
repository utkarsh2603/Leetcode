class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<Integer>(), res);

        return res;
    }

    void backtrack(String s, int index, List<Integer> curr, List<String> res) {
       if(index == s.length()) {
           StringBuffer sb = new StringBuffer();
           if(curr.size() == 4) {
               for(int i = 0; i < curr.size(); i ++) {
                   sb.append("" + curr.get(i));
                   if(i < curr.size() - 1) {
                      sb.append('.');
                   }
               }
               res.add(sb.toString());
           }
           return;
       }
        
        
        int curDigit = s.charAt(index) - '0';

        curr.add(curDigit); //1,0
        backtrack(s, index + 1, curr, res);
        curr.remove(curr.size()- 1);

        if(curr.size() > 0) {
            int last = curr.get(curr.size() - 1);
            int candidate = last * 10 + curDigit;
            if (last != 0 && candidate <=255) {
                curr.remove(curr.size() -1);
                curr.add(candidate);
                backtrack(s, index+1, curr, res);
            }
        }   
    }
}