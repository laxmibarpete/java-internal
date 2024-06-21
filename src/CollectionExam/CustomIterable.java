package CollectionExam;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterable<T> implements Iterable<T> {


    private  T[]items;

    private int size;
    public CustomIterable(int capacity){
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element){
        if (size >= items.length) {
            throw new IllegalStateException("Collection is full");
        }
          items[size] = element;
          size += 1;
    }


    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }


    class CustomIterator implements Iterator<T> {
        int counter = 0;
        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[counter++];
        }
    }

}
