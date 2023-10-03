package q4_1;

import java.util.Date;

/**
 * Represents a Car with attributes make, model, and built date.
 * <p>
 * Class Invariant:
 * - The built date should never be in the future.
 * </p>
 */
public final class Car {

    private final String make;
    private final String model;
    private final Date builtDate;

    /**
     * Constructs a new Car instance.
     * Preconditions: builtDate should not be in the future.
     * Postconditions: A new Car instance is created with the specified attributes.
     */
    public Car(String make, String model, Date builtDate) {
        this.make = make;
        this.model = model;
        this.builtDate = new Date(builtDate.getTime()); // Defensive copy to ensure immutability
    }

    /**
     * Returns the make of the car.
     *
     * @return the make
     * Preconditions: None
     * Postconditions: The make of the car is returned.
     */
    public String getMake() {
        return make;
    }

    /**
     * Returns the model of the car.
     *
     * @return the model
     * Preconditions: None
     * Postconditions: The model of the car is returned.
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the built date of the car.
     *
     * @return the built date
     * Preconditions: None
     * Postconditions: The built date of the car is returned.
     */
    public Date getBuiltDate() {
        return new Date(builtDate.getTime()); // Defensive copy to ensure immutability
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", builtDate=" + builtDate +
                '}';
    }

}
