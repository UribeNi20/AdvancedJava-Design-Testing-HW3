package q3_2;
import org.junit.*;
import static org.junit.Assert.*;

public class TestNVector {

    @Test
    public void testEquals() {
        System.out.println("run test equals");
        double a = 1, b = 2, c = 3, d = 4;
        NVector x = new NVector(a, b, c, d);
        NVector y = new NVector(a, b, c, d);
        assertTrue(x.equals(y));
    }

    @Test
    public void testVarargConstructor() {
        System.out.println("run test vararg constructor");
        double a = 1, b = 2, c = 3, d = 4;
        NVector vec = new NVector(a, b, c, d);
        assertTrue(vec.equals(new NVector(1.0, 2.0, 3.0, 4.0)));
    }

    @Test
    public void testLength() {
        System.out.println("run test length");
        double a = 1, b = 2, c = 3, d = 4;
        NVector vec = new NVector(a, b, c, d);
        assertEquals(4, vec.length());
    }

    @Test
    public void testGet() {
        System.out.println("run test get");
        double a = 5, b = 6, c = 7;
        NVector x = new NVector(a, b, c);
        assertEquals(a, x.get(0), 0.001);
        assertEquals(b, x.get(1), 0.001);
        assertEquals(c, x.get(2), 0.001);
    }

    @Test
    public void testSet() {
        System.out.println("run test set");
        NVector w = new NVector(3,2,0);
        NVector expected = new NVector(3,-5,0);
        assertTrue(expected.equals(w.set(1,-5)));
    }

    @Test
    public void testAdd() {
        System.out.println("run test add");
        double a = 1, b = 2, c = 3, d = 4, e = 5, f = 6;
        NVector x = new NVector(a, b, c);
        NVector y = new NVector(d, e, f);
        NVector result = x.add(y);
        NVector expected = new NVector(5,7,9);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testSprod() {
        System.out.println("run test sprod");
        double a = 1, b = 2, c = 3, d = 4, e = 5, f = 6;
        NVector x = new NVector(a, b, c);
        NVector y = new NVector(d, e, f);
        double result = x.sprod(y);
        assertEquals(32, result, 0.001);
    }

    @Test
    public void testToString() {
        System.out.println("run test toString");
        double a = 2.63, b = 3.14, c = 1.41;
        NVector vec = new NVector(a, b, c);
        assertTrue(vec.toString().equals("[" + a + " " + b + " " + c + "]"));
    }
}
