class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
       
        int[] temp=new int[3];
        for(int[] triple:triplets){
            if(triple[0]<=target[0] && triple[1]<=target[1] && triple[2]<=target[2]){
           
            temp[0]=Math.max( temp[0],triple[0]);
            temp[1]=Math.max( temp[1],triple[1]);
            temp[2]=Math.max( temp[2],triple[2]);
            }
            
        }
        for(int i=0;i<3;i++){
            if(temp[i]!=target[i]) return false;
        }
        return true;
        

        
    }
}
