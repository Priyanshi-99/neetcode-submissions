class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            
                mp.put(i,mp.getOrDefault(i,0)+1);

            

        }
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue()>1){
                return entry.getKey();
            }
        }
return -1;
    }

        
    
}
