class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res=new ArrayList<>();
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<nums1.length;i++ ){
            hm.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hm.contains(nums2[i]) && (res.contains(nums2[i])!=true)){
               res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}