class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
       
        helper(0,0,res,n,"");

        return res;
        
    }
    public void helper(int open,int close,List<String> res,int n,String s){

        if(s.length()==n*2){
            res.add(s);
            return ;
        }
        if(open<n){
            helper(open+1,close,res,n,s+'(');
        }
         if(close<open){
            helper(open,close+1,res,n,s+')');
        }


    }
}
