class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] array = path.split("/");
        List<String> list = new ArrayList();
        int index = 0;

        for(String s : array){
            if(s.equals("..")){
                index = list.size()-1;
                if(index >=0) list.remove(index);
            }else if(s.equals(".") || s.isEmpty()){
                continue;
            }else {
                list.add(s);
            }
        }

        for(String s : list){
            sb.append("/");
            sb.append(s);
        }
        
        String result =  sb.toString();
        return result.equals("") ? "/" : result;
    }
}