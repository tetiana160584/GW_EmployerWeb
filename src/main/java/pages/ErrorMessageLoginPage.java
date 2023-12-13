package pages;

public enum ErrorMessageLoginPage {

    ERROR_ITEM_LEVEL("Please enter your password"),
    ERROR_PAGE_LEVEL("Invalid username or password."),
    ERROR_PAGE_LEVEL_Block("Your account is temporarily locked to prevent unauthorized use. Try again later.");

    private final String errorMessage;

    ErrorMessageLoginPage(String message) {
        this.errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }



}
