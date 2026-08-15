class Solution {
    public double myPow(double x, int n) {

        double ans=1;
        long pow = n;
        if(n<0){
            pow = Math.abs(pow);
            System.out.println("n value : "+ pow);
        }
        while(pow>0){
            if((pow%2) == 0){
                x = x*x;
                pow /=2;
            } else {
                ans = ans*x;
                pow--;
            }
        }
        if(n<0){
            ans = 1/ans;
        }
        return ans;
    }
}
