class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()!=endWord.length()) return 0;
        Set<String> allowed=new HashSet<>();
        for(String word:wordList){
            allowed.add(word);
        }

        if(!allowed.contains(endWord)){
            return 0;
        }
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int turns=1;
        //bfs
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord)) return turns;

                char[] c=s.toCharArray();
                for(int j=0;j<c.length;j++){
                    char orignal=c[j];
                    for(char w='a';w<='z';w++){
                        if(w==orignal){
                            continue;
                        }
                        c[j]=w;
                        String x=new String(c);
                        if(allowed.contains(x) && !visited.contains(x)){
                            q.offer(x);
                            visited.add(x);

                        }

                    }
                    c[j]=orignal;
                }
            }
            turns++;


        }

        return 0;        
    }
}
