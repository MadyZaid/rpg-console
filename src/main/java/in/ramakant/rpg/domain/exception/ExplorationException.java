package in.ramakant.rpg.domain.exception;

public class ExplorationException extends Exception {
    private static final long serialVersionUID = -6841138763810526871L;

    public ExplorationException(String message) {
        super(message);
    }

    public static void cannotGo(int index) throws ExplorationException {
        throw new ExplorationException("Invalid move! Please mind the boundaries.");
    }
}
