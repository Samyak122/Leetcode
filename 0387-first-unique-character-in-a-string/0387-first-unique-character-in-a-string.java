class Solution {
    public int firstUniqChar(String str) {
        int index = -1;

        Map<Character, Integer > map = new HashMap<>();

        for(int i =0; i<str.length();i++){
            char c =str.charAt(i);

            int freq = map.getOrDefault(c,0);

            map.put(c, (freq+1));
        }

        for(int i =0; i<str.length(); i++){
            if(map.get(str.charAt(i))==1){
                index = i;
                break;
            }
        }
        return index;
    }
}