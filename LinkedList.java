public class LinkedList {

    Node head;
    char letter;

    public LinkedList(char letter) {
        this.head = null;
        this.letter = letter;
    }
    public void insert(String word) {
        Node newNode = new Node(word, 1);
        if (head == null || head.word.compareTo(word) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.word.compareTo(word) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int findFrequency(String word) {
        Node current = head;
        while (current != null && !current.word.equals(word)) {
            current = current.next;
        }
        if (current == null) {
            return 0;
        } else {
            return current.frequency;
        }
    }

    public void incrementFrequency(String word) {
        Node current = head;
        while (current != null && !current.word.equals(word)) {
            current = current.next;
        }
        if (current != null) {
            current.frequency++;
        }
    }
}
