import org.junit.Test;
import static org.junit.Assert.*;

public class LoginSQLinjectionTest {

    @Test
    public void testSQLinjectionEmail() {
        assertEquals(false, LoginApp.isvalidLogin("wrongmail\"' OR '1'='1\"","password123"));
    }
    @Test
    public void testSQLinjectionPass() {
        assertEquals(false, LoginApp.isvalidLogin("janesmith@example.com","wrong456\"' OR '1'='1\""));
    }


}
