// Jeremiah Bowers
// Homework 1
// G# G00536727

public class Node {

    /*
        In this node class we create the key value pair that we will use as well as create a node item
        that we will use for connecting each node in our link list pair
     */

    private Node next;
    private String key;
    private String value;

    // Our initial constructor sets the next node to null each time as we dont have a sibling node
    //when we create the most recent node on the stack
    public Node(String keyVal, String dataVal) {
        next = null;
        key = keyVal;
        value = dataVal;
    }

    // should be self explanatory
    public String getKey() {
        return key;
    }

    // Although this setKey method is never used, I created it for good programming practice
    // Whenever you have a get you should have a set along with it.
    public void setKey(String key) {
        this.key = key;
    }

    // should be self explanatory
    public String getValue() {
        return value;
    }

    // should be self explanatory
    public void setValue(String dataVal) {
        value = dataVal;
    }

    // returns the next node in the list.
    public Node getNext() {
        return next;
    }

    // sets the next node in the list
    public void setNext(Node nextValue) {
        next = nextValue;
    }



}