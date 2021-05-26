package com.fawvw.zheda.character1;

/**
 * 自定义链表设计
 */
public class MyLinkedList {
    Node head = null;//头结点

    /**
     * 链表中的节点，data代表节点的值，next是指向下一个节点的引用
     */
    class Node{
        Node next = null;//节点的引用，指向下一个节点
        int data;//节点的对象，即内容

        public Node(int data){
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     * @param d
     */
    public void addNode(int d){
        Node newNode = new Node(d);//实例化一个节点
        if (head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 返回节点长度
     * @return
     */
    public int length(){
        int lenth = 0;
        Node tmp = head;
        while (tmp != null){
            lenth++;
            tmp = tmp.next;
        }
        return lenth;
    }

    /**
     * 删除第i个节点
     * @param index
     * @return
     */
    public boolean deleteNode(int index){
        if (index < 1 && index > length()){
            return false;
        }
        if (index == 1){
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null){
            if (i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 在不知道头指针的情况下删除指定非最后一个节点
     * @param n
     * @return
     */
    public boolean deleteNode(Node n){
        if (n == null || n.next == null){
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        System.out.println(n+"删除成功");
        return true;
    }

    /**
     * 打印链表
     */
    public void printList(){
        Node tmp = head;

        while (tmp != null){
            System.out.print(tmp.data+",");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public Node reverseIteratively(Node head){
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null){
            Node pNext = pNode.next;
            if (pNext == null){
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
    }

    /**
     * 查找单链表的中间节点
     * 采用快慢指针的方式查找单链表的中间节点，快指针一次走两步，慢指针一次走一步，当快指针走完时，慢指针刚好到达中间节点。
     * 奇数个时为中间，偶数个时为中间前一个。
     * @param head
     * @return
     */
    public Node searchMid(Node head){
        Node p = this.head;
        Node q = this.head;
        while (p != null && p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Mid:"+q.data);
        return q;
    }

    /**
     * 判断链表是否有环，单向链表有环时，尾结点相同
     * @param head
     * @return
     */
    public boolean isLoop(Node head){
        Node fast = head;
        Node slow = head;
        if (fast == null){
            return false;
        }
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                System.out.println("该链表有环");
                return true;
            }
        }
        return false;
    }

    /**
     * 排序，从小到大
     * @return
     */
    public Node orderList(){
        Node nextNode = null;
        int tmp = 0;
        Node curNode = this.head;
        while (curNode.next != null){
            nextNode = curNode.next;
            while(nextNode != null){
                if (curNode.data > nextNode.data){
                    tmp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(15);
        list.addNode(31);
        list.addNode(52);
        list.addNode(23);
        System.out.println(list.searchMid(list.head).data);
        System.out.println("length:"+list.length());
        System.out.println("head.data:"+list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("删除Node（4）后：");
        list.printList();
        System.out.println(list.searchMid(list.head).data);
        System.out.println("ReversedHead:"+ list.reverseIteratively(list.head).data);
        list.printList();
        list.orderList();
        list.printList();
    }


}
