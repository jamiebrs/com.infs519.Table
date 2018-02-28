// Jeremiah Bowers
// Homework 1
// G# G00536727

import java.util.Scanner;

public class HomeworkOne {

    /*
        the scanner is used to read the in text, the table calls my table class
        the ANSI items are just for color coding the results that get displayed
        the red means there was an issue, and the purple is for the results
        the reset resets the console color back to the default.
     */

    private static final Scanner sc = new Scanner(System.in);
    private static final Table<String> addressBook = new Table<>();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";


    /*
        Print the menu, take the choice, run that choice.
        If there is a system error print that error and re-run the menu
    */
    public static void main(String[] args){
        try {
            printMenu();
            String choice = sc.nextLine().trim().trim();
            menuChoices(choice);

        } catch (Exception e){
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            printMenu();
            String choice = sc.nextLine().trim().trim();
            menuChoices(choice);
        }

    }

    //Should be self explanatory, print the menu
    private static void printMenu(){
        System.out.println("Please choose from the following menu items (Choose a number):");
        System.out.println("1. Add a name");
        System.out.println("2. Look up a name");
        System.out.println("3. Update address");
        System.out.println("4. Delete entry");
        System.out.println("5. Display all entries.");
        System.out.println("6. Quit");
    }


    /* Run the choice the user made, I asked them to use the numbers 1-6,
     if they enter anything else I tell them it's an invalid choice and reprint the menu
     I'm sort of using recursion here in that this method keeps calling itself until
     you choice choice 6 which exits the system, however it's not true recursion in the
     sense that you simply exit the system you dont return to the original main method
    */
    private static void menuChoices(String choice) {
        switch(choice){
            case "1":
                System.out.print("Name:");
                String name = sc.nextLine().trim().trim();
                System.out.print("Address:");
                String address = sc.nextLine().trim().trim();
                boolean addName = addValue(name, address);
                if (!addName){
                    System.out.println("");
                    System.out.println(ANSI_RED + name + " already exists in your address book." + ANSI_RESET);
                    System.out.println("");
                }
                break;
            case "2":
                System.out.println("Lookup Name:");
                String tempName = sc.nextLine().trim().trim();
                String lookupName = addressBook.lookUp(tempName);
                if(lookupName != null) {
                    System.out.println("");
                    System.out.println(ANSI_PURPLE + "Name:" + lookupName + ANSI_RESET);
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println(ANSI_RED +  tempName + "  not found." + ANSI_RESET);
                    System.out.println("");
                }
                break;
            case "3":
                System.out.println("Update Address:");
                System.out.print("Name:");
                String updateKey = sc.nextLine().trim();
                System.out.print("Address:");
                String updateValue = sc.nextLine().trim();
                boolean updateName = updateValue(updateKey, updateValue);
                if(!updateName){
                    System.out.println("");
                    System.out.println(ANSI_RED +  updateKey + " not found." + ANSI_RESET);
                    System.out.println("");
                }
                break;
            case "4":
                System.out.print("Remove Item (use key): ");
                String tempKey = sc.nextLine().trim();
                boolean deleteName =  deleteValue(tempKey);

                if(!deleteName){
                    System.out.println("");
                    System.out.println(ANSI_RED +  tempKey + " not found." + ANSI_RESET);
                    System.out.println("");
                }
                break;
            case "5":
                String allItems = addressBook.printAll();
                if(!allItems.equals("")){
                    System.out.println(ANSI_PURPLE + allItems  + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + "The list is empty." + ANSI_RESET);
                }

                break;
            case "6":
                 System.exit(0);
            default:
                System.out.println(ANSI_RED + "Not a valid choice." + ANSI_RESET);

        }

        printMenu();
        choice = sc.nextLine().trim();
        menuChoices(choice);
    }

    /*  the following 3 methods call the table's associated method to get the return
        value of true or false which i pass back to the items that call them in the
        printMenu method, if false is returned I give a message, saying that the item was
        either already in the list if we are trying to add (return's true),
        or it was not in the list if we are trying to update or delete (returns false)
     */

    private static boolean addValue(String key, String value){
        return addressBook.insert(key, value);
    }

    private static boolean updateValue(String key, String value){
        return addressBook.update(key, value);
    }

    private static boolean deleteValue(String key){
        return addressBook.delete(key);
    }
}
