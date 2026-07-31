/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node dummy=head;
          
          //the copy
        while(dummy!=null){
          Node copynode=new Node(dummy.val);
          
            copynode.next=dummy.next;
              dummy.next=copynode;
            dummy=copynode.next;
        }
        //rndom pointer direction
        dummy=head;
        while(dummy!=null){
            if(dummy.random!=null){
            dummy.next.random=dummy.random.next;
            }
            
                dummy=dummy.next.next;
            


        }
        //pointing to next

        
             Node curr=new Node(-1);
            Node res=curr;
            Node temp=head;

            while(temp!=null){
                res.next=temp.next;
                temp.next=temp.next.next;

                res=res.next;
                temp=temp.next;
            }
        
        return curr.next;

    }
        
    
}
