class LinkedList {

    private Node head; // Head of list
    private int size; // Number of elements in the list

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Works like addLast()
    public void insert(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        if (this.head == null)
            head = new_node;
        else {
            Node current = this.head;

            while (current.next != null)
                current = current.next;

            current.next = new_node;
        }

        size++;
    }

    // Add a node to the beginning of the list
    public void addFirst(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        size++;
    }

    // Remove a node from the beginning of the list
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    // Remove the last node from the list
    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                size--;
                return;
            }
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }
    }

    // Remove the node having a data value from the list
    public void remove(int data) {
        if (head != null) {
            if (head.data == data) {
                head = head.next;
                size--;
                return;
            }
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
                size--;
            }
        }
    }

    // Add a node at a position in the list assuming first node is at position 0
    public void addItem(int index, int data) {
        if (index == 0) {
            addFirst(data);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                Node new_node = new Node(data);
                new_node.next = current.next;
                current.next = new_node;
                size++;
            }
        }
    }

    public void printList() {
        System.out.print("LinkedList: ");

        Node current = this.head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("Size: " + size);
    }
}

class TestList {
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(8);
           
        list.printList();
	}
}