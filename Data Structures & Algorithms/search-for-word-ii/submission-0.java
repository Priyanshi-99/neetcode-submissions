class Solution {
    static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        String word;
    }
    private final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {

     TrieNode root= new TrieNode();
     for(String word:words){
        TrieNode node=root;
        for(char ch: word.toCharArray()){
            int index=ch-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
        }
        node.word=word;

      }
      List<String> result=new ArrayList<>();
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            dfs(board,i,j,root,result);
        }
      }
      return result;
        
    }


    private void dfs(char[][]board,int r,int c,TrieNode parent,List<String> result){
        if(r<0 || r>=board.length||c<0 || c>=board[0].length){return;}
        char ch=board[r][c];
        if(ch=='#'){
            return;
        }
        TrieNode node=parent.children[ch-'a'];
        if(node==null){
            return;
        }
        if(node.word!=null){
        result.add(node.word);
        node.word=null;
        }
        board[r][c]='#';

        for(int[] direction:directions){
            dfs(board,r+direction[0],c+direction[1],node,result);
        }








board[r][c]=ch;




    }
}
