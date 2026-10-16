class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int l=0;
        int longest=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char rightChar=s.charAt(r);

            hm.put(rightChar,hm.getOrDefault(rightChar,0)+1);
            if(hm.size()>k){
                char leftChar=s.charAt(l);
                hm.put(leftChar,hm.get(leftChar)-1);
                if(hm.get(leftChar)==0){
                    hm.remove(leftChar);
                }
                l++;

            }
            longest=Math.max(longest,r-l+1);
        }
        return longest;
    }
}
