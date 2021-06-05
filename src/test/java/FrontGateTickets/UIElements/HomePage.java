package FrontGateTickets.UIElements;

import org.openqa.selenium.By;

public class HomePage {
    private By textEvents = By.id("events");
    private By eventName = By.linkText("edc test event");
    private By eventLocation = By.xpath("(//li[@class='location'])[2]");
    private By selectTicketsButton = By.xpath("(//a[contains(@class,'btn btn-primary')])[2]");

    public By getSelectTicketsButton() {
        return selectTicketsButton;

    }

    public By getTextEvents() {
        return textEvents;

    }

    public By getEventName() {
        return eventName;

    }

    public By getEventLocation() {
        return eventLocation;

    }

}
