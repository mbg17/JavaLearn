package com.test.database.translate.基础;

import com.test.database.translate.std.In;

import java.util.Iterator;

public class ListNode {
    private Node root;

    private class Node {
        private Integer val;
        private Node next;

        public Node(Integer val) {
            this.val = val;
        }

        public Node(Integer val, Node node) {
            this.val = val;
            this.next = node;
        }
    }

    public Node getNodes(int num) {
        Node pre = null;
        for (int i = 0; i <= num; i++) {
            if (root == null) {
                root = new Node(i);
                pre = root;
            } else {
                root.next = new Node(i);
                root = root.next;
            }
        }
        root = pre;
        return root;
    }

    /**
     * 1.3.20
     */
    public void delete(int k) {
        if (k == 0 && root != null) {
            root = root.next;
            return;
        }
        Node pre = root;
        int start = 0;
        while (pre != null && start <= k) {
            if (start == k) {
                pre = pre.next;
                break;
            }
            pre = pre.next;
            start++;
        }
    }

    /**
     * 1.3.21
     */
    public boolean find(int key) {
        if (root == null) {
            return false;
        }
        boolean flag = false;
        Node pre = root;
        while (pre != null) {
            if (pre.val == key) {
                return true;
            }
            pre = pre.next;
        }
        return flag;
    }

    /**
     * 1.3.24
     */
    public void removeAfter(Node node) {
        if (root == null) {
            return;
        }
        Node pre = root;
        while (pre != null) {
            if (pre == node) {
                pre.next = null;
                return;
            }
            pre = pre.next;
        }
    }

    /**
     * 1.3.25
     */
    public void insertAfter(Node one, Node two) {
        if (one == null && two == null) {
            return;
        }
        two.next = one.next;
        one.next = two;
    }

    /**
     * 1.3.26
     */
    public Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        Node pre = new Node(-1, node);
        Node ans = pre;
        while (pre.next != null) {
            if (pre.next.val == key) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return ans.next;
    }

    /**
     * 1.3.27
     */
    public int max(Node node) {
        if (node == null) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        while (node != null) {
            ans = Math.max(ans, node.val);
            node = node.next;
        }
        return ans;
    }

    /**
     * 1.3.28
     */
    private static int ans = Integer.MIN_VALUE;

    public int maxDepth(Node node) {
        if (this.root == null) {
            return ans;
        }
        ans = Math.max(ans, this.root.val);
        return Math.max(ans, maxDepth(this.root.next));
    }

    public Node reverse(Node node) {
        if (node == null) {
            return node;
        }
        Node pre = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        Node nodes = listNode.getNodes(6);
        int max = listNode.max(nodes);
        System.out.println(max);
        Node reverse = listNode.reverse(nodes);
    }
}
