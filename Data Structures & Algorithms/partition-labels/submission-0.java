class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),i);
        }

        List<Integer> res=new ArrayList<>();
        int partStart=0;
        int partEnd=0;

        for(int i=0;i<s.length();i++){
            partEnd=Math.max(partEnd,hm.get(s.charAt(i)));
            if(i==partEnd){
                res.add(i-partStart+1);
                partStart=i+1;
            }

        }
return res;
        
    }
}
