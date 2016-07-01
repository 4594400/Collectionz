package enterprise.module_1;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ComparingList extends CommonCollection {


    @Override
    public long add(Collection collection, int size) {
        populateCollection(collection, size);

        final long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            ((List<Integer>) collection).add(randInt(0, size), randInt(0, size));
        }
        return (System.nanoTime() - startTime) / count;
    }

    // additional
    public long get(List list, int size) {
        populateCollection(list, size);

        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            list.get(randInt(0, size - 1));
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

    // additional
    public long listIteratorAdd(List list, int size) {
        populateCollection(list, size);

        int i = 0;
        ListIterator<Integer> iterator = list.listIterator();
        final long startTime = System.nanoTime();

        while (i < count) {
            iterator.add(randInt(0, size));
            i++;
        }
        return (System.nanoTime() - startTime) / count;
    }

    // additional
    public long listIteratorRemove(List list, int size) {
        populateCollection(list, size);

        ListIterator<Integer> iterator = list.listIterator();
        final long startTime = System.nanoTime();

        int i = 0;
        while (i < count) {
            iterator.next();
            iterator.remove();
            i++;
        }
        return (System.nanoTime() - startTime) / count;
    }


}
