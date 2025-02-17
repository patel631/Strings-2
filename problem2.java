class findAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length()) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0){ 
                    match++;
                }
                map.put(in, cnt);
            }
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1){
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}

//time complexity O(m + n) where m is length of s string and n is length of p string
//space complexity O(1) as will be only character so 26 or 52 in case both uppercase and lower case