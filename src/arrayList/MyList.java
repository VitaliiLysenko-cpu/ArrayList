package arrayList;

import java.util.Collection;

public interface MyList <E> extends Iterable <E>{
    int size();
    boolean isEmpty();
    boolean contains(E e);
    E add (E e);
    boolean addAll(Collection c);
    E get(int index);
    E set(int index, E e);
    void remove(int index);
    void remove(E e);
    void clear();
    void toArray(E e);
}
