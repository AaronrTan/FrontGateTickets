package FrontGateTickets.UIElements;

import org.openqa.selenium.By;

public class SignUp {
    private By signUpButton = By.xpath("//span[text()='Create an Account']");
    private By firstNameTextBox = By.id("create_firstName");
    private By lastNameTextBox = By.id("create_lastName");
    private By emailTextBox = By.id("create_email");
    private By password1TextBox = By.id("create_new_password");
    private By password2TextBox = By.id("create_confirm_password");
    private By createAccountButton = By.xpath("//span[text()='Create Account']");

    public By signUpButton() {
        return signUpButton;
    }

    public By getFirstNameTextBox() {
        return firstNameTextBox;
    }

    public By getLastNameTextBox() {
        return lastNameTextBox;
    }

    public By getEmailTextBox() {
        return emailTextBox;
    }

    public By getPassword1TextBox() {
        return password1TextBox;
    }

    public By getPassword2TextBox() {
        return password2TextBox;
    }

    public By getCreateAccountButton() {
        return createAccountButton;
    }
}
