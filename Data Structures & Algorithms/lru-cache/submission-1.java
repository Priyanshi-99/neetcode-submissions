class LRUCache {
     
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        public  Node(int key,int val){
            this.val=val;
            this.key=key;
            
        }
    }
   
       HashMap<Integer,Node> hm=new HashMap<>();
       Node head;
       Node tail;
       int capacity_;

    public LRUCache(int capacity) {
        
        this.capacity_=capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;

         
        
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
        remove(node);
        insertafterhead(node);
        return node.val;
        }
        return -1;
        
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            node.val=value;
            remove(node);
            insertafterhead(node);
            return;
        }
        Node node=new Node(key,value);
        hm.put(key,node);
        insertafterhead(node);

        if(hm.size()>capacity_){
            Node temp=tail.prev;
           
            remove(temp);
             hm.remove(temp.key);

        }

           
        }
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        void insertafterhead(Node node){
            Node temp=head.next;
            head.next=node;
            node.prev=head;
            node.next=temp;
            temp.prev=node;
        // Node temp = head.next;
        // head.next = node;
        // node.prev = head;
        // node.next = temp;
        // temp.prev = node;
        
    
        
    }
}
