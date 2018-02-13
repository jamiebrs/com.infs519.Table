public class Node {

    Node next;
    private Object key;
    private Object data;

    public Node(Object keyVal, Object dataVal) {
        next = null;
        key = keyVal;
        data = dataVal;
    }

    public Node(Object keyVal, Object dataVal, Node nextVal) {
        next = nextVal;
        key = keyVal;
        data = dataVal;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object dataVal) {
        data = dataVal;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }



}