partition list: 最后rightTail.next一定要等于null, 否则会让输出的链表有环产生
merge-k-sorted-list: 在用两两合并方法时, 在遍历当前lists时, for的上界应该是lists.size() - 1
reorder list: reverse()中的while循环的终止条件是while(head != null)
sort list: 在开头进行corner case判断时, 用if(head == null || head.next == null), 否则findMid时会遇到corner case
