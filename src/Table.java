// Jeremiah Bowers
// Homework 1
// G# G00536727

/*
 in addition to the requested mark node per the project guidelines
 I have created a size int that i can use to determine if the list
 is empty or not, this way I dont have to run code if there is no
 need to and care return false to the methods that use it, it makes the
 code run faster.

 I also have a head that I will set up as a marker for the first node in the list
 that my markToStart method uses. It basically sets the mark to the head node in the list
 which the purpose of the head node, my previousNode variable is for setting the last node
 in the list so that we can use it when we delete from the list in order to replace any
 node that might be in the middle of the list when we delete it with the node that comes after it
 */

public class Table<T> {
// I never got to use the T parameter because the required methods all said to use String
// if they didnt I could have done something like the following
// insert(T key, T, value). I hope I dont get points taken off for not using it because
// of the requirement

    private static int size;
    private Node head;
    private Node mark;
    private Node previousNode;

    // Default constructor never used, but good programming practice to have it
    public Table() {

    }


    /*Method name should be self explanatory
     take in the key and value run the lookup method to make sure it doesnt already
     exist and if it doesnt add it, if it is not the head node set the next node
     to the previous node which is what makes this a linked list and
     increment the size variable if it is the head node in the list set the
     previous node, head node, and mark all to the new node that is created and
     increment the size
    */
    public boolean insert(String key, String value)
    {
            if (!isEmpty()) {
                if (lookUp(key) == null) {
                    Node temp = previousNode;
                    previousNode = new Node(key, value);
                    temp.setNext(previousNode);
                    incrementSize();
                    return true;
                } else {
                    return false;
                }
            } else {
                previousNode = new Node(key, value);
                mark = previousNode;
                head = previousNode;
                incrementSize();
                return true;
            }

    }


    /*
      go to the start of the list using the markToStart Method and traverse it
      using the advaceMark() method if the key is found return the key, if it is not found return null
     */
    public String lookUp(String key)
    {
        markToStart();
        if(mark !=null){

            while(mark != null){
                if(keyAtMark().equals(key)){
                    return valueAtMark();
                }
                advanceMark();
            }
            return null;
        }
        return null;
    }


    /*
        If the list is not empty delete the node based on the given key
        we use the prev and curr node as temporary items to delete from the list and
        move the sibling node to the next node if it's sibling is deleted
        when we delete a node we decrease the count on the size integer
    */
    public boolean delete(String key)
    {
        if (isEmpty()) {
            return false;
        } else {
            boolean result = false;
            markToStart();
            Node temp = mark;
            Node curr = mark;
            while (curr.getNext() != null || curr == previousNode) {
                if (curr.getKey().equals(key)) {
                    // delete the previousNode remaining element, the list is now empty
                    if (getSize() == 1) {
                        mark = null;
                        previousNode = null;
                    }
                    // delete mark element
                    else if (curr.equals(mark)) {
                        advanceMark();
                    }
                    // delete previousNode element
                    else if (curr.equals(previousNode)) {
                        previousNode = temp;
                        previousNode.setNext(null);
                    }
                    // delete element
                    else {
                        temp.setNext(curr.getNext());
                    }
                    decrementSize();
                    result = true;
                    break;
                }
                temp = curr;
                curr = temp.getNext();
            }
            return result;
        }
    }

    // run the lookup and if the key exists update the value
    public boolean update(String key, String data){
        if (lookUp(key) != null){
            mark.setValue(data);
            return true;
        }
        return  false;
    }

    // traverse the list build a string and return the list as a string
    public String printAll() {
        StringBuilder output = new StringBuilder();
        markToStart();
        if (mark != null) {
            //Node currentNode = mark;
            while (mark != null) {
                output.append("Name:" + keyAtMark() + " Address: " + valueAtMark() +"\n");
                advanceMark();
            }

        }
        return output.toString();
    }


    //method used to move the mark to the start of the list, we se up the head varible
    // as a bookmark to do this
    public boolean markToStart(){
        mark = head;
        return true;
    }

    // method to move the mark does not care if it is null, other methods handle that if so
    public boolean advanceMark(){
        mark = mark.getNext();
         return true;
    }

    //gets the key at the mark's current position
    public String keyAtMark(){
        return mark.getKey();
    }

    // gets the value at the mark's current position
    public String valueAtMark(){
        return mark.getValue();
    }

    // the following 3 mothods deal with the size of the linked list
    // I use this to skip over running code that is not needed to run if the
    // list is empty
    private static int getSize() {
        return size;
    }

    // increases the size of the size int, when a item is added to the list
    private static void incrementSize() {
        size++;
    }

    // decreases the size of the size int, when a item is deleted from the list
    private void decrementSize() {
        size--;
    }

    // used to tell methods if the list is empty or not
    private boolean isEmpty() {
        return getSize() == 0;
    }

}
