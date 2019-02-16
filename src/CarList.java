/**
 * This class represents the list of cars on the system. This class uses linked lists as the data structure.
 */
public class CarList {
    //Data Fields
    private int numberOfCars;
    private CarListNode head;
    private CarListNode tail;
    private CarListNode cursor;

    //Constructors

    /**
     * Default constructor which initializes this object to an empty list of Cars.
     * <dt>Post conditions:
     * This CarList has been initialized with head, tail, and cursor all set to null.</>
     */
    public CarList() {
        head = null;
        tail = null;
        cursor = null;
        numberOfCars = 0;
    }

    //Methods

    /**
     * Getting total number of Cars in the list.
     * @return Returns the total number of Cars in the list.
     */
    public int numCars() {
        return numberOfCars;
    }

    /**
     * Gets the reference to the Car wrapped by the CarListNode currently
     * referenced by cursor.
     * @return Returns the reference by the Car wrapped by the CarListNode currently
     * referenced by cursor. If the cursor is null, then this method should return
     * null as well (i.e. the cursor does not reference an Car).
     */
    public Car getCursorCar() {
        if (cursor.getData() == null) {
            Car result = null;
            return result;
        } else
            return cursor.getData();
    }

    /**
     * Returns the cursor to the start of the list.
     * <dt>Post conditions:
     * If head is not null, the cursor now references the first CarListNode in this list.
     * If head is null, the cursor is set to null as well (there are no Cars in this list).</>
     */
    public void resetCursorToHead() {
        if (head == null) {
            cursor = null;
        } else
            cursor = head;
    }

    /**
     * returns the cursor to the end of the line.
     * <dt>Post conditions:
     * If tail is not null, the cursor now references the last CarListNode in this list.
     * If tail is null, the cursor is set to null as well (there are no Cars in this list).</>
     */
    public void cursorToTail() {
        if (cursor == tail) {
            System.out.println("you've reached the tail.");
        } else if (tail == null) {
            cursor = null;
        } else
            cursor = tail;
    }

    /**
     * Moves the cursor to select the next CarListNode in the list.
     * @throws EndOfListException if cursor is at the tail of the list.
     */
    public void cursorForward() {
        try {
            if (cursor == tail) {
                throw new EndOfListException();
            } else {
                cursor = cursor.getNext();
            }
        } catch (EndOfListException ex) {
            System.out.println("");
        }
    }

    /**
     * Moves the cursor to select the previous CarListNode in the list.
     *
     * @throws EndOfListException if cursor is at the head of the list.
     */
    public void cursorBackward() {
        try {
            if (cursor == head) {
                throw new EndOfListException();
            } else {
                cursor = cursor.getPrev();
            }
        } catch (EndOfListException ex) {
            System.out.println("");
        }
    }

