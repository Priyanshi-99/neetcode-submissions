class WordDictionary {
    WordDictionary[] trie=new WordDictionary[26];
    boolean flag=false;
    private WordDictionary root;
    boolean containsKey(char c){
        return trie[c-'a']!=null;
    }
    WordDictionary get(char c){
        return trie[c-'a'];
    }
    void put(char c,WordDictionary node){
        trie[c-'a']=node;
    }

    boolean isEnd(){
        return flag;
    }

    void setEnd(){
        flag=true;
    }


    public WordDictionary() {
    root=this;
    }

    public void addWord(String word) {
        WordDictionary node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new WordDictionary());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();


    }

    public boolean search(String word) {
        WordDictionary node=root;
        
                return dfs(word,0,node);

    }
    public boolean dfs(String word,int i,WordDictionary node){
        if(i==word.length()){
            return node.isEnd();
        }
        char c=word.charAt(i);
        if(c!='.'){
            WordDictionary child=node.trie[c-'a'];
            return child!=null && dfs(word,i+1,child);
        }
        else{
            for(WordDictionary child: node.trie){
                if(child!=null && dfs(word,i+1,child)) return true;
            }

        }
        return false;
    }

















}
