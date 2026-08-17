// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 
// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]


// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]

// Example 4:
// Input: head = [1,2,3]
// Output: [2,1,3]

 

// Constraints:
// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100


class Swap Nodes in Pairs{
    public ListNode swapPairs(ListNode head) {
        ArrayList<Integer> n=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            n.add(cur.val);
            cur=cur.next;
        }

        for(int i=0;i+1<n.size();i+=2){
            int temp=n.get(i);
            n.set(i,n.get(i+1));
            n.set(i+1,temp);
        }
        ListNode Dummy=new ListNode(0);
        ListNode cu=Dummy;
        for(int v:n){
            cu.next=new ListNode(v);
            cu=cu.next;
        }
        return Dummy.next;
    }
}