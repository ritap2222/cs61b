public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;



    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = items.length - 1;
        last = 0;
    }

    /**addFirst will change prev*/
    public void addFirst(T m) {
        /**size = size + 1;
        if (size > items.length) {
            reSize();
            first = items.length - 1;
            items[first] = m;
            first = first - 1;
            last = size - 1;
        } else {
            items[first] = m;
            if (first == 0) {
                first = items.length - 1;
            } else {
                first = first - 1;
            }
        }*/

        if (size == 0) {
            items[0] = m;
            size = size + 1;
            first = items.length - 1;
            last = 1;
        } else {
            items[first] = m;
            size = size + 1;
            if (first == 0) {
                first = items.length - 1;
            } else {
                first = first - 1;
            }

        }
    }

    /**addLast will change next*/
    public void addLast(T m) {
        /**size = size + 1;
        if (size > items.length) {
            reSize();
            last = size - 1;
            items[last] = m;
            last = last + 1;
            first = items.length - 1;
        } else {
            items[last] = m;
            if (last == items.length - 1) {
                last = 0;
            } else {
                last = last + 1;
            }
        }*/
        if (size == 0) {
            items[0] = m;
            size = size + 1;
            first = items.length - 1;
            last = 1;
        } else {
            items[last] = m;
            size = size + 1;
            if(last == items.length - 1) {
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
        int tempg = first + 1 + index;
        if (tempg >= items.length - 1) {
            tempg = tempg - items.length;
        }
        return items[tempg];
    }

    /**public static void main(String[] args) {
        ArrayDeque ArrayDeque = new ArrayDeque();
        /**ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(10);
        ArrayDeque.addFirst(11);
        ArrayDeque.addFirst(12);
        ArrayDeque.addFirst(13);
        ArrayDeque.addFirst(14);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(15);
        ArrayDeque.addFirst(16);
        ArrayDeque.addFirst(17);
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(18);
        ArrayDeque.addFirst(19);
        ArrayDeque.addFirst(20);
        ArrayDeque.addFirst(21);
        ArrayDeque.addFirst(22);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(23);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(24);
        ArrayDeque.addFirst(25);
        ArrayDeque.addFirst(26);
        ArrayDeque.addFirst(27);
        ArrayDeque.addFirst(28);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(29);
        ArrayDeque.addFirst(30);
        ArrayDeque.addFirst(31);
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();*/

        /**ArrayDeque.addFirst(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addLast(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addLast(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(8);
        ArrayDeque.removeLast();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.get(0);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(15);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(17);
        ArrayDeque.removeFirst();
        ArrayDeque.get(1);
    }*/
}
