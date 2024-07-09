package T146LRU缓存;

import java.util.HashMap;

/**
 * @Author: jjxian
 */
class LRUCache {
    /**
     实现思想：
     1、定义Node节点，其中包含key,value,prev指针和next指针，并进行初始化
     2、定义全局变量hashmap类型的cache，定义capacity、head头指针和tail尾指针
     3、LRUCache初始化函数：完成cache，定义capacity、head头指针和tail尾指针的赋值初始化
     4、编写get函数，map中包含key，就把key移动到表头（最近使用）,返回key的value；
     5、抽取公共函数：moveToHead，removeNode,addToFront函数
     6、编写put函数：
     （1）包含key,就更新key的value，并移动到表头
     （2）不包含key，就创建新的key，添加到表头，如果容量超出capacity，就把表尾的移除

     */

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
        // 从当前位置移除
        removeNode(node);
        // 添加到头部
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Solution{
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
