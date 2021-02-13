package singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Logger logger = Logger.getInstance();
        Random random = new Random();

        logger.log("Greeting User");
        System.out.println("Hello, User!");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Enter size of list: ");
        int size = Integer.parseInt(reader.readLine());

        System.out.println("Enter the upper bound for the values of the elements in the list: ");
        int border = Integer.parseInt(reader.readLine());

        logger.log("Создаём и наполняем список");
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            myList.add(random.nextInt(border));
        }

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filterValue = Integer.parseInt(reader.readLine());
        List<Integer> res = new Filter(filterValue).filterOut(myList);

        logger.log("Выводим результат на экран");
        System.out.println(res);
        logger.log("Завершаем программу!");
    }
}
