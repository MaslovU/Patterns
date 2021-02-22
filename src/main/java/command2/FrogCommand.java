package command2;

public interface FrogCommand {
    boolean doMove(int step);

    boolean undoMove(int step);
}