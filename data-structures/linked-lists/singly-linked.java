class LinkedList {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size = 0;

    public LinkedList() {
        head = null;
    }


    private Node locator(int index) {
        if (index >= size || index < 0 || head == null) {
            return null;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    public int get(int index) {
        Node result = locator(index);

        if (result != null) {
            return result.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (head == null) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }

        size += 1;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node tail = locator(size-1);
            tail.next = new Node(val);
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
        } else if(index == size){
            addAtTail(val);
        } else{
            Node positionBefore = locator(index-1);
            if(positionBefore != null){
                Node newNode = new Node(val);
                Node indexNode = positionBefore.next;

                positionBefore.next = newNode;
                newNode.next = indexNode;
            }
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if(head == null){
            return;
        }

        if(index == 0){
            head = head.next;
        } else if(index == size-1){
            Node tail = locator(size-2);
            tail.next = null;
        } else {
            Node positionBefore = locator(index-1);
            if(positionBefore != null){
                Node indexNode = positionBefore.next;
                positionBefore.next = indexNode.next;
            }
        }

        size--;
    }
}
