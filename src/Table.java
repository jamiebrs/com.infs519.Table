public class Table {

    private Node head;

    public Table(){    }

    public void add(Object key, Object data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(key, data);
        }

        Node temp = new Node(key, data);
        Node current = head;

        // check for NPE
        if (current != null) {
            // starting at the head node, crawl to the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // the last node's "next" reference set to our new node
            current.setNext(temp);
        }

    }

    public Object getData(Object key)
    // returns the element at the specified position in this list.
    {

        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
        return current;

    }

    // removes the element at the specified position in this list.
    public boolean remove(Object key) {

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (crunchifyCurrent.getNext() == null)
                    return false;

                crunchifyCurrent = crunchifyCurrent.getNext();
            }
            crunchifyCurrent.setNext(crunchifyCurrent.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;

        }
        return false;
    }

}
