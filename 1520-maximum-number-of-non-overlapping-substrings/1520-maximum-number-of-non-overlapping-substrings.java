class Solution {
    
    public int substrng(String s,int i,int []l, int []r)
    {
        int right=r[s.charAt(i)-'a'];
        for(int j=i;j<=right;++j)
        {
            if (l[s.charAt(j) - 'a'] < i)
            return -1;
        right = Math.max(right, r[s.charAt(j) - 'a']);
            
        }
        return right;
    }
    
    
    public List<String> maxNumOfSubstrings(String s) {
        int l[]=new int[26],r[]=new int[26];
       Arrays.fill(l,s.length());
       ArrayList<String> ans=new ArrayList<String>(); 
        for(int i=0;i<s.length();i++)
        {
            var temp=s.charAt(i)-'a';
            l[temp]=Math.min(l[temp],i);
            r[temp]=i;
        }
        int rgt=-1;
        for(int i=0;i<s.length();i++)
        {
            if(i==l[s.charAt(i)-'a'])
            {
                int right=substrng(s,i,l,r);
                if(right!=-1)
                {
                    if(i>rgt)
                        ans.add("");
                    rgt=right;
                    ans.set(ans.size()-1,s.substring(i,right+1));
                }
            }
        }
        return ans;
    }
}