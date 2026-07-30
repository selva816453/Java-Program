// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 
// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]
 

// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.


class Remove Duplicates from Sorted List II{
    public ListNode deleteDuplicates(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        LinkedHashMap<Integer,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        ArrayList<Integer> li=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                li.add(entry.getKey());
            }
        }
        ListNode DummyNode =new ListNode(0);
        ListNode cu=DummyNode;
        for(int n:li){
            cu.next=new ListNode(n);
            cu=cu.next;
    }
    return DummyNode.next;
}
}