import org.junit.*;
import static org.junit.Assert.*;

public class TestNVector {

    @Test
    public void testVarargConstructor() {
        NVector vec = new NVector(1.0, 2.0, 3.0, 4.0);
        assertEquals(4, vec.length());
        assertEquals(1.0, vec.get(0), 0.001);
        assertEquals(2.0, vec.get(1), 0.001);
        assertEquals(3.0, vec.get(2), 0.001);
        assertEquals(4.0, vec.get(3), 0.001);
    }

    @Test
    public void testEquals() {
        NVector v1 = new NVector(1, 2, 3, 4);
        NVector v2 = new NVector(1, 2, 3, 4);
        NVector v3 = new NVector(1, 2, 3);
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
    }

    @Test
    public void testGet() {
        NVector vec = new NVector(5.0, 6.0, 7.0);
        assertEquals(5.0, vec.get(0), 0.001);
        assertEquals(6.0, vec.get(1), 0.001);
        assertEquals(7.0, vec.get(2), 0.001);
    }

    @Test
    public void testAdd() {
        NVector v1 = new NVector(1, 2, 3);
        NVector v2 = new NVector(4, 5, 6);
        NVector expected = new NVector(5, 7, 9);
        assertTrue(expected.equals(v1.add(v2)));
    }

    @Test
    public void testSprod() {
        NVector v1 = new NVector(1, 2, 3);
        NVector v2 = new NVector(4, 5, 6);
        assertEquals(32, v1.sprod(v2), 0.001);
    }

    @Test
    public void testToString() {
        NVector vec = new NVector(2.63, 3.14, 1.41);
        assertEquals("[2.63 3.14 1.41]", vec.toString());
    }
}

