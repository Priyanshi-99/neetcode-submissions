class PrefixTree {
    PrefixTree[] trie= new PrefixTree[26];// yhe pe 26 leytter ka trie array lenege
    boolean flag=false;//trie will have this array and this flag value
    PrefixTree root;//yaha pe rrot ko decalure krnege and niche inatailize
    public PrefixTree() {
    root=this;
        
    }
        Boolean containsKey(char c){
            return (trie[c-'a']!=null);

        }
        PrefixTree get(char c){
            return trie[c-'a'];
        }
        void put(char c,PrefixTree node){
            trie[c-'a']=node; //connecting to another trie node
        }

        boolean isEnd(){
            return flag;
        }
        void setEnd(){
            flag=true;
        }


         
    
  
    public void insert(String word) {
        PrefixTree node=root;
           for(int i=0;i<word.length();i++){
           
            if(!node.containsKey(word.charAt(i))){
                
                node.put(word.charAt(i),new PrefixTree());
              

            }
            node=node.get(word.charAt(i));

           }
           node.setEnd();

    }

    public boolean search(String word) {
        PrefixTree node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
            
        }
        if(node.isEnd()==true){
            return true;
        }
        return false;

    }

    public boolean startsWith(String prefix) {
        PrefixTree node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node=node.get(prefix.charAt(i));

        }
        return true;

    }
}




















