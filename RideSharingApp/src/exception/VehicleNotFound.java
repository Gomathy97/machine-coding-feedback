package exception;

public class VehicleNotFound extends RuntimeException {
    private String message;

    public VehicleNotFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
