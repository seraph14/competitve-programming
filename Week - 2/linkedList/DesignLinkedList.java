class MyLinkedList {
    
    class Node {
        int val;
        Node next;
        
        public Node() {
            this.next = null;
        }
    }
    
    Node head;
    Node current;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        current = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node temp = head;
        int val = -1;
        int i;
        if (index == size-1) {
            val = current.val;
        } else if (index < size - 1) {
            for (i = 0; i < index; i++) {
                temp = temp.next;
            }
            val = temp.val;    
        }
        return val;
    } 
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            newNode.next = head;
            head = newNode;
        }    
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        if (head == null) {
            head = newNode;
        } else {
            current.next = newNode; 
        }
        current = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node newNode = new Node();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            current = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        }  else if (index == size) {
            current.next = newNode;
            current = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index-1 && temp.next != null; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;    
        } 
        
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node temp = head;
        if (index <= size - 1) {
            if (index == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < index-1; i++) {
                    temp = temp.next;
                } if (index == size-1) {
                    temp.next = null;   
                    current = temp;
                } else {
                    temp.next = temp.next.next;   
                }
            }
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
