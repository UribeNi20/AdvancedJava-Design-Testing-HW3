package q4_1;

import java.util.*;
import java.text.SimpleDateFormat;



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

    /**
     * Returns a comparator for Car objects that compares by make and model.
     *
     * @return a comparator for Car objects
     * Preconditions: None
     * Postconditions: A comparator for Car objects is returned.
     */
    public static Comparator<Car> getCompByMakeModel() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                int makeComparison = car1.getMake().compareTo(car2.getMake());
                if (makeComparison != 0) {
                    return makeComparison;
                }
                return car1.getModel().compareTo(car2.getModel());
            }
        };
    }

    /**
     * Returns a comparator for Car objects that compares by built date.
     *
     * @return a comparator for Car objects
     * Preconditions: None
     * Postconditions: A comparator for Car objects is returned.
     */
    public static Comparator<Car> getCompByDate() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getBuiltDate().compareTo(car2.getBuiltDate());
            }
        };
    }

    public static void main(String[] args) {
        // Create an ArrayList<Car> object called cars
        ArrayList<Car> cars = new ArrayList<>();

        // Create a Calendar instance to help set the Date objects
        Calendar calendar = Calendar.getInstance();

        // Add 4 new Car objects to the cars list with bogus built dates
        calendar.set(2021, Calendar.SEPTEMBER, 12);
        cars.add(new Car("BMW", "430i", calendar.getTime()));

        calendar.set(2021, Calendar.FEBRUARY, 15);
        cars.add(new Car("Dodge", "Demon", calendar.getTime()));

        calendar.set(2030, Calendar.APRIL, 20);
        cars.add(new Car("Tesla", "Cyber Truck", calendar.getTime()));

        calendar.set(2019, Calendar.MAY, 1);
        cars.add(new Car("JEEP", "Riviera", calendar.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Sort the cars list by make/model and display the sorted collection
        Collections.sort(cars, getCompByMakeModel());
        System.out.println("Cars sorted by Make/Model:");
        for (Car car : cars) {
            System.out.println("Make: " + car.getMake() + ", Model: " + car.getModel() + ", Built Date: " + sdf.format(car.getBuiltDate()));
        }

        // Sort the cars list by built date and display the sorted collection
        Collections.sort(cars, getCompByDate());
        System.out.println("\nCars sorted by Built Date:");
        for (Car car : cars) {
            System.out.println("Make: " + car.getMake() + ", Model: " + car.getModel() + ", Built Date: " + sdf.format(car.getBuiltDate()));
        }
    }
}

