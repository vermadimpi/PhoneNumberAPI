package au.com.belong.phone.util;

public enum Messages {

    PHONE_NOT_FOUND(1,"Phone not found"),
    CUSTOMER_NOT_FOUND(2,"Customer not found");

    private final int errorId;
    private final String errorMessage;

    private Messages(int errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }
}
