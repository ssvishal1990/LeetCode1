package ReverseTheLinkedList;

import RemoveNodesFromLinkedList.ListNode;

import java.util.Stack;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        ListNode result = null;
        while(!stack.isEmpty()){
            if(result == null){
                result = stack.pop();
                temp = result;
            }else {
                result.next = stack.pop();
                result = result.next;
            }
        }
        if(result != null && result.next != null){
            result.next = null;
        }
        head = temp;
        return head;
    }
}
