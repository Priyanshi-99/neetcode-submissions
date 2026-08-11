class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0){
            return false;
        }
        PriorityQueue<Integer> minH=new PriorityQueue<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        // Ready hasmap with count
        for(int i=0;i<hand.length;i++){
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);

        }
        //ready minheap with all the values
        for(int card:hm.keySet()){
            minH.add(card);
        }
        while(!minH.isEmpty()){
            int first=minH.peek();
        for(int i=0;i<groupSize;i++){
            int currentCard=first+i;
            if(!hm.containsKey(currentCard)|| hm.get(currentCard)==0){
                return false;
            }
            hm.put(currentCard,hm.get(currentCard)-1);
            if(hm.get(currentCard)==0){
                if(currentCard!=minH.peek()){
                    return false;
                }
                 minH.poll();
            }
            
        }
       
        }
        return true;
        
    }
}
