package in.ramakant.rpg.common.exceptions;

public class UserInputParseException extends RuntimeException {
    private static final long serialVersionUID = -5594047774616555874L;

    private static final String MESSAGE = "After many attempts user could not enter any valid input. Game will shut down. Good luck next time!";

    public UserInputParseException(String message) {
        super(message);
    }

    public UserInputParseException() {
        super(MESSAGE);
    }

    public UserInputParseException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
