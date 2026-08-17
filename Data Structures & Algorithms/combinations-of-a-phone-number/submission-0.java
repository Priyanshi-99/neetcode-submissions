class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> phone=new HashMap<>();
        if(digits.length()==0) return new ArrayList<String>();
        List<String> res=new ArrayList<>();
        phone.put(2,"abc");
        phone.put(3,"def");
        phone.put(4,"ghi");
        phone.put(5,"jkl");
        phone.put(6,"mno");
        phone.put(7,"pqrs");
        phone.put(8,"tuv");
        phone.put(9,"wxyz");
        
     
        helper(digits,phone,0,new StringBuilder(),res);  
        
        return res;   
    }
    public void helper(String digits,HashMap<Integer,String> phone,int i,StringBuilder comb,List<String> res){
       
        if(i==digits.length()){
            res.add(comb.toString());
            return;
        }
        String letters=phone.get(digits.charAt(i)-'0');
        for(int ind=0;ind<letters.length();ind++){
            comb.append(letters.charAt(ind));
            helper(digits,phone,i+1,comb,res);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

}