    /**
     * Inserts the indicated Car before the cursor.
     *
     * @param newCar Car being inserted to the list before the cursor.
     * <dt>Preconditions: newCar is not null.</>
     * <dt>Post conditions:
     *   newCar has been wrapped in a new CarListNode object.
     *   If cursor was previously not null, the newly created CarListNode has
     *     been inserted into the list before the cursor.
     *   If cursor was previously null, the newly created CarListNode has
     *     been set as the new head of the list (as well as the tail).
     *   The cursor remains unchanged.</>
     */
    public void insertBeforeCursor(Car newCar) {
        try {
            if (newCar == null) {
                throw new IllegalArgumentException();
            }
            CarListNode newCarNode = new CarListNode(newCar);
            if (cursor == null) {
                head = newCarNode;
                tail = newCarNode;
                cursor = newCarNode;
                numberOfCars++;
            } else {
                newCarNode.setPrev(cursor.getPrev());
                if (cursor.getPrev() != null)
                    cursor.getPrev().setNext(newCarNode);
                cursor.setPrev(newCarNode);
                newCarNode.setNext(cursor);
                cursor = newCarNode;
                if (cursor.getPrev() == null)
                    head = cursor;
                numberOfCars++;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("invalid argument. This is not a car.");
        }
    }

    /**
     * Inserts the indicated Car after the cursor.
     * @param newCar Car being inserted to the list after the cursor.
     * <dt>Preconditions: newCar is not null.</>
     * <dt>Post conditions:
     *   newCar has been wrapped in a new CarListNode object.
     *   If cursor was previously not null, the newly created CarListNode has
     *     been inserted into the list after the cursor.
     *   If cursor was previously null, the newly created CarListNode has
     *     been set as the new head of the list (as well as the tail).
     *   The cursor references the inserted car.</>
     */
    public void insertAfterCursor(Car newCar) {
        try {
            if (newCar == null) {
                throw new IllegalArgumentException();
            }
            CarListNode newCarNode = new CarListNode(newCar);
            if (cursor == null) {
                head = newCarNode;
                tail = newCarNode;
                cursor = newCarNode;
                numberOfCars++;
            } else {
                newCarNode.setNext(cursor.getNext());
                if (cursor.getNext() != null) {
                    cursor.getNext().setPrev(newCarNode);
                }
                cursor.setNext(newCarNode);
                newCarNode.setPrev(cursor);
                cursor = newCarNode;
                if (cursor.getNext() == null) {
                    tail = cursor;
                }
                numberOfCars++;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("invalid argument. This is not a car.");
        }
    }



    /**
     * Inserts the indicated Car after the tail of the list.
     *
     * @param newCar Car being inserted after the tail of the list.
     * <dt>Preconditions: newCar is not null.</>
     * <dt>Post conditions: newCar has been wrapped in a new CarListNode object.
     *   If tail was previously not null, the newly created CarListNode
     *       has been inserted into the list after the tail.
     *   If tail was previously null, the newly created CarListNode has
     *       been set as the new head of the list (as well as the tail and the cursor).
     *   The tail now references the newly created CarListNode.</>
     * @throws IllegalArgumentException if newCar is null.
     */
    public void appendToTail(Car newCar) {
        try {
            if (newCar == null) {
                throw new IllegalArgumentException();
            } else {
                CarListNode newCarNode = new CarListNode(newCar);
                numberOfCars++;
                if (tail != null) {
                    newCarNode.setPrev(tail);
                    newCarNode.setNext(null);
                    tail.setNext(newCarNode);
                    tail = newCarNode;

                } else {
                    head = newCarNode;
                    cursor = newCarNode;
                    tail = newCarNode;
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("invalid argument. This is not a car being added.");
        }
    }

    /**
     * Removes the CarListNode referenced by cursor and returns the Car inside.
     * <dt>Preconditions: cursor is not null.</>
     * <dt>Post conditions: The CarListNode referenced by cursor has been removed
     * from the list.
     * All other CarListNodes in the list exist in the same Car as before.
     * The cursor now references the previous CarListNode (or the head, if the
     * cursor previously referenced the head of the list).</>
     *
     * @throws EndOfListException if cursor is null.
     */
    public Car removeCursor() throws EndOfListException {
        if (cursor == null) {
            throw new EndOfListException();
        }
        //variable to be returned
        Car carRemoved = null;

        if (cursor.getPrev() == null) {
            //found the head
            head = cursor.getNext();
            //set the previous to the head to null if head is found
            if (head != null) {
                head.setPrev(null);
            }

            carRemoved = cursor.getData();
            //return the cursor to the head once you have the data of car removed
            cursor = head;
        } else if (cursor.getNext() == null) {
            //found tail
            tail = cursor.getPrev();
            tail.setNext(null);

            carRemoved = cursor.getData();
            //return the cursor to the head once you have the data of car removed
            cursor = cursor.getPrev();
        } else {
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());

            carRemoved = cursor.getData();
            //return the cursor to the previous node once you have the data of car removed
            cursor = cursor.getPrev();
        }
        if (cursor != null && cursor.getNext() == null)
            tail = cursor;

        numberOfCars--;
        return carRemoved;
    }

    /**
     * Returns True if list is empty. Returns False if otherwise.
     */
    public boolean isEmpty() {
        return (cursor == null);
    }

    /**
     * Returns the head of the Car List.
     * @return
     *  the reference to head of the carlist.
     */
    public CarListNode getHead() {
        return head;
    }

    /**
     * Returns the tail of the Car List.
     * @return
     *  the reference to tail of the carlist.
     */
    public CarListNode getTail() {
        return tail;
    }

    /**
     * Returns the cursor of the Car List.
     * @return
     *  the reference to cursor of the carlist.
     */
    public CarListNode getCursor() {
        return cursor;
    }


    /**
     * setter for number of cars.
     * @param numberOfCars
     *  integer representing the number of cars in the list.
     */
    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    /**
     * setter for the head.
     * @param head
     *  reference of head of the type CarListNode.
     */
    public void setHead(CarListNode head) {
        this.head = head;
    }

    /**
     * setter for the tail.
     * @param tail
     *  reference of tail of the type CarListNode.
     */
    public void setTail(CarListNode tail) {
        this.tail = tail;
    }

    /**
     * setter for the cursor.
     * @param cursor
     * reference of cursor of the type CarListNode.
     */
    public void setCursor(CarListNode cursor) {
        this.cursor = cursor;
    }

    /**
     * merges a list into the other.
     * @param list1 list desired to be merged.
     * @param list2 list desired to be merged into.
     * @return the result of the two list being merged
     */
    public CarList mergeList(CarList list1, CarList list2) {
        CarList result = new CarList();
        list1.resetCursorToHead();
        list2.resetCursorToHead();

        if (list1.isEmpty() && list2.isEmpty()) {
            System.out.println("Both list are empty. Merging was unsuccessful.");
        }

        while ((list1.getCursor() != null) || (list2.getCursor() != null)) {
            if (list1.getCursor() != null) {
                result.appendToTail(list1.getCursorCar());
                list1.setCursor(list1.getCursor().getNext());
            }
            if (list2.getCursor() != null) {
                result.appendToTail(list2.getCursorCar());
                list2.setCursor(list2.getCursor().getNext());
            }
        }
        return result;
    }

    /**
     * deletes all elements in the linked list.
     */
    public void emptyOutList() {
        head = null;
        cursor = null;
        tail = null;
        numberOfCars = 0;
    }

    /**
     * prints the list of Cars with their respective attributes.
     * @return A string representing a list of the students in  the line.
     */
    @Override
    public String toString() {
        String result = "";
        CarListNode tempCursor = head;
        result += "Number Of Cars: " + numberOfCars + '\n';
        result += "Make             Owner" + '\n';
        result += "----------------------" + '\n';

        if (tempCursor == null) {
            result += "[empty]";
        }

        while (tempCursor != null) {
            if (tempCursor == cursor) {
                result += ("->");
            }
            result += tempCursor.getData().toString();
            tempCursor = tempCursor.getNext();
        }
        return result;
    }
}
