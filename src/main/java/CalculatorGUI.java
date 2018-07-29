import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexandra Kolpakova on 28.07.2018.
 */
public class CalculatorGUI {

    @FindBy(name = "val1")
    private WebElement firstValueInput;

    @FindBy(name = "val2")
    private WebElement secondValueInput;

    @FindBy(xpath = "//input[@value=\"add\"]")
    private WebElement additionRadioBtn;

    @FindBy(xpath = "//input[@value=\"sub\"]")
    private WebElement subtractionRadioBtn;

    @FindBy(xpath = "//input[@value=\"mul\"]")
    private WebElement multiplicationRadioBtn;

    @FindBy(xpath = "//input[@value=\"div\"]")
    private WebElement divisionRadioBtn;

    @FindBy(xpath = "//input[@value=\"Calculate\"]")
    private WebElement calculateBtn;

    @FindBy(name = "result")
    private WebElement resultOutput;
    private DriverManager driverManager = DriverManager.getInstance();
    private WebDriver driver;
    private Operations operations = new Operations();

    public CalculatorGUI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorGUI verifyCalculatorLoadedCorrectly() {
        driverManager.waitForElement(By.xpath("//h2[text()='Ataccama TestCalc']"), 4);
        driverManager.waitForElement(By.xpath("//td[text()='Value 1:']"), 4);
        driverManager.waitForElement(By.xpath("//td[text()='Value 2:']"), 4);
        driverManager.waitForElement(By.xpath("//td[text()='Result:']"), 4);
        additionRadioBtn.isDisplayed();
        subtractionRadioBtn.isDisplayed();
        multiplicationRadioBtn.isDisplayed();
        divisionRadioBtn.isDisplayed();
        calculateBtn.isDisplayed();
        resultOutput.isDisplayed();
        return this;
    }

    public CalculatorGUI verifyOperation(int val1, int val2, Operations.OperationsTypes operationsTypes) {
        enterValues(val1, val2);
        choseOperation(operationsTypes);
        calculateBtn.click();
        double actual = Double.parseDouble(getOutput());
        double expected = operations.getResult(val1, val2, operationsTypes);
        Assert.assertTrue("Difference between actual " + actual
                    + " and expected " + expected + " values, for called operation: " + operationsTypes.getType(),
                    actual == expected);
       return this;
    }

    private CalculatorGUI enterValues(int val1, int val2) {
        enterFirstValue(val1);
        enterSecondValue(val2);
        return this;
    }

    private String getOutput() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultOutput.getAttribute("value");
    }

    private CalculatorGUI enterFirstValue(int val1) {
        firstValueInput.clear();
        firstValueInput.sendKeys(Integer.toString(val1));
        return this;
    }

    private CalculatorGUI enterSecondValue(int val2) {
        secondValueInput.clear();
        secondValueInput.sendKeys(Integer.toString(val2));
        return this;
    }

    public void choseOperation(Operations.OperationsTypes operationsTypes){
        switch(operationsTypes) {
            case ADDITION:
                additionRadioBtn.click();
                break;
            case SUBTRACTION:
                subtractionRadioBtn.click();
                break;
            case MULTIPLICATION:
                multiplicationRadioBtn.click();
                break;
            case DIVISION:
                divisionRadioBtn.click();
                break;
            default:
                additionRadioBtn.click();
                break;
        }
    }
}
