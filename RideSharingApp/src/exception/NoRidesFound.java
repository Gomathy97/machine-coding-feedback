package exception;

public class NoRidesFound extends RuntimeException {
    private String message;

    public NoRidesFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
