public class LinkedList {
	
	Node head; // head of list
	 
    class Node {
        int data;
        Node next;
 
        // Constructor to create a new node
        Node(int d) { 
        	data = d;
        	next = null;
        }
    }
    
    public void insert(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
           
        // If the Linked List is empty, make this new node as head
        if (this.head == null) {
            this.head = new_node;
        }
        else {
            // Traverse till the last node and insert the new_node there
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
   
            // Insert the new_node at last node
            current.next = new_node;
        }
    }
   
    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    
    void splitList(LinkedList oddlist, LinkedList evenlist) {
        Node temp = this.head;
        int position = 1;

        while(temp != null) {
            if(position % 2 != 0) {
                if(oddlist.head == null) {
                    Node newNode = new Node(temp.data);
                    oddlist.head = newNode;
                }
                else {
                    Node current = oddlist.head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    Node newNode = new Node(temp.data);
                    current.next = newNode;
                }
            }
            else {
                if(evenlist.head == null) {
                    Node newNode = new Node(temp.data);
                    evenlist.head = newNode;
                }
                else {
                    Node current = evenlist.head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    Node newNode = new Node(temp.data);
                    current.next = newNode;
                }
            }
            position++;
            temp = temp.next;
        }
    }
}