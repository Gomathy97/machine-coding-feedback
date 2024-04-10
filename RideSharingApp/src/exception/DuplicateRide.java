package exception;

public class DuplicateRide extends RuntimeException {
    private String message;

    public DuplicateRide(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
