import org.junit.Test;
import static org.junit.Assert.*;

public class LoginInvalidEmailTest {

    @Test
    public void testInvalidUserEmail1() {
        assertEquals(false, LoginApp.isvalidLogin("johndoe@","password123"));
    }
    @Test
    public void testInvalidUserEmail2() {
        assertEquals(false, LoginApp.isvalidLogin("janesmith@","password456"));
    }
    @Test
    public void testInvalidUserEmail3() {
        assertEquals(false, LoginApp.isvalidLogin("mikejohnson@","password789"));
    }
    @Test
    public void testInvalidUserEmail4() {
        assertEquals(false, LoginApp.isvalidLogin("alicebrown@","password101"));
    }
    @Test
    public void testInvalidUserEmail5() {
        assertEquals(false, LoginApp.isvalidLogin("tomclark@","password202"));
    }


}
