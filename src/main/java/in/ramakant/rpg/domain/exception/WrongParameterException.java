package in.ramakant.rpg.domain.exception;

public class WrongParameterException extends GameException {
    private static final long serialVersionUID = -234581523821047501L;

    public WrongParameterException(String valueType, String value) {
        super("Provided " + valueType + " value (" + value + ") is not valid");
    }
}
