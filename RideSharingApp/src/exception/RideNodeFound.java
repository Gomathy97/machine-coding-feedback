package exception;

public class RideNodeFound extends RuntimeException {
    private String message;

    public RideNodeFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
