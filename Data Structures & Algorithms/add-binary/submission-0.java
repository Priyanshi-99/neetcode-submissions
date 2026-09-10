class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0||j>=0||carry!=0){
            int bitA=0;
            int bitB=0;
            if(i>=0){
                bitA=a.charAt(i)-'0';
            }
            if(j>=0){
                bitB=b.charAt(j)-'0';
            }
            int sum=bitA+bitB+carry;

            res.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        return res.reverse().toString();
        
        
    }
}