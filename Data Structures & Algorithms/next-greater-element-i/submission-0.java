class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hm.put(nums1[i],i);
        }
        int []res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=-1;
        }
        Stack<Integer> stk=new Stack<>();
        for(int num:nums2){
            while(!stk.isEmpty() && num>stk.peek()){
                int smaller=stk.pop();
                int ind=hm.get(smaller);
                res[ind]=num;
            }
            if(hm.containsKey(num)){
                stk.push(num);
            }
        }
        return res;


        
    }
}