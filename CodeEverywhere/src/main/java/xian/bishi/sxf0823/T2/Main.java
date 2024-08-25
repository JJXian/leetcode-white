package xian.bishi.sxf0823.T2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 实现LRU
 *
 * @Author: jjxian
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        LRUCache1 cache = new LRUCache1(N);
        for (int i = 0; i < L; i++) {
            System.out.println("输入类型");
            String type = sc.next();
            if (type.equals("s")) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                cache.put(key, value);
            } else if (type.equals("g")) {
                int key = sc.nextInt();
                int value = cache.get(key);
                System.out.println(value);
            }
        }
    }


}

class LRUCache1 {

    Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;


    public LRUCache1(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
//        将使用的节点移动到前面
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
//            创建一个新的节点
            Node node = new Node(key, value);
//            节点加入哈希表 （既要维护哈希表 也要维护双链表）
            cache.put(key, node);
            addToHead(node);

            if (cache.size() > capacity) {
                Node node1 = tail.prev;
                removeNode(node1);
                cache.remove(key);

            }

        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        Node pre = node.prev;
        pre.next = node.next;
        node.next.prev = pre;
    }

    private void addToHead(Node node) {
//        node.next = head.next;
//        head.next = node;
//        node.next.prev = node;
//        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}


class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> cache;
    private int capacity;
    private Node head; // dummy head
    private Node tail; // dummy tail

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;

        // dummy head and tail initialization
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        // move accessed node to the front
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // update the value
            Node node = cache.get(key);
            node.value = value;
            // move the updated node to the front
            moveToHead(node);
        } else {
            // create new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            // add to the front
            addToFront(newNode);

            // check if over capacity, evict the least recently used (LRU) node
            if (cache.size() > capacity) {
                Node toRemove = tail.prev;
                removeNode(toRemove);
                cache.remove(toRemove.key);
            }
        }
    }

    private void moveToHead(Node node) {
        // remove node from current position
        removeNode(node);
        // add to the front
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}