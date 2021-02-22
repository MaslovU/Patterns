package command;

class FrogCommands implements FrogCommand{
    Frog frog;

    public FrogCommands(Frog frog) {
        this.frog = frog;
    }

    public static FrogCommand jumpRightCommand(Frog frog, int steps) throws Exception {
        FrogCommand frogCommands = new FrogCommands(frog);
        // возвращаете объект команды, у которого
        // если вызвать .doMove(), то лягушка её выполнит,
        // если вызвать .undoMove(), то лягушка её отменит
        if (frog.jump(steps)) {
            return frogCommands;
        } else {
            throw new Exception();
        }
    }

    @Override
    public void doMove(int steps) {
        int pos = frog.getPosition();
        frog.setPosition(pos + steps);
    }

    @Override
    public void undoMove(int steps) {
        int pos = frog.getPosition();
        frog.setPosition(pos - steps);

    }
}
