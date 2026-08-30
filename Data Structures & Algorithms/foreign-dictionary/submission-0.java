class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> graph=new HashMap<>();
        Map<Character,Integer> indegree=new HashMap<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                graph.putIfAbsent(c,new HashSet<>());
                indegree.putIfAbsent(c,0);
            }
        }
        //adj list bana rhe hai
        for(int i=0;i<words.length-1;i++){
            String first=words[i];
            String second=words[i+1];

            int minLength=Math.min(first.length(),second.length());
            boolean foundDiff=false;
            for(int j=0;j<minLength;j++){
                char a=first.charAt(j);
                char b=second.charAt(j);
                if(a!=b){
                    foundDiff=true;
                    // Avoid counting duplicate edges more than once.
                    if(graph.get(a).add(b)){
                        indegree.put(b,indegree.get(b)+1);
                    }
                    break;
                }
            }
            if(!foundDiff && first.length()>second.length()){
                return "";
            }
        }
        //topo sorting started...............
        Queue<Character> q=new ArrayDeque<>();
        for(char c:indegree.keySet()){
            if(indegree.get(c)==0){
                q.offer(c);
            }
        }
        StringBuilder pat=new StringBuilder();
        while(!q.isEmpty()){
            char curr=q.poll();
            pat.append(curr);
            for(char nei:graph.get(curr)){
                indegree.put(nei,indegree.get(nei)-1);
                if(indegree.get(nei)==0){
                    q.offer(nei);
                }
            }
        }
        if(pat.length()!=graph.size()){
            return "";
        }
        return pat.toString();


      
    }
}
