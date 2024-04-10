package exception;

public class RideAlreadyAssigned extends RuntimeException {
    private String message;

    public RideAlreadyAssigned(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
