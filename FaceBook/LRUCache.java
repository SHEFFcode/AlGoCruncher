import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
    }

    private final Map<Integer, ListNode> map;
    private final ListNode head, tail; // these will be dummy head and tail nodes
    private final int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        this.head = new ListNode(); // this will be a dummy head node
        this.head.prev = null;

        this.tail = new ListNode(); // this will be a dummy tail node
        this.tail.next = null;

        this.map = new HashMap<>(capacity); // reasonable size
    }

    public int get(int key) {
        ListNode nodeAtIndex = map.get(key); // assume we will not have null nodes;
        if (nodeAtIndex == null) {
            return -1; // We do not need to do any reordering here, since our map does not contain this
                       // item.
        }

        // let's move this node to head
        moveNodeToHead(nodeAtIndex);

        // There are no changes to the map here, since no new nodes were added or
        // evicted
        return nodeAtIndex.value; // let's not forget to return the value here
    }

    private void moveNodeToHead(ListNode node) {
        // In order to move to head, we first need to remove node in question
        removeNodeFromCurrentPosition(node);

        // and then insert it at the head
        addNodeAtHeadPosition(node);
    };

    private void removeNodeFromCurrentPosition(ListNode cNode) {
        // Let's take the two surrounding nodes
        ListNode nodeBeforeCurrent = cNode.prev;
        ListNode nodeAfterCurrent = cNode.next;

        // And take ourselves out of the linked list
        nodeAfterCurrent.next = nodeAfterCurrent;
        nodeAfterCurrent.prev = nodeBeforeCurrent;
    }

    private void addNodeAtHeadPosition(ListNode newHead) {
        // let's make node of the old head
        ListNode oldHead = this.head.next;

        // let's deal with new relationships between oldHead and newHead
        newHead.next = oldHead;
        newHead.prev = this.head;
        oldHead.prev = newHead;

        // official set the newHead as the new head
        this.head.next = newHead;
    }

    public void put(int key, int value) {
        // let's check if we already have a node with this key
        ListNode nodeAtIndex = map.get(key);

        if (nodeAtIndex == null) {
            // we do not have a node with this key, hard path
        } else {
            // we already have a node with this key, easy path
            nodeAtIndex.value = value;
            moveNodeToHead(nodeAtIndex);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */