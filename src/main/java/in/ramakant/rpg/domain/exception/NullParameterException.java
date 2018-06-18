package in.ramakant.rpg.domain.exception;

public class NullParameterException extends GameException {
    private static final long serialVersionUID = 3257073819570835178L;

    public NullParameterException(String valueType) {
        super(valueType + " cannot be null");
    }
}
