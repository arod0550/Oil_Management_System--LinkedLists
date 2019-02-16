import java.util.*;

/**
 * this is the main class of the project. This is an Oil Change Computer Management System that takes in Cars based on their brand or make for an oil change.
 * There are two lines of cars in this system. The data structure built in is a linked list. With the cars being nodes. 
 */
public class OilChangeManager {
    public static void main(String[] args) {
        //data field
        String currentList;
        //car can be put to side to be moved everywhere in the lists.
        Car sideCar = null;

        //create a scanner
        Scanner input = new Scanner(System.in);

        //Car List for Joe's Line & Donny's Line
        CarList JoeList = new CarList();
        CarList DonnyList = new CarList();
        CarList FinishedList = new CarList();

        //Welcoming message
        System.out.println("Welcome to Tony's Discount Oil Change Computer Management System!");
        System.out.println("It's way better than a rolodex, cork board, post-its, and pre-chewed bubblegum!");

        System.out.println();

        //initialize section variable to a empty string
        String section;
        String section2;
        mainMenu();

        while (true) {
            section = input.next();

            switch (section.toLowerCase()) {
                case "l":
                    // List Operations
                    ListDesired();
                    currentList = input.next();
                    while (true) {
                        if ((currentList.equals("j") || currentList.equals("J") || currentList.equals("d") || currentList.equals("D"))) {
                            break;
                        } else {
                            System.out.println("That List doesn't exist. Try again!!");
                            System.out.println();
                            ListDesired();
                            currentList = input.next();
                        }
                    }

                    //display the second menu with its way to promp for user input
                    subMenu();
                    section2 = input.next();

                    switch (section2.toLowerCase()) {
                        case "a":
                            //Add a car to the end
                            try {
                                System.out.println("Please enter vehicle's make ((Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                String carMake = input.next();
                                try {
                                    Make.valueOf(carMake.toUpperCase());
                                }catch (IllegalArgumentException ex){
                                    System.out.println("We don't service "+ carMake +" here. Try Again.");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                }

                                System.out.println("Please enter owner's name: ");
                                input.nextLine();//flushing
                                String ownerName = input.nextLine();

                                //make an object of car with make and owner's name.
                                Car carAdded = new Car(Make.valueOf(carMake.toUpperCase()), ownerName);

                                if (currentList.equals("J") || currentList.equals("j")) {
                                    JoeList.appendToTail(carAdded);

                                    //Let user know the car has been added to the list
                                    System.out.println("" + ownerName + "'s " + carMake + " has been scheduled for an oil change with " +
                                            "Joe and has been added to his list.");

                                } else if (currentList.equals("D") || currentList.equals("d")) {
                                    DonnyList.appendToTail(carAdded);


                                    //Let user know the car has been added to the list
                                    System.out.println("" + ownerName + "'s " + carMake + " has been scheduled for an oil change with " +
                                            "Donny and has been added to his list.");
                                }

                            } catch (InputMismatchException ex) {
                                System.out.println("We don't service that car here. Try again.");
                            } catch (IllegalArgumentException ex) {
                                System.out.println("invalid input. try again!!!");
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "f":
                            //Cursor Forward
                            if (currentList.equals("J") || currentList.equals("j")) {
                                if (JoeList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    JoeList.cursorForward();
                                    System.out.println("Cursor Moved Forward in Joe's List.");
                                }
                            } else if (currentList.equals("D") || currentList.equals("d")) {
                                if (DonnyList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    DonnyList.cursorForward();
                                    System.out.println("Cursor Moved Forward in Donny's List.");
                                }
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "b":
                            //Cursor Backward
                            if (currentList.equals("J") || currentList.equals("j")) {
                                if (JoeList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    JoeList.cursorBackward();
                                    System.out.println("Cursor Moved Backward in Joe's List.");
                                }
                            } else if (currentList.equals("D") || currentList.equals("d")) {
                                if (DonnyList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    DonnyList.cursorBackward();
                                    System.out.println("Cursor Moved Backward in Donny's List.");
                                }
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "h":
                            //Cursor to Head
                            if (currentList.equals("J") || currentList.equals("j")) {
                                if (JoeList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    JoeList.resetCursorToHead();
                                    System.out.println("Cursor Moved to Head in Joe's List.");
                                }
                            } else if (currentList.equals("D") || currentList.equals("d")) {
                                if (DonnyList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    DonnyList.resetCursorToHead();
                                    System.out.println("Cursor Moved to Head in Donny's List.");
                                }
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "t":
                            //Cursor to Tail
                            if (currentList.equals("J") || currentList.equals("j")) {
                                if (JoeList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    JoeList.cursorToTail();
                                    System.out.println("Cursor Moved to Tail in Joe's List.");
                                }
                            } else if (currentList.equals("D") || currentList.equals("d")) {
                                if (JoeList.isEmpty()) {
                                    System.out.println("Invalid command. List is empty!!");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                } else {
                                    DonnyList.cursorToTail();
                                    System.out.println("Cursor Moved to Tail in Donny's List.");
                                }
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "i":
                            //Insert car before cursor
                            try {
                                System.out.println("Please enter vehicle's make ((Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln): ");
                                String carMake1 = input.next();
                                try {
                                    Make.valueOf(carMake1.toUpperCase());
                                }catch (IllegalArgumentException ex){
                                    System.out.println("We don't service "+ carMake1 +" here. Try Again.");
                                    System.out.println();
                                    mainMenu();
                                    break;
                                }
                                System.out.println("Please enter owner's name: ");
                                input.nextLine();//flushing
                                String ownerName1 = input.nextLine();

                                //make an object of car with make and owner's name.
                                Car carAdded = new Car(Make.valueOf(carMake1.toUpperCase()), ownerName1);

                                if (currentList.equals("J") || currentList.equals("j")) {
                                    JoeList.insertBeforeCursor(carAdded);
                                    JoeList.cursorForward();

                                    //Let user know the car has been added to the list
                                    System.out.println("" + ownerName1 + "'s " + carMake1 + " has been scheduled for an oil change with " +
                                            "Joe and has been added to his list before cursor.");
                                } else if (currentList.equals("D") || currentList.equals("d")) {
                                    DonnyList.insertBeforeCursor(carAdded);
                                    DonnyList.cursorForward();

                                    //Let user know the car has been added to the list
                                    System.out.println("" + ownerName1 + "'s " + carMake1 + " has been scheduled for an oil change with " +
                                            "Donny and has been added to his list before cursor.");
                                }
                            } catch (InputMismatchException ex) {
                                System.out.println("We don't service that car here. Try again.");
                            } catch (IllegalArgumentException ex) {
                                System.out.println("That is not a valid input. Try again.  ");
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "r":
                            //Remove cursor
                            try {
                                if (currentList.equals("J") || currentList.equals("j")) {
                                    if (JoeList.isEmpty()) {
                                        System.out.println("Invalid command. List is empty!!");
                                        System.out.println();
                                        mainMenu();
                                        break;
                                    } else {
                                        JoeList.removeCursor();
                                        System.out.println("Cursor was removed in Joe's List.");
                                    }
                                } else if (currentList.equals("D") || currentList.equals("d")) {
                                    if (DonnyList.isEmpty()) {
                                        System.out.println("Invalid command. List is empty!!");
                                        System.out.println();
                                        mainMenu();
                                        break;
                                    } else {
                                        DonnyList.removeCursor();
                                        System.out.println("Cursor was removed in Donny's List.");
                                    }
                                }
                            } catch (EndOfListException ex) {
                                System.out.println("there's no car in this index.");
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "x":
                            //Cut car at cursor
                            try {
                                if (currentList.equals("J") || currentList.equals("j")) {
                                    if (JoeList.isEmpty()) {
                                        System.out.println("Invalid command. List is empty!!");
                                        System.out.println();
                                        mainMenu();
                                        break;
                                    } else {
                                        sideCar = JoeList.removeCursor();
                                        if (sideCar != null) {
                                            System.out.println("Car at Cursor has been cut and set to the side in Joe's List.");
                                        }
                                    }
                                } else if (currentList.equals("D") || currentList.equals("d")) {
                                    if (DonnyList.isEmpty()) {
                                        System.out.println("Invalid command. List is empty!!");
                                        System.out.println();
                                        mainMenu();
                                        break;
                                    } else {
                                        sideCar = DonnyList.removeCursor();
                                        if (sideCar != null) {
                                            System.out.println("Car at Cursor has been cut and set to the side in Donny's List.");
                                        }
                                    }
                                }
                            } catch (EndOfListException ex) {
                                System.out.println("there's no car in this index.");
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        case "v":
                            //Paste before cursor
                            if (sideCar != null) {
                                if (currentList.equals("J") || currentList.equals("j")) {
                                    JoeList.insertBeforeCursor(sideCar);
                                    JoeList.cursorForward();
                                    sideCar = null;
                                    System.out.println("Car at Cursor was pasted before cursor in Joe's List.");
                                } else if (currentList.equals("D") || currentList.equals("d")) {
                                    DonnyList.insertBeforeCursor(sideCar);
                                    DonnyList.cursorForward();
                                    sideCar = null;
                                    System.out.println("Car at Cursor was pasted before cursor in Donny's List.");
                                }
                            } else {
                                System.out.println("There's no car on the side to paste.");
                            }
                            System.out.println();
                            mainMenu();
                            break;
                        default:
                            //Display wrong status, No Section was matched
                            System.out.println("Error: invalid status. Try again");
                            subMenu();
                    }
                    break;
                case "m":
                    //Merge Lists
                    try {
                        ListMerged();
                        String choice = input.next();
                        if (choice.equals("J") || choice.equals("j")) {
                            if (!((JoeList.isEmpty()) && DonnyList.isEmpty())) {
                                JoeList = JoeList.mergeList(DonnyList, JoeList);
                                DonnyList.emptyOutList();
                                System.out.println("Donny's list merged into Joe's due to a medical condition called Hangoveritis Extremis.");
                            } else {
                                System.out.println("both or one list are/is empty. Merging was unsuccessful.");
                            }
                        } else if (choice.equals("D") || choice.equals("d")) {
                            if (!((DonnyList.isEmpty()) && JoeList.isEmpty())) {
                                DonnyList = DonnyList.mergeList(JoeList, DonnyList);
                                JoeList.emptyOutList();
                                System.out.println("Joe's list merged into Donny's due to a medical condition called Hangoveritis Extremis.");
                            } else {
                                System.out.println("both or one list are/is empty. Merging was unsuccessful.");
                            }
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("invalid input. Try again.");
                    }
                    System.out.println();
                    mainMenu();
                    break;
                case "p":
                    //Print Lists
                    System.out.println("Joe's List:");
                    System.out.println(JoeList.toString());
                    System.out.println();
                    System.out.println("Donny's List:");
                    System.out.println(DonnyList.toString());
                    System.out.println();
                    System.out.println("Finished List:");
                    System.out.println(FinishedList.toString());
                    System.out.println();
                    mainMenu();
                    break;
                case "f":
                    //Paste car to finished list.
                    if (sideCar != null) {
                        FinishedList.insertBeforeCursor(sideCar);
                        FinishedList.cursorForward();
                        sideCar = null;
                        System.out.println("Car to the side was pasted before cursor in Finished List.");
                    } else
                        System.out.println("There's no car on the side to paste.");

                    System.out.println();
                    mainMenu();
                    break;
                case "q":
                    // Section Q (Quit)
                    System.out.println("You are now leaving Tony's Discount Oil Change Computer Management System!");
                    System.out.println("We congratulate you on your decision to do something more productive with your time.");
                    System.exit(0);
                    break;
                default:
                    //Display wrong status, No Section was matched
                    System.out.println("Error: invalid status. Try again");
                    mainMenu();
            }
        }
    }

    /**
     * Method containing Menu.
     */
    public static void mainMenu() {
        //Menu
        System.out.println("Menu:");
        System.out.println("     L) Edit Job Lists for Joe and Donny");
        System.out.println("     M) Merge Job Lists");
        System.out.println("     P) Print Job Lists");
        System.out.println("     F) Paste car to end of finished car list");
        System.out.println("     Q) Quit Tony's Discount Oil Change Computer Management.");
        System.out.println();

        //prompt user to go to section desired
        System.out.println("Please select an option: ");
    }

    /**
     * Method containing sub Menu for the options on the list section.
     */
    public static void subMenu() {
        //Menu
        System.out.println("Options:");
        System.out.println("     A) Add a car to the end of the list");
        System.out.println("     F) Cursor Forward");
        System.out.println("     H) Cursor to Head");
        System.out.println("     F) Paste car to end of finished car list");
        System.out.println("     T) Cursor to Tail");
        System.out.println("     B) Cursor Backward");
        System.out.println("     I) Insert car before cursor");
        System.out.println("     X) Cut car at cursor");
        System.out.println("     V) Paste before cursor");
        System.out.println("     R) Remove cursor");
        System.out.println();

        //prompt user to go to section desired
        System.out.println("Please select an option: ");
    }

    /**
     * Method containing asking the user which list they desire to go to.
     */
    public static void ListDesired() {
        //prompt user to go to section desired
        System.out.println("Please select a list - Joe (J) or Donny (D): ");
    }

    /**
     * Method containing asking user for which list do they want to end up in for merging
     */
    public static void ListMerged() {
        //prompt user to select a destination
        System.out.println("Please select a destination list - Joe (J) or Donny (D): ");
    }

}
