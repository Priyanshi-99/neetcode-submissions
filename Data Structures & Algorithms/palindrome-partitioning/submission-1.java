class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> arr=new ArrayList<>();
        helper(res,arr,s,0);
        return res;
    }
    public void helper(List<List<String>> res,List<String> arr,String s,int i){
        if(i==s.length()) {
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int j=i;j<s.length();j++){
               if(isPalin(s,i,j)){
                arr.add(s.substring(i,j+1));
                helper(res,arr,s,j+1);
                arr.remove(arr.size()-1);
               }
               // arr.add(s.substring(i,j));
            

        }
        

    }
    public boolean isPalin(String s,int i,int j){
        String res="";
        while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
        }
        return true;
    }
}
