package command2;

public class FrogCommands {

    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        if (steps > 0) return new JumpRightCommand(frog, steps);
        else return new JumpLeftCommand(frog, steps);
    }
}