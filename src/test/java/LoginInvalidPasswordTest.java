import org.junit.Test;
import static org.junit.Assert.*;

public class LoginInvalidPasswordTest {

    @Test
    public void testInvalidUserPass1() {
        assertEquals(false, LoginApp.isvalidLogin("johndoe@example.com","wrong123"));
    }
    @Test
    public void testInvalidUserPass2() {
        assertEquals(false, LoginApp.isvalidLogin("janesmith@example.com","wrong456"));
    }
    @Test
    public void testInvalidUserPass3() {
        assertEquals(false, LoginApp.isvalidLogin("mikejohnson@example.com","wrong789"));
    }
    @Test
    public void testInvalidUserPass4() {
        assertEquals(false, LoginApp.isvalidLogin("alicebrown@example.com","wrong101"));
    }
    @Test
    public void testInvalidUserPass5() {
        assertEquals(false, LoginApp.isvalidLogin("tomclark@example.com","wrong202"));
    }


}
