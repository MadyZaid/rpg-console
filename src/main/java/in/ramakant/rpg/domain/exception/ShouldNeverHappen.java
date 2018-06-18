package in.ramakant.rpg.domain.exception;

public class ShouldNeverHappen extends GameException {
    private static final long serialVersionUID = -5046388791802845703L;

    public ShouldNeverHappen() {
        super("Should never happen");
    }
}
