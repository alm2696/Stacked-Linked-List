public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedList {
    Node head;

    public void append(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;
        }

        Node current_node = head;
        while (current_node.next != null) {
            current_node = current_node.next;
        }
        current_node.next = new_node;
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node current_node = head;
        while (current_node.next != null) {
            if (current_node.data == current_node.next.data) {
                current_node.next = current_node.next.next;
            } else {
                current_node = current_node.next;
            }
        }
    }

    public void printList() {
        Node current_node = head;
        while (current_node != null) {
            System.out.print(current_node.data + " ");
            current_node = current_node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linked_list = new LinkedList();
        linked_list.append(1);
        linked_list.append(2);
        linked_list.append(2);
        linked_list.append(3);
        linked_list.append(3);
        linked_list.append(3);
        linked_list.append(4);

        linked_list.printList(); // Output: 1 2 2 3 3 3 4
        linked_list.removeDuplicates();
        linked_list.printList(); // Output: 1 2 3 4
    }
}