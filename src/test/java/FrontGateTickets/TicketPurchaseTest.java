package FrontGateTickets;


import FrontGateTickets.UIElements.*;
import FrontGateTickets.Utility.ConstantVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketPurchaseTest {
    WebDriver driver;
    HomePage homePage = new HomePage();
    EventDetail eventDetail = new EventDetail();
    SignUp signUp = new SignUp();
    CheckOut checkOut = new CheckOut();
    OrderConfirmation orderConfirmation = new OrderConfirmation();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //For testing in FireFox Browser
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        //For testing in Edge Browser
       //WebDriverManager.edgedriver().setup();
       // driver=new EdgeDriver();

        //For testing IE
       // WebDriverManager.iedriver().setup();
       // driver=new InternetExplorerDriver()

    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void newAccountTicketPurchase() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get(ConstantVariables.homeUrl);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Log.startTestCase("Purchasing Ticket With A New Account Test");

        //Synchronize the home page, a reference object to understand homepage is landed
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getEventName()));

        // Assert the event name "edc test event" is displayed
        Log.info("Event Name: " + driver.findElement(homePage.getEventName()).getText());
        Log.info("Event Location: " + driver.findElement(homePage.getEventLocation()).getText());

        Assert.assertTrue(driver.findElement(homePage.getEventName()).isDisplayed(), "edc test event text is not displayed");
        Assert.assertTrue(driver.findElement(homePage.getEventName()).getText().equals(ConstantVariables.eventName), "Event location is wrong");

        // Assert the event location "South Austin Recreation Centah (Park)" is displayed and spelling is correct
        Assert.assertTrue(driver.findElement(homePage.getEventLocation()).isDisplayed(), "Event location is not displayed");
        Assert.assertTrue(driver.findElement(homePage.getEventLocation()).getText().equals(ConstantVariables.eventLocation), "Event location is wrong");

        driver.findElement(homePage.getSelectTicketsButton()).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Find Sold Out Event

        List<WebElement> eventName = driver.findElements(By.xpath("//div[contains(@class,'col-sm-6 text-left')]"));
        List<WebElement> ticketStatus = driver.findElements(By.xpath("//div[contains(@class,'col-sm-2 quantity')]"));
        for (int i = 0; i < ticketStatus.size(); i++) {
            if (ticketStatus.get(i).getText().equalsIgnoreCase("SOLD OUT")) {
                Log.info("The event " + eventName.get(i).getText() + " tickets are Sold Out");
            }
        }

        // Select the amount of tickets
        driver.findElement(eventDetail.getPlusSign()).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Add to cart
        driver.findElement(eventDetail.getAddCartButton()).click();

        // Wait till searches for the tickets and click on checkout button
        wait.until(ExpectedConditions.presenceOfElementLocated(checkOut.getCheckOutButton()));
        driver.findElement(checkOut.getCheckOutButton()).click();

        // Create new account
        driver.findElement(signUp.signUpButton()).click();

        // Wait till the form loads up
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp.getFirstNameTextBox()));

        // Fill the account info
        driver.findElement(signUp.getFirstNameTextBox()).sendKeys(ConstantVariables.firstName);
        driver.findElement(signUp.getLastNameTextBox()).sendKeys(ConstantVariables.lastName);
        driver.findElement(signUp.getEmailTextBox()).sendKeys(ConstantVariables.email);
        driver.findElement(signUp.getPassword1TextBox()).sendKeys(ConstantVariables.password);
        driver.findElement(signUp.getPassword2TextBox()).sendKeys(ConstantVariables.password);
        driver.findElement(signUp.getCreateAccountButton()).click();

        //Wait till the account is created and checkout page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut.getShippingDropdownn()));

        //Select a delivery option
        WebElement shippingId = driver.findElement(checkOut.getShippingDropdownn());
        new Select(shippingId).selectByIndex(3);
        driver.findElement(checkOut.getNextButton()).click();

        // Wait till payment options loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut.getCreditCardButton()));
        driver.findElement(checkOut.getCreditCardButton()).click();

        // Wait till credit card form loads up
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut.getiFrameCardNumber()));

        driver.switchTo().frame(driver.findElement(checkOut.getiFrameCardNumber()));
        driver.findElement(checkOut.getCreditCardNumberField()).sendKeys(ConstantVariables.creditCardNumber);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(checkOut.getiFrameCardCcv()));
        driver.findElement(checkOut.getCreditCardCcvField()).sendKeys(ConstantVariables.creditCardCcv);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(checkOut.getiFrameCardMonth()));
        driver.findElement(checkOut.getCreditCardMonthField()).sendKeys(ConstantVariables.creditCardMonth);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(checkOut.getiFrameCardYear()));
        driver.findElement(checkOut.getCreditCardYearField()).sendKeys(ConstantVariables.creditCardYear);
        driver.switchTo().defaultContent();

        driver.findElement(checkOut.getBillingPhoneField()).sendKeys(ConstantVariables.billingPhone);
        driver.findElement(checkOut.getBillingAddressField()).sendKeys(ConstantVariables.billingAddress);
        driver.findElement(checkOut.getBillingCityField()).sendKeys(ConstantVariables.billingCity);
        WebElement state = driver.findElement(checkOut.getBillingStateDropdown());
        new Select(state).selectByIndex(2);
        driver.findElement(checkOut.getBillingZipField()).sendKeys(ConstantVariables.billingZip);
        driver.findElement(checkOut.getBillingSubmitButton()).click();

        //Agree the terms
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut.getAgreeTermsCheckBox()));
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(checkOut.getAgreeTermsCheckBox()).click();

        //Complete the purchase
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut.getPurchaseTicketsButton()));
        driver.findElement(checkOut.getPurchaseTicketsButton()).click();

        //Conformation screen and validation
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation.getConfirmationThanks()));
        Assert.assertTrue(driver.findElement(orderConfirmation.getConfirmationThanks()).getText().contains(ConstantVariables.orderConfirmationMessage), "Order is not confirmed");

        Log.info(driver.findElement(orderConfirmation.getConfirmationThanks()).getText());

        //Get and log the order number
        String orderNumber = driver.findElement(orderConfirmation.getOrderNumber()).getText();
        Log.info("Order Number " + orderNumber);
        Log.endTestCase("Purchasing Ticket With A New Account Test");
    }


}


