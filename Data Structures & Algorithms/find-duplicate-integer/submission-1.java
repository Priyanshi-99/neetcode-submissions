class Solution {
    public int findDuplicate(int[] nums) {
//         HashMap<Integer,Integer> mp=new HashMap<>();
//         for(int i:nums){       
//                 mp.put(i,mp.getOrDefault(i,0)+1);
//            }
//         for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
//             if(entry.getValue()>1){
//                 return entry.getKey();
//             }
//         }
// return -1;
        int slow=0;
        int fast=0;
        do{
            slow=nums[slow];//slow=slow.next
            fast=nums[nums[fast]];//fast=fast.next.next

        }
        while(slow!=fast);

        int entry=0;
        while(entry!=slow){
            entry=nums[entry];//entry=entry.next
            slow=nums[slow];//slow=slow.next
        }
        return entry;
    }

        
    
}
