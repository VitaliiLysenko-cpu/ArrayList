package arrayList;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

    private E[] values;
    private int curSize;


    public MyArrayList() {
        values = (E[]) new Object[10];
        curSize = 0;
    }


    public int curSize() {
        return curSize;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        if (values.length == 0) return true;
        else return false;
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
    public E add(E e) {
        if (size() == curSize) {
            E[] temp = values;
            values = (E[]) new Object[(int) values.length * 3 / 2];
            System.arraycopy(temp, 0, values, 0, curSize);
            values[curSize] = e;
            curSize++;
        } else {
            values[curSize] = e;
            curSize++;

        }
        return values[curSize - 1];
    }

    @Override
    public boolean addAll() {
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= curSize)
            throw new ArrayIndexOutOfBoundsException();
        try {
            if (index < curSize) {
                return  values[index];
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.print("Выход за пределы массива  ");
        }
        return null;
    }


    @Override
    public E set(int index, E e) {
        if (index > curSize)
            throw new IllegalStateException();
        try {
            if (index <= curSize) {
                return values[index] = e;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.print("Выход за пределы массива  ");
        }

        return null;
    }


    @Override
    public void remove(int index) {

        for (int i = index; i < curSize - 1; i++) {
           values[i] = values[i + 1];
        }
        curSize--;
    }

    @Override
    public void clear() {
        values = (E[]) new Object[10];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }
}
