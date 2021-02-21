package iterator;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected Integer[] arrayList;
    private final int currentSize;

    public Randoms(int min, int max) {
        currentSize = max - min;
        arrayList = new Integer[currentSize];
        for (int i = 0; i < currentSize; i++) {
            arrayList[i] = min;
            min++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                int currentIndex = 0;
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Integer next() {
                random = new Random();
                return arrayList[random.nextInt(currentSize)];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
