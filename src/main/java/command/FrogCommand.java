package command;

public interface FrogCommand {
    void doMove(int step);

    void undoMove(int steps);
}