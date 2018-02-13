import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeworkOne {

    static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));


    static Table addressBook = new Table(null);

    public static void main(String[] args){
        printMenu();

        try {
            String choice = reader.readLine();

            switch(choice){
                case "1":
                    System.out.print("Name:");
                    String name = reader.readLine();
                    System.out.print("Address:");
                    String address = reader.readLine();
                    addName(name, address);
                    break;
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }



//        System.out.println("Print: addressBook: \t\t" + addressBook);
//        System.out.println(".size(): \t\t\t\t" + addressBook.size());
//        System.out.println(".lookUp(3): \t\t\t\t" + addressBook.lookUp(3) + " (lookUp element at index:3 - list starts from 0)");
//        System.out.println(".remove(2): \t\t\t\t" + addressBook.remove(2) + " (element removed)");
//        System.out.println(".lookUp(3): \t\t\t\t" + addressBook.lookUp(3) + " (lookUp element at index:3 - list starts from 0)");
//        System.out.println(".size(): \t\t\t\t" + addressBook.size());
//        System.out.println("Print again: addressBook: \t" + addressBook);

    }

    private static void printMenu(){
        System.out.println("Please choose from the following menu items (Choose a number):");
        System.out.println("1. Add a name");
        System.out.println("2. Look up a name");
        System.out.println("3. Update address");
        System.out.println("4. Delete entry");
        System.out.println("5. Display all entries.");
        System.out.println("6. Quit");
    }

    private static void addName(String name, String address){
//        addressBook.insert(name, address);
//        addressBook.insert("2", "Joe");
//        addressBook.insert("3", "Jeri");
//        addressBook.insert("4", "Scott");

    }
}
