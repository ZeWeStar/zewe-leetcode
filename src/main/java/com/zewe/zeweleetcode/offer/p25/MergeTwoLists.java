package com.zewe.zeweleetcode.offer.p25;

/**
 * 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @author chenzhengwei
 * @version 1.0
 * @date 2021/4/13 10:47
 */
public class MergeTwoLists {

    /**
     * 双指针， 构造违头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 ){
            return l2;
        }
        if(null == l2){
            return l1;
        }

        // 构造头节点
        ListNode head = new ListNode(0);
        // 当前节点位置
        ListNode cur = head; // 注当前节点必须为 一个对象实例， 错误写法 cur = head.next,cur = null;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next; // l1 后移
            }else{
                cur.next = l2; // l2 后移
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // l1 或 l2 已走完
        cur.next = l1 == null ? l2 : l1;
        return head.next;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(l1, l2);

    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
