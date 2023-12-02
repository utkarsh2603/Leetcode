class Solution {/*
    private boolean check(String s, Map<Character, Integer>map){
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) < 0) {
                    map.remove(s.charAt(i));
                }
            } else{
                return false;
            }
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<chars.length(); i++){
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0)+1);
        }

        int count=0;
        for(int i=0; i<words.length; i++){
            if(check(words[i], map)){
                count += words[i].length();
            }
        }
        return count;
    }
    */





    private int [] count(String s){
        int[] arr = new int [26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }

    private boolean check(int[] chars, int[] word){
        for(int i=0; i<26; i++){
            if(chars[i] < word[i]) return false;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int []cnt_char = count(chars);
        int res=0;
        for(String word : words){
            int []cnt_word = count(word);

            if(check(cnt_char, cnt_word)){
                res += word.length();
            }
        }
        return res;
    }

}