class Solution {
    public String multiply(String nums1, String nums2) {
        if(nums1.equals("0") || nums2.equals("0")){
            return "0";
        }

        int[] res=new int[nums1.length()+nums2.length()];
        for(int i=nums1.length()-1;i>=0;i--){
            for(int j=nums2.length()-1;j>=0;j--){
                int n1=nums1.charAt(i)-'0';
                int n2=nums2.charAt(j)-'0';
                int product=n1*n2;
 

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + res[pos2];

                res[pos2] = sum % 10;
                res[pos1] += sum / 10;

            }
        }
        StringBuilder ans=new StringBuilder();
        for(int digit:res){
            if(ans.length()==0&&digit==0 ){
                
                continue;
            }
            //System.out.println(digit);
            ans.append(digit);
            //System.out.println(ans);

        }
        return ans.toString();
        
    }
}
