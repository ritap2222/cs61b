import static org.junit.Assert.*;
import org.junit.Test;

public class testFlik {
    @Test
    public void testSame() {
        int A = 100;
        int B = 100;
        //exp means A always equal B
        boolean expS = Flik.isSameNumber(A, B);
        //if exp is true, assertTrue will pass, if A != B, assertTrue will fail
        assertTrue(expS);
    }
}
