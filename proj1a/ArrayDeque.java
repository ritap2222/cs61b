public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;
    private int remainFirst;
    private int remainlast;
    private int reSizeCount = 0;
    private int remainSize;




    public ArrayDeque() {
        items = (T[]) new Object[4];
        size = 0;
        first = items.length - 1;
        last = 0;
    }

    /**addFirst will change prev*/
    public void addFirst(T m) {
        size = size + 1;
        if (size > items.length) {
            remainSize = size - 1;
            reSize();
            items[first] = m;
            first = first - 1;
        } else {
            items[first] = m;
            first = first - 1;
            if (first < 0) {
                first = items.length - 1;
            }
        }
    }


    /**addLast will change next*/
    public void addLast(T m) {
        size = size + 1;
        if (size > items.length) {
            remainSize = size - 1;
            reSize();
            items[last] = m;
            last = last + 1;
        } else {
            items[last] = m;
            last = last + 1;
            if (last > items.length - 1) {
                last = 0;
            }
        }
    }

    /**make bigger size*/
    public void reSize() {
        reSizeCount = reSizeCount + 1;
        T[] temp = (T[]) new Object[size * 2];
        System.arraycopy(items, 0, temp, 0, size - 1);
        items = temp;
        remainFirst = first + 1;
        remainlast = last - 1;
        first = items.length - 1;
        last = size - 1;
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
        if (size == 0) {
            return null;
        } else {
            size = size - 1;
            first = first + 1;
            if (first == items.length && reSizeCount == 0) {
                first = 0;
            } else if (first == items.length && reSizeCount > 0) {
                first = remainFirst;
            }
            T temp = items[first];
            items[first] = null;
            return temp;
        }


    }

    public  T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size = size - 1;
            last = last - 1;
            if (last < 0 && reSizeCount == 0) {
                last = items.length - 1;
            } else if (reSizeCount > 0) {
                last = remainlast;
                remainlast = remainSize - 1;
            }
            T temp = items[last];
            items[last] = null;
            return temp;
        }


    }

   /**public T get(int index) {

    }*/


   public static void main(String[] args) {
       /**ArrayDeque ArrayDeque = new ArrayDeque();
       ArrayDeque.addFirst(1);
       ArrayDeque.addLast(2);
       ArrayDeque.addFirst(3);
       ArrayDeque.addFirst(4);
       ArrayDeque.addLast(5);
       ArrayDeque.addLast(6);
       ArrayDeque.removeLast();
       ArrayDeque.removeLast();
       ArrayDeque.removeLast();
       ArrayDeque.removeLast();
       ArrayDeque.addFirst(7);
       ArrayDeque.removeLast();//1
       ArrayDeque.addFirst(7);
       ArrayDeque.addFirst(8);
       ArrayDeque.addFirst(9);
       ArrayDeque.removeLast();//2
       ArrayDeque.addFirst(10);
       ArrayDeque.addFirst(11);
       ArrayDeque.addFirst(12);
       ArrayDeque.addFirst(13);
       ArrayDeque.addFirst(14);
       ArrayDeque.removeLast();//3
       ArrayDeque.addFirst(15);
       ArrayDeque.addFirst(16);
       ArrayDeque.addFirst(17);
       ArrayDeque.removeLast();//4
       ArrayDeque.removeLast();//5
       ArrayDeque.removeLast();//6
       ArrayDeque.addFirst(18);
       ArrayDeque.addFirst(19);
       ArrayDeque.addFirst(20);
       ArrayDeque.addFirst(21);
       ArrayDeque.addFirst(22);
       ArrayDeque.removeLast();//7
       ArrayDeque.addFirst(23);
       ArrayDeque.removeLast();//8
       ArrayDeque.addFirst(24);
       ArrayDeque.addFirst(25);
       ArrayDeque.addFirst(26);
       ArrayDeque.addFirst(27);
       ArrayDeque.addFirst(28);
       ArrayDeque.removeLast();//9
       ArrayDeque.addFirst(29);
       ArrayDeque.addFirst(30);
       ArrayDeque.addFirst(31);
       ArrayDeque.removeLast();//10
       ArrayDeque.removeLast();//11
       ArrayDeque.removeLast();*/
   }

}
