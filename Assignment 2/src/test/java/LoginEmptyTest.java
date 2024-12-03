import org.junit.Test;
import static org.junit.Assert.*;

public class LoginEmptyTest {

    @Test
    public void testEmptyEmail() {
        assertEquals(false, LoginApp.isvalidLogin("","password123"));
    }
    @Test
    public void testEmptyPassword() {
        assertEquals(false, LoginApp.isvalidLogin("mikejohnson@example.com",""));
    }
    @Test
    public void testBothEmpty() {
        assertEquals(false, LoginApp.isvalidLogin("", ""));
    }
}
