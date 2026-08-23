/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }`
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
       
        for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                pq.add(lists[i]);
                }

        }
           
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode pointer=pq.poll();
            temp.next=pointer;
            temp=temp.next;
         
            if(pointer.next!=null){
                pq.add(pointer.next);
            }
            


        }
        return dummy.next;

        

    }
}
