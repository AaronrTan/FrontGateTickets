package FrontGateTickets.UIElements;

import org.openqa.selenium.By;

public class EventDetail {

    private By plusSign = By.xpath("//span[@class='glyphicon glyphicon-plus']");
    private By addCartButton = By.id("btn-add-cart");

    public By getAddCartButton() {
        return addCartButton;

    }

    public By getPlusSign() {
        return plusSign;

    }

}
