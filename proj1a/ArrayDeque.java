public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;
    private T[] addIndex;



    public ArrayDeque() {
        addIndex = (T[]) new Object[8];
        items = (T[]) new Object[8];
        size = 0;
        first = items.length - 1;
        last = 0;
    }

    /**addFirst will change prev*/
    public void addFirst(T m) {
        size = size + 1;
        if (size > items.length) {
            reSize();
            reIndex();
            first = items.length - 1;
            items[first] = m;
            addIndex[size - 1] = m;
            first = first - 1;
            last = size - 1;
        } else {
            items[first] = m;
            addIndex[size - 1] = m;
            if (first == 0) {
                first = items.length - 1;
            } else {
                first = first - 1;
            }
        }

    }

    /**addLast will change next*/
    public void addLast(T m) {
        size = size + 1;
        if (size > items.length) {
            reSize();
            reIndex();
            last = size - 1;
            items[last] = m;
            addIndex[size - 1] = m;
            last = last + 1;
            first = items.length - 1;
        } else {
            items[last] = m;
            addIndex[size - 1] = m;
            if (last == items.length - 1) {
                last = 0;
            } else {
                last = last + 1;
            }
        }

    }

    /**make bigger size*/
    public void reSize() {
        T[]temp = (T[]) new Object[size * 2];
        System.arraycopy(items, 0, temp, 0, size - 1);
        items = temp;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (size <= 0) {
            return 0;
        } else {
            return size;
        }
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]);
            System.out.print(" ");
        }
    }

    public T removeFirst() {
        size = size - 1;
        if (first == items.length - 1) {
            first = 0;
        } else {
            first = first + 1;
        }
        T rf = items[first];
        items[first] = null;
        return rf;
    }

    public T removeLast() {
        size = size - 1;
        if (last == 0) {
            last = items.length - 1;
        } else {
            last = last - 1;
        }
        T rl = items[last];
        items[last] = null;
        return rl;
    }

    public T get(int index) {
        return addIndex[index];
    }

    public void reIndex() {
        T[]temp2 = (T[]) new Object[size * 2];
        System.arraycopy(addIndex, 0, temp2, 0, size - 1);
        addIndex = temp2;
    }
}
