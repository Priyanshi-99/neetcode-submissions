class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int longest=0;
        for(int num:hs){
        if(!hs.contains(num-1)){
            int length=1;
            int curr=num;
            while(hs.contains(curr+1)){
                curr++;
                length++;
            }
            longest=Math.max(longest,length);
        }

        }
        return longest;
    }
}
