package command2;

public class JumpLeftCommand implements FrogCommand{
    private final int step;
    Frog frog;

    public JumpLeftCommand(Frog frog, int step) {
        this.frog = frog;
        this.step = step;
    }

    @Override
    public boolean doMove(int step) {
        if (frog.jump(step)) {
            int pos = frog.getPosition();
            frog.setPosition(pos + step);
            return true;
        }
        return false;
    }

    @Override
    public boolean undoMove(int step) {
        int pos = frog.getPosition();
        frog.setPosition(pos - step);
        return true;
    }
}
