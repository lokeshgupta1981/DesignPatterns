import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class RecentlyViewed implements Iterable<String> {
    private final String[] items;
    private int nextIndex;
    private int size;
    private int modCount;

    RecentlyViewed(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        items = new String[capacity];
    }

    void add(String item) {
        items[nextIndex] = Objects.requireNonNull(item);
        nextIndex = (nextIndex + 1) % items.length;
        size = Math.min(size + 1, items.length);
        modCount++;
    }

    public Iterator<String> iterator() {
        return new RecentIterator(true);
    }

    Iterable<String> oldestFirst() {
        return () -> new RecentIterator(false);
    }

    private final class RecentIterator implements Iterator<String> {
        private final boolean newestFirst;
        private final int expectedModCount = modCount;
        private int returned;

        RecentIterator(boolean newestFirst) {
            this.newestFirst = newestFirst;
        }

        public boolean hasNext() {
            checkForChanges();
            return returned < size;
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int index = newestFirst
                ? Math.floorMod(nextIndex - 1 - returned, items.length)
                : Math.floorMod(nextIndex - size + returned, items.length);
            returned++;
            return items[index];
        }

        private void checkForChanges() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        RecentlyViewed recent = new RecentlyViewed(3);
        recent.add("Apple");
        recent.add("Banana");
        recent.add("Cherry");
        recent.add("Mango");

        for (String item : recent) {
            System.out.println(item);
        }
        System.out.println("---");
        for (String item : recent.oldestFirst()) {
            System.out.println(item);
        }
    }
}
