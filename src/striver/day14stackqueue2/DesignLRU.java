package striver.day14stackqueue2;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class LruNode {

        int key;
        int val;
        LruNode prev;
        LruNode next;

        public LruNode(int key, int val, LruNode p, LruNode n){

            this.key = key;
            this.val = val;
            this.next = n;
            this.prev = p;

        }

    }

    Map<Integer,LruNode> map = new HashMap<>();
    int capacity = 0;
    LruNode head = new LruNode(-1,-1, null, null);
    LruNode tail = new LruNode(-1,-1, null, null);

    public LRUCache(int capacity) {

        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {

        if(map.containsKey(key)) {

            LruNode add = map.get(key);
            add.prev.next = add.next;
            add.next.prev = add.prev;
            LruNode nNode = new LruNode(add.key, add.val, null, null);
            nNode.next = head.next;
            head.next = nNode;
            nNode.next.prev = nNode;
            nNode.prev = head;
            map.put(key, nNode);

            return map.get(key).val;

        }
        return -1;

    }

    public void put(int key, int value) {

        if(map.containsKey(key)){

            LruNode add = map.get(key);
            add.prev.next = add.next;
            add.next.prev = add.prev;
            LruNode nNode = new LruNode(add.key, value, null, null);
            nNode.next = head.next;
            head.next = nNode;
            nNode.next.prev = nNode;
            nNode.prev = head;
            map.put(key, nNode);

        }

        else {

            if(capacity>0) {

                LruNode nNode = new LruNode(key, value, null, null);
                nNode.next = head.next;
                head.next = nNode;
                nNode.next.prev = nNode;
                nNode.prev = head;
                map.put(key, nNode);
                capacity--;
            }
            else {

                LruNode lru = tail.prev;
                lru.prev.next = tail;
                tail.prev = lru.prev;
                LruNode nNode = new LruNode(key, value, null, null);
                nNode.next = head.next;
                head.next = nNode;
                nNode.next.prev = nNode;
                nNode.prev = head;
                map.put(key, nNode);


            }


        }

    }
}

public class DesignLRU {
}
