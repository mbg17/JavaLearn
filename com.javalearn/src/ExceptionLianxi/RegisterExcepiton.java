package ExceptionLianxi;

public class RegisterExcepiton extends Exception {
    public RegisterExcepiton() {
    }

    public RegisterExcepiton(String message) {
        super(message);
    }

    public RegisterExcepiton(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterExcepiton(Throwable cause) {
        super(cause);
    }

    public RegisterExcepiton(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
