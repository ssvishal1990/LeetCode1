package RemoveNodesFromLinkedList;

public class Solution {
    public ListNode removeNodes(ListNode head) {

        ListNode currentNode = head.next;
        ListNode prevNode = head;

        // only 1 node present
        if(currentNode == null) {
            return head;
        }

        // if 2 nodes present but prev is less than current
        if(currentNode . val > prevNode.val)
        {
            head = currentNode;
            return removeNodes(head);
        }

        while(currentNode.next != null) {
            if(currentNode.next.val > currentNode.val) {
                prevNode.next = currentNode.next;
                head = removeNodes(head);
                prevNode = head;
                currentNode = head.next;
            }
            currentNode = currentNode.next;
            prevNode = prevNode.next;
        }
        return head;
    }
}
