class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }
        int j=0;
        for(int i=0;i<arr2.length;i++){
            while(hm.get(arr2[i])!=0){
                res.add(arr2[i]);
                hm.put(arr2[i],hm.get(arr2[i])-1);
                
            }
           

        }
         TreeMap<Integer, Integer> remaining = new TreeMap<>(hm);

        for(Map.Entry<Integer,Integer> entry:remaining.entrySet()){
            int values=entry.getKey();
            int count=entry.getValue();
            for(int i=0;i<count;i++){
                res.add(values);
            }
        }
        int[] ans=new int[arr1.length];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
        
    }
}