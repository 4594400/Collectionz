package enterprise.module_1;

import java.util.Collection;

public class ComparingSet extends CommonCollection {


    @Override
    public long add(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.add(randInt(0, size));
        }
        return (System.nanoTime() - startTime) / count;
    }

    @Override
    public long remove(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.remove(randInt(0, size - i - 1));
        }
        return (System.nanoTime() - startTime) / count;
    }


}



