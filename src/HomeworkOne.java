import java.util.Scanner;

public class HomeworkOne {

    static Scanner sc = new Scanner(System.in);


    static Table<String> addressBook = new Table<>();

    public static void main(String[] args){


        try {

            printMenu();
            String choice = sc.nextLine();
            menuChoices(choice);

            while(choice !="6"){
                printMenu();
                choice = sc.nextLine();
                menuChoices(choice);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void menuChoices(String choice) {
        switch(choice){
            case "1":
                System.out.print("Name:");
                String name = sc.nextLine();
                System.out.print("Address:");
                String address = sc.nextLine();
                addName(name, address);
                break;
            case "2":
                System.out.println("Lookup Name:");
                System.out.print("Name:");
                String tempName = sc.nextLine();
                String lookupName = addressBook.lookupName(tempName);
                System.out.println(lookupName);
                break;
            case "3":
                System.out.println("Update Address:");
                System.out.print("Name:");
                String updateKey = sc.nextLine();
                System.out.print("Address:");
                String updateData = sc.nextLine();
                addressBook.update(updateKey, updateData);
                break;
            case "4":
                System.out.print("Remove Item (use key): ");
                String tempKey = sc.nextLine();
                addressBook.remove(tempKey);
                break;
            case "5":
                System.out.println(addressBook.printAll());
                break;
            case "6":
                 System.exit(0);
        }
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
        addressBook.insert(name, address);

    }
}
