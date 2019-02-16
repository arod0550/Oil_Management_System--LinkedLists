/**
 * This class represents the nodes of the linked lists. The cars are the nodes in the oil management system.
 */
public class CarListNode {
    //Data Fields
    private Car data;
    private CarListNode next;
    private CarListNode prev;

    //Constructors

    /**
     * Default Constructor.
     * @param initData represents an object of car that initializes the data.
     * @throws IllegalArgumentException
     * <dt>Postconditions:
     *  This CarListNode has been initialized to wrap the indicated Car,
     *    and prev and next have been set to null.</>
     */
    public CarListNode(Car initData) {
        if (initData == null) {
            throw new IllegalArgumentException();
        }
        data = initData;
        next = null;
        prev = null;
    }

    //Getters and setters

    /**
     * returns a string representing the data of the node.
     * @return
     */
    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * Gets the data of a car.
     * @return returning an object of car.
     */
    public Car getData() {
        return data;
    }

    /**
     * sets an object of car.
     * @param data
     */
    public void setData(Car data) {
        this.data = data;
    }

    /**
     * gets the link of the next node.
     * @return an object of CarListNode representing reference of next node.
     */
    public CarListNode getNext() {
        return next;
    }

    /**
     * sets the link of this node to the next node.
     * @param next an object of CarListNode representing the reference of next node.
     */
    public void setNext(CarListNode next) {
        this.next = next;
    }

    /**
     * gets the link of the previous node.
     * @return an object of CarListNode representing reference of the previous node.
     */
    public CarListNode getPrev() {
        return prev;
    }

    /**
     * sets the link of this node to the next node.
     * @param prev an object of CarListNode representing the reference of previous node.
     */
    public void setPrev(CarListNode prev) {
        this.prev = prev;
    }
}
