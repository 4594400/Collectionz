package enterprise.module_1;

import java.util.Collection;
import java.util.Random;

/**
 * Created by administrator on 30.05.2016.
 */
public abstract class CommonCollection {
    public static final int count = 100;


    // just populate collection before evaluation
    public void populateCollection(Collection collection, int size) {
        collection.clear();
        for (int i = 0; i < size; i++) {
            collection.add(i);
        }
    }

    public abstract long add(Collection collection, int size);

    public abstract long remove(Collection collection, int size);

    public long contains(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.contains(randInt(0, size));
        }
        return (System.nanoTime() - startTime) / count;
    }

    public long populate(Collection collection, int size) {
        long sum = 0;

        for (int i = 0; i < count; i++) {
            collection.clear();
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                collection.add(randInt(0, size));
            }
            long endTime = System.nanoTime();
            sum += (endTime - startTime);
        }
        return sum / count;
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }




}
