class Solution {
    public String addStrings(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int carry = 0;
        int idx1 = n1-1;
        int idx2 = n2-1;
        StringBuilder s = new StringBuilder("");

        while(idx1>=0 && idx2>=0){
            int a = s1.charAt(idx1)-48;
            int b = s2.charAt(idx2)-48;
            int c = carry+a+b;

            if(c<10){
                s.insert(0,String.valueOf(c));
                carry = 0;
            }else{
                carry = c/10;
                c = c%10;
                s.insert(0,String.valueOf(c));
            }
            idx1--;
            idx2--;
        }

        if(idx1==-1 && idx2>=0){
            while(idx2>=0){
                int a = s2.charAt(idx2)-48;
                int c = carry+a;

                if(c<10){
                    s.insert(0,String.valueOf(c));
                    carry = 0;
                }else{
                    carry = c/10;
                    c = c%10;
                    s.insert(0,String.valueOf(c));
                }
                idx2--;
            }
        }

        if(idx2==-1 && idx1>=0){
            while(idx1>=0){
                int a = s1.charAt(idx1)-48;
                int c = carry+a;

                if(c<10){
                    s.insert(0,String.valueOf(c));
                    carry = 0;
                }else{
                    carry = c/10;
                    c = c%10;
                    s.insert(0,String.valueOf(c));
                }
                idx1--;
            }
        }

        if(carry!=0) s.insert(0,String.valueOf(carry));
        return s.toString();
    }
}