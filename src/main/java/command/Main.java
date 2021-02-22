package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String customCommand;
        int step = 0;
        List<FrogCommand> commands = new ArrayList<>();
        List<Integer> steps = new ArrayList<>();
        List<Integer> canceledSteps = new ArrayList<>();
        int curCommand = -1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Frog frog = new Frog();

        System.out.println("+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");

        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            customCommand = reader.readLine();
            if (customCommand.equals("0")) break;

            if (customCommand.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    step = steps.get(curCommand);
                    commands.get(curCommand).undoMove(step);
                    canceledSteps.add(0, step);
                    curCommand--;
                }
            } else if (customCommand.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    step = canceledSteps.get(0);
                    commands.get(curCommand).doMove(step);
                }
                canceledSteps.remove(0);
            } else if (customCommand.equals("!!")) {
                if (curCommand < 0) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(curCommand).doMove(step);
                }
            } else {
                //пользователь ввёл новое движение для лягушки
                step = Integer.parseInt(customCommand);
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                    for (int s: canceledSteps) {
                        steps.remove(steps.indexOf(s));
                    }
                    canceledSteps.clear();
                }
                try {
                    FrogCommand cmd = FrogCommands.jumpRightCommand(frog, step);
                    steps.add(step);
                    curCommand++;
                    commands.add(cmd);
                    cmd.doMove(step);
                } catch (Exception e) {
                    System.out.println("Вы превысили размеры болота! Введите иное число!");
                }
            }
            //рисуем поле после команды
            System.out.println("Current position is: " + frog.getPosition());
            System.out.println("Executed steps is: " + steps);
            System.out.println("Canceled steps is: " + canceledSteps);
        }
    }
}
