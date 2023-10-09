class Solution {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String ans=helper(countAndSay(n-1));
        return ans;
    }
	
	private static String helper(String str) {
		String ans="";
		for(int i=str.length()-1;i>=0;i--) {
			int count=1;
			while(i>0) {
				if(str.charAt(i)==str.charAt(i-1)) {
					i--;
                    count++;
				}else break;
			}
            
			ans=Integer.toString(count)+str.charAt(i)+ans;
		}
		return ans;
	}

}