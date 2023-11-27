package pages;

public enum ErrorMessageLoginPage {

    ERROR_ITEM_LEVEL("Please enter your password"),
    ERROR_PAGE_LEVEL("Invalid username or password."),
    ERROR_PAGE_LEVEL_Block("Your account is temporarily locked to prevent unauthorized use. Try again later.");

    private final String message;

    ErrorMessageLoginPage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }



}
