/*
* Nicolas Uribe
* Homework 3
* COP 4331 002
*/

package q3_2;
/**
 * Class to represent a vector with size elements
 */
public class NVector {
    private double[] elements;

    /**
     * Initializes a vector of given size with zeros.
     * Post: All elements are 0.
     */
    public NVector(int size) {
        elements = new double[size];
    }

    /**
     * Creates a vector by copying another.
     * Pre: other is not undefined.
     * Post: New vector has same elements as other.
     */
    public NVector(NVector other) {
        elements = other.elements.clone();
    }

    /**
     * VARARG constructor.
     *
     * Pre: values must not be null.
     * Post:The given values are created in a new NVector.
     */
    public NVector(double... values) {
        elements = values.clone();
    }

    /**
     * @return Size of the vector.
     * Post: Number of elements in the vector returned.
     */
    public int length() {
        return elements.length;
    }

    /**
     * Accessor method for the vector.
     * @param size Index of the element.
     * Pre: 0 <= i < length().
     * @return Element at index size.
     */
    public double get(int size) {
        return elements[size];
    }

    /**
     * Method to compare two NVectors.
     * @param obj Another NVector to compare with.
     * Pre: obj must be an instance of NVector.
     * Post: Returns true if both vectors have the same elements, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        NVector other = (NVector) obj;

        if (elements.length != other.elements.length) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != other.elements[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a vector with one modified element.
     * Pre: 0 <= i < length().
     * Post: New vector has i-th element set to x.
     */
    public NVector set(int i, double x) {
        NVector result = new NVector(this);
        result.elements[i] = x;
        return result;
    }

    /**
     * Adds this vector to another.
     * Pre: other has same length as this vector.
     * Post: Returns sum of this and other.
     */
    public NVector add(NVector other) {
        assert elements.length == other.elements.length : "Vectors should be of the same length for addition";

        NVector result = new NVector(elements.length);
        for (int i = 0; i < elements.length; i++) {
            result.elements[i] = elements[i] + other.elements[i];
        }
        return result;
    }

    /**
     * Method to compute the scalar product of two NVectors.
     *
     * @param other Another NVector to compute scalar product with.
     * Pre: Must have the same length as this vector.
     * Post: Returns the scalar product of the two vectors.
     */
    public double sprod(NVector other) {
        assert elements.length == other.elements.length : "Vectors should be of the same length for scalar product";

        double product = 0;
        for (int i = 0; i < elements.length; i++) {
            product += elements[i] * other.elements[i];
        }
        return product;
    }

    /**
     * @return String representation of the NVector.
     * Postconditions: Returns a string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Testing vararg constructor
        NVector vec = new NVector(1, 2, 3, 4);
        System.out.println("Vararg Constructor: " + vec);

        // Testing length
        System.out.println("Length: " + vec.length());

        // Testing get
        System.out.println("Element at index 2: " + vec.get(2));

        // Testing equals
        NVector vec2 = new NVector(1, 2, 3, 4);
        System.out.println("Vectors are equal: " + vec.equals(vec2));

        // Testing set
        NVector vecSet = vec.set(1, -5);
        System.out.println("After setting index 1 to -5: " + vecSet);

        // Testing add
        NVector vec3 = new NVector(4, 5, 6, 7);
        NVector vecAdd = vec.add(vec3);
        System.out.println("After adding: " + vecAdd);

        // Testing sprod
        double sprodResult = vec.sprod(vec3);
        System.out.println("Scalar product: " + sprodResult);

        // Testing toString
        System.out.println("String representation: " + vec);
    }


}

