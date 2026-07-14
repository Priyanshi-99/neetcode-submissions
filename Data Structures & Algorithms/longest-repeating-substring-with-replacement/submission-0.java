class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxfreq=0;
        int ans=0;
        int[] arr=new int[26];
        for(int r=0;r<s.length();r++){
            int idx=s.charAt(r)-'A';
            arr[idx]++;
            maxfreq=Math.max(maxfreq,arr[idx]);

            if((r-l+1)-maxfreq>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
    ans=Math.max(ans,r-l+1);
        }
        return ans;

    }
}
