class Solution {
    public int lengthOfLongestSubstring(String s) {
    //     int l=0;
    //     int res=0;
    //     HashSet<Character> hs=new HashSet<>();

    //     for(int r=0;r<s.length();r++){
    //         while(hs.contains(s.charAt(r))){// use of while beacuse the caharcter reparataion will be gone if more than 1 times repated
    //             hs.remove(s.charAt(l));
    //             l++;
    //         }
    //         hs.add(s.charAt(r));
    //         res=Math.max(res,r-l+1);
    //     }

    //    return res;

    int i=0;
    int res=0;
    HashSet<Character> hs=new HashSet<>();

    for(int j=0;j<s.length();j++){
        while(hs.contains(s.charAt(j))){
            hs.remove(s.charAt(i));
            i++;
        }
        hs.add(s.charAt(j));
        res=Math.max(res,j-i+1);
    }
    return res;
    }
}
