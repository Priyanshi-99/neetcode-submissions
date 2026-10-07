class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs=new HashSet<>();
      
        while(n!= 1){
        if(!hs.contains(n)) {
        hs.add(n);
        int sum=0;
        int temp=n;
        while(temp!=0){

        int num=temp%10;
        sum+=(num*num);
        temp=temp/10;    
        }
        n=sum;
        }
        else{
        return false;
        }
        }
        return true;
        
    }
}
