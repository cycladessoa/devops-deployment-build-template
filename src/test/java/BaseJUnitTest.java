import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class BaseJUnitTest {

    @BeforeClass
    public static void setUpBefore() throws Exception {
    }

    @AfterClass
    public static void tearDownAfter() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void HelloWorld_test () throws Exception {
        boolean hasFailed = !HelloWorld.helloWorld().equals("Hello World!");
        if (hasFailed) {
            errorCollector.addError(new AssertionError("Something has failed in my JUnit test!"));
        } else {
            System.out.println("HelloWorld_test succeeded");
        }
    }

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();
}
