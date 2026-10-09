class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> hs=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            hs.add(wordDict.get(i));
        }
        return helper(s,wordDict,hs,0);
        
    }
    public List<String> helper(String s,List<String> wordDict,Set<String> hs,int start ){
        List<String> ans=new ArrayList<>();
        if(start==s.length()){
            ans.add("");
            return ans;
        }
        for(int i=start+1;i<=s.length();i++){
            
            String word=s.substring(start,i);
            if(!hs.contains(word)){
                continue;
            }
            List<String> temp=helper(s,wordDict,hs,i);
            for(String tmp:temp){
                if(tmp.isEmpty()){
                    ans.add(word);
                }
                else{
                ans.add(word+" "+tmp);
                }
            }
        }
        return ans;
    }




}