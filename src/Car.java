/**
 * This class represents an object of Car that will go through an oil change.
 */
public class Car {
    //Data fields
    private Make make;
    private String owner;

    //Constructors

    /**
     * Empty Constructor.
     */
    public Car() {
    }

    /**
     * Default Constructor
     * @param make  Of type Enum representing the brand of the car.
     * @param owner A String representing the name of the owner.
     */
    public Car(Make make, String owner) {
        this.make = make;
        this.owner = owner;
    }

    //Getters and Setters

    /**
     * Gets the brand of the car.
     * @return a type of Make.
     */
    public Make getMake() {
        return make;
    }

    /**
     * Sets the brand of the car.
     * @param make
     *  A make representing the brand of the car.
     */
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     * Gets the name of the owner.
     * @return A String representing the name of the owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the name of the owner.
     * @param owner
     *  A string representing the name of the owner.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    //Methods

    /**
     * provides all the factors of an object of Car.
     * @return A String representing Car's brand and name of owner.
     */
    @Override
    public String toString() {
        return "" + make + "            " + owner + '\n';
    }

    /**
     * Compare this Car to another object for equality.
     * @param o object representing what is being used for comparison.
     * @return a boolean value representing the equality of the objects.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (make != car.make) return false;
        return owner.equals(car.owner);
    }
}
