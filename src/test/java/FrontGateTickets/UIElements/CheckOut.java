package FrontGateTickets.UIElements;

import org.openqa.selenium.By;


public class CheckOut {

    private By checkOutButton = By.id("btn-cart-success");
    private By shippingDropdownn = By.name("shippingId[]");
    private By nextButton = By.id("btn-shipping-submit");
    private By creditCardButton = By.id("creditCardPmButton");
    private By iFrameCardNumber = By.id("braintree-hosted-field-number");
    private By creditCardNumberField = By.id("credit-card-number");
    private By creditCardCcvField = By.id("cvv");
    private By iFrameCardCcv = By.id("braintree-hosted-field-cvv");
    private By iFrameCardMonth = By.id("braintree-hosted-field-expirationMonth");
    private By iFrameCardYear = By.id("braintree-hosted-field-expirationYear");
    private By creditCardMonthField = By.id("expiration-month");
    private By billingPhoneField = By.id("billing_phone");
    private By creditCardYearField = By.id("expiration-year");
    private By billingCityField = By.id("billing_city");
    private By billingStateDropdown = By.id("billing_select_state");
    private By billingZipField = By.id("billing_zip");
    private By billingAddressField = By.id("billing_address");
    private By nextButton2 = By.xpath("(//span[text()='Next'])[2]");
    private By noInsuranceButton = By.id("btn-insurance-no");
    private By agreeTermsCheckBox = By.id("confirm_agree_terms");
    private By purchaseTicketsButton = By.id("purchase_tickets");
    private By billingSubmitButton = By.id("btn-billing-submit");


    public By getBillingSubmitButton() {
        return billingSubmitButton;
    }

    public By getCheckOutButton() {
        return checkOutButton;
    }

    public By getShippingDropdownn() {
        return shippingDropdownn;
    }

    public By getNextButton() {
        return nextButton;
    }

    public By getCreditCardButton() {
        return creditCardButton;
    }

    public By getiFrameCardNumber() {
        return iFrameCardNumber;
    }

    public By getCreditCardNumberField() {
        return creditCardNumberField;
    }

    public By getiFrameCardCcv() {
        return iFrameCardCcv;
    }

    public By getCreditCardCcvField() {
        return creditCardCcvField;
    }

    public By getiFrameCardMonth() {
        return iFrameCardMonth;
    }

    public By getCreditCardMonthField() {
        return creditCardMonthField;
    }

    public By getiFrameCardYear() {
        return iFrameCardYear;
    }

    public By getCreditCardYearField() {
        return creditCardYearField;
    }

    public By getBillingPhoneField() {
        return billingPhoneField;
    }

    public By getBillingAddressField() {
        return billingAddressField;
    }

    public By getBillingCityField() {
        return billingCityField;
    }

    public By getBillingStateDropdown() {
        return billingStateDropdown;
    }

    public By getBillingZipField() {
        return billingZipField;
    }

    public By getNextButton2() {
        return nextButton2;
    }

    public By getNoInsuranceButton() {
        return noInsuranceButton;
    }

    public By getAgreeTermsCheckBox() {
        return agreeTermsCheckBox;
    }

    public By getPurchaseTicketsButton() {
        return purchaseTicketsButton;
    }

}
