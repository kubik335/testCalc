import org.junit.After;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Alexandra Kolpakova on 28.07.2018.
 */
public class AdditionTest {
    private String testCalcURL = "http://localhost:6363/testCalc/webUI";
    Random random = new Random();
    int val1, val2;

    @Test
    public void additionRandomTest() {
        DriverManager.loadWebPage(testCalcURL);
        val1 = random.nextInt();
        val2 = random.nextInt();

        CalculatorGUI calc = new CalculatorGUI(DriverManager.getWebDriver());
        calc.verifyCalculatorLoadedCorrectly()
                .verifyOperation(val1, val2, Operations.OperationsTypes.ADDITION);
    }

    @Test
    public void additionMAXValuesTest() {
        DriverManager.loadWebPage(testCalcURL);
        val1 = Integer.MAX_VALUE;
        val2 = Integer.MAX_VALUE;

        CalculatorGUI calc = new CalculatorGUI(DriverManager.getWebDriver());
        calc.verifyCalculatorLoadedCorrectly()
                .verifyOperation(val1, val2, Operations.OperationsTypes.ADDITION);
    }

    @Test
    public void additionMINValuesTest() {
        DriverManager.loadWebPage(testCalcURL);
        val1 = Integer.MIN_VALUE;
        val2 = Integer.MIN_VALUE;

        CalculatorGUI calc = new CalculatorGUI(DriverManager.getWebDriver());
        calc.verifyCalculatorLoadedCorrectly()
                .verifyOperation(val1, val2, Operations.OperationsTypes.ADDITION);
    }

    @After
    public void tearDown() {
        DriverManager.closeBrowser();
    }
}
