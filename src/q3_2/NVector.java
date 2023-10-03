package q3_2;
/**
 * Class to represent a vector with size elements
 */
public class NVector {
    private double[] elements;

    /**
     * Constructor taking dimension size and initializing all elements to 0.
     */
    public NVector(int size) {
        elements = new double[size];
    }

    /**
     * Copy constructor.
     */
    public NVector(NVector other) {
        elements = other.elements.clone();
    }

    /**
     * VARARG constructor.
     */
    public NVector(double... values) {
        elements = values.clone();
    }

    /**
     * @return Size of the vector.
     */
    public int length() {
        return elements.length;
    }

    /**
     * Accessor method for the vector.
     * @param i Index of the element.
     * @return Element at index i.
     */
    public double get(int i) {
        return elements[i];
    }

    /**
     * Method to compare two NVectors.
     * @param obj Another NVector to compare with.
     * @return True if both vectors are equal, false otherwise.
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
     * Method to create a copy of NVector with one element changed.
     * @param i Index of the element to change.
     * @param x Value to set.
     * @return A new NVector with the changed value.
     */
    public NVector set(int i, double x) {
        NVector result = new NVector(this);
        result.elements[i] = x;
        return result;
    }

    /**
     * Method to add two NVectors.
     * @param other Another NVector to add with.
     * @return A new NVector that is the sum of this and other.
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
     * @param other Another NVector to compute scalar product with.
     * @return Scalar product of the two vectors.
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
        NVector v1 = new NVector(1, 2, 3, 4);
        NVector v2 = new NVector(5, 6, 7, 8);
        System.out.println(v1);
        System.out.println(v1.add(v2));
        System.out.println(v1.sprod(v2));
    }
}

