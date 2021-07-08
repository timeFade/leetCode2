package com.zhang.lettcode.linkedList;

public class ReverseLinkedList {

    private static Node successor;

    /**
     * 反转不带头结点的单链表
     *
     * @param head 首结点
     * @return 返回反转后的 首结点
     */
    public static Node reverseLinkedList(Node head) {
        //如果是既是首结点又是尾节点，则直接返回
        if (head.next == null) return head;
        //将除当前节点以外的其他链表反转
        Node last = reverseLinkedList(head.next);
        //将当前节点设置为反转链表的尾节点
        head.next.next = head;
        //将反转后的为节点next域设置为null
        head.next = null;
        //返回反转后的首节点
        return last;
    }

    /**
     * function 反转自head节点开始前n个节点
     *
     * @param head 首结点
     * @param n    要反转的节点个数
     * @return 返回第n个节点(经过反转后 ， 第n个节点就变成了首结点)
     */
    public static Node reverseN(Node head, int n) {
        //如果n==1，反转自己，就需要记录后继节点，并返回当前节点，作为新的头结点
        if (n == 1) {
            successor = head.next;//n+1
            return head;
        }
        //拿到新的头结点
        Node last = reverseN(head, n - 1);
        //将当前节点作为反转链表的尾部节点
        head.next.next = head;
        //将当前反转链表的尾部节点赋值为后继节点(在没有找到拿n+1个节点之前，successor始终都是null)
        head.next = successor;
        //返回新的头的节点
        return last;
    }

    /**
     * 给定区间，反转转部分的单链表[start,end]
     *
     * @param head 单链表的首结点
     * @param m    start
     * @param n    end
     * @return head
     */
    public static Node reversePartial(Node head, int m, int n) {
        //如果m==1，则从当前节点开始，反转n-m个节点，并返回反转后的第n个节点(此时为首结点)
        if (m == 1) {
            return reverseN(head, n);
        }
        //为当前的节点的next域重新赋值
        head.next = reversePartial(head.next, m - 1, n - 1);
        //返回经过反转后链表的首结点
        return head;
    }
}
