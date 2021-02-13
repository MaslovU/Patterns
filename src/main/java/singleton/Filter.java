package singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;
    private int count;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer integer : source) {
            if (integer > treshold) {
                logger.log("Элемент \" " + integer + " \" проходит");
                result.add(integer);
                count++;
            } else {
                logger.log("Элемент \" " + integer + " \" не проходит");
            }
        }
        logger.log("Прошло фильтр " + count + " элемента из " + source.size() + ")");
        return result;
    }
}
