package api;

import org.junit.Test;
import com.eviware.soapui.tools.SoapUIMockServiceRunner;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

/**
 * Created by Alexandra Kolpakova on 29.07.2018.
 */
public class CalculatorWebServiceTest {

    @Test
    public void testCalculatorService() throws Exception {
        SoapUITestCaseRunner testCaseRunner = new SoapUITestCaseRunner();
        SoapUIMockServiceRunner mockServiceRunner = new SoapUIMockServiceRunner();

        testCaseRunner.setProjectFile("src/main/resources/soap/testCalc-soapui-project.xml");
        mockServiceRunner.setProjectFile("src/main/resources/soap/testCalc-soapui-project.xml");
        mockServiceRunner.run();
        testCaseRunner.run();
    }
}
