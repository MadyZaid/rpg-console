package in.ramakant.rpg.common.exceptions;

public class DependencyException extends RuntimeException {
    private static String ERROR_MESSAGE = "Dependency exception occurred. Shutting down everything.";

    public DependencyException() {
        super(ERROR_MESSAGE);
    }

    public DependencyException(Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }
}
