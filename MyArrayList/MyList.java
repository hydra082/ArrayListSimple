package MyArrayList;

import java.util.Comparator;

public interface MyList <E> extends Iterable <E> {
    boolean add (E e);
    boolean add (int index, E e);
    E get(int index);
    void remove(int index);
    void clear();
    int size();
    void update(int index, E e);
    void sort(Comparator<E> comparator);
    void quickSort();
}
