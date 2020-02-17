 package arrayList;

 import java.util.Arrays;
 import java.util.Collection;
 import java.util.Iterator;


 public class MyArrayList<E> implements MyList<E> {


    private static final Object[] EMPTY_ELEMENTDATA = {};
    private E[] values;
    private int curSize;

    public MyArrayList(Collection<E> collection) {
        values = (E[]) new Object[collection.size()];
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            values[curSize] = iterator.next();
            curSize++;
        }
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.values = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.values = (E[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public MyArrayList() {
        values = (E[]) new Object[10];
        curSize = 0;
    }

    @Override
    public int size() {
        return curSize;
    }

    @Override
    public boolean isEmpty() {
        return curSize == 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < curSize; i++) {
            if (values[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E e) {
        if (size() == values.length) {
            E[] temp = values;
            values = (E[]) new Object[(int) (values.length * 1.5)];
            System.arraycopy(temp, 0, values, 0, curSize);
        }
        values[curSize] = e;
        curSize++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    public int getCurSize() {
        return curSize;
    }

    @Override
    public E get(int index) {
        if (index >= curSize) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива  ");
        }
        return values[index];
    }

    @Override
    public E set(int index, E e) {
        if (index > curSize) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива ");
        }
        return values[index] = e;
    }

    @Override
    public void remove(int index) {

        for (int i = index; i < curSize; i++) {
            values[i] = values[i + 1];
        }
        curSize--;
    }

    @Override
    public void remove(E e) {
        for (int i = 0; i < curSize; i++) {
            if (values[i].equals(e)) {
                int index = i;
                remove(index);
            }
            curSize--;
        }
    }

     @Override
     public <T> T[] toArray(T[] a) {
        return(T[])  Arrays.copyOf(values, curSize, a.getClass());
    }

    @Override
    public void clear() {
        values = (E[]) new Object[values.length];
        curSize = 0;
    }

 @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }
 }
// forEach перебирає кожен елемент масиву.