import org.junit.Test;
import static org.junit.Assert.*;

public class LoginValidTest {

    @Test
    public void testuser1() {
        assertEquals(true, LoginApp.isvalidLogin("johndoe@example.com","password123"));
    }
    @Test
    public void testuser2() {
        assertEquals(true, LoginApp.isvalidLogin("janesmith@example.com","password456"));
    }
    @Test
    public void testuser3() {
        assertEquals(true, LoginApp.isvalidLogin("mikejohnson@example.com","password789"));
    }
    @Test
    public void testuser4() {
        assertEquals(true, LoginApp.isvalidLogin("alicebrown@example.com","password101"));
    }
    @Test
    public void testuser5() {
        assertEquals(true, LoginApp.isvalidLogin("tomclark@example.com","password202"));
    }


}
