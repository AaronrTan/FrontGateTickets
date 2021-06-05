package FrontGateTickets.UIElements;

import org.openqa.selenium.By;

public class OrderConfirmation {

    private By confirmationThanks = By.xpath("//h2[text()='Thank you!']");
    private By orderNumber = By.xpath("//div[@class='order-number']//span[1]");

    public By getOrderNumber() {
        return orderNumber;
    }

    public By getConfirmationThanks() {
        return confirmationThanks;
    }

}
