class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int minlen=Integer.MAX_VALUE;
        int l=0,r=0,start=0;
        int cnt=0;
        int n=s.length(),m=t.length();

        for(char c: t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }


        while(r<s.length()){
            char rightC=s.charAt(r);
            if(hm.containsKey(rightC)){
                hm.put(rightC,hm.get(rightC)-1);
                if(hm.get(rightC)==0){
                    cnt++;
                }
            }
            while(cnt==hm.size()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    start=l;
                }
                char leftC=s.charAt(l);
                if(hm.containsKey(leftC)){
                    if(hm.get(leftC)==0){
                        cnt--;
                    }
                    hm.put(leftC,hm.get(leftC)+1);
                }
                l++;
                
            }
            r++;
            
        }
return minlen==Integer.MAX_VALUE ? "":s.substring(start,start+minlen);



        
    }
}
