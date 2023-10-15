class Solution {
    public String convertToTitle(int colum) {
        String res="";
        while(colum>0){
            colum--;
            int val=colum%26;
            val+=65;
            res=((char)val+"")+""+res; // ->>reverse the string
            colum=colum/26;
            
           
        }
       
        return res;
        
    }
}