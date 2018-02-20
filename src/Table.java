public class Table<T> {

    private static int counter;
    private Node first;
    private Node last;

    // Default constructor
    public Table() {

    }

    // appends the specified element to the end of this list.
    public boolean insert(T key, T data) {

            if (!isEmpty()) {
                if (lookUp(key).equals(null)) {
                    Node prev = last;
                    last = new Node(key, data);
                    prev.next = last;
                    incrementCounter();
                    return true;
                } else {
                    return false;
                }
            } else {
                last = new Node(key, data);
                first = last;
                incrementCounter();
                return true;
            }




    }


    public String lookUp(T key)
    // returns the element at the specified position in this list.
    {
        if(first !=null){
            Node currentNode = first;
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){

                    return (String) currentNode.getData();
                }
                currentNode = currentNode.getNext();
            }
            return null;
        }
        return null;

    }

        public boolean remove(T key) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }
        boolean result = false;
        Node prev = first;
        Node curr = first;
        while (curr.next != null || curr == last) {
            if (curr.getKey().equals(key)) {
                // remove the last remaining element
                if (getCounter() == 1) {
                    first = null;
                    last = null;
                }
                // remove first element
                else if (curr.equals(first)) {
                    first = first.next;
                }
                // remove last element
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                }
                // remove element
                else {
                    prev.next = curr.next;
                }
                decrementCounter();
                result = true;
                break;
            }
            prev = curr;
            curr = prev.next;
        }
        return result;
    }

    public boolean update(T key, T data){
        if(first !=null){
            Node currentNode = first;
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setData(data);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
            return false;
        }
        return false;
    }

    public String lookupName(T key){
     String lookUp = "";
        if(first != null){
            Node currentNode = first;
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    lookUp = "Name: " + currentNode.getKey() + " Address: " + currentNode.getData();
                    return  lookUp;
                }
                currentNode = currentNode.getNext();
            }
        }
        return lookUp;
    }


    public String printAll() {
        String output = "";

        if (first != null) {
            Node currentNode = first;
            while (currentNode != null) {
                output += "Name:" + currentNode.getKey().toString() + " Address: " + currentNode.getData().toString() +"\n";
                currentNode = currentNode.getNext();
            }

        }
        return output;
    }


    public boolean markToStart(){
        return false;
    }

    public String valueAtMark(){
        return null;
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }
    private boolean isEmpty() {
        return getCounter() == 0;
    }

}
