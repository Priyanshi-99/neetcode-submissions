class LFUCache {

    
        private static class Node{
            int key;
            int value;
            int freq;
            Node prev;
            Node next;
            Node(int key,int value){
                this.key=key;
                this.value=value;
                this.freq=1;
            }
        }
        
        private static class DoublyLinkedList{
            private Node left;
            private Node right;
            private int size;
            DoublyLinkedList(){
                left=new Node(0,0);
                right=new Node(0,0);
                left.next=right;
                right.prev=left;
            }
            void addLast(Node node){
                Node previous=right.prev;
                previous.next=node;
                node.prev=previous;
                node.next=right;
                right.prev=node;
                size++;
            } 
            void remove(Node node){
                node.prev.next=node.next;
                node.next.prev=node.prev;
                size--;
            }
            Node removeFirst(){
                if(size==0) return null;
                Node node=left.next;
                remove(node);
                return node;
            }
            boolean isEmpty(){
                return size==0;
            }
        }
        
    
    private final int capacity;
    private int size;
    private int minFreq;
    private final Map<Integer,DoublyLinkedList> freqLists;
    private final Map<Integer,Node> nodes;
    public LFUCache(int capacity){
        this.capacity=capacity;
        this.nodes=new HashMap<Integer,Node>();
        this.freqLists=new HashMap<Integer,DoublyLinkedList>();
    }
    
    public int get(int key) {
        Node node=nodes.get(key);
        if(node==null) return -1;
        increaseFreq(node);
        return node.value;
        
    }
    private void increaseFreq(Node node){
        int oldFreq=node.freq;
        DoublyLinkedList oldList=freqLists.get(oldFreq);
        oldList.remove(node);
        if(oldFreq==minFreq && oldList.isEmpty()){
            minFreq++;
        }
        node.freq++;
        freqLists.computeIfAbsent(node.freq,f->new DoublyLinkedList()).addLast(node);

    }
    
    public void put(int key, int value) {
//case1: jab capacity 0 hai
        if(capacity==0) return;
//case2: key already hai cache m
        if(nodes.containsKey(key)){
            Node node=nodes.get(key);
            node.value=value;
            increaseFreq(node);
            return;
        }
//case3 new key hai lekin cache full hai
if(size==capacity){
    DoublyLinkedList minList=freqLists.get(minFreq);
    //lru ko hata do
    Node removed=minList.removeFirst();
    nodes.remove(removed.key);
    size--;
}
//case 4 new node insert kr rhe hai
Node node=new Node(key,value);
nodes.put(key,node);
size++;
freqLists.computeIfAbsent(1,f->new DoublyLinkedList()).addLast(node);
minFreq=1;


        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */