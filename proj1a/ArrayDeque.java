public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;





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
            reSizeP();
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
            reSizeP();
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
        T[] temp = (T[]) new Object[size * 2];
        //System.arraycopy(items, 0, temp, 0, size - 1);
        copyHelp(temp);
        items = temp;
        first = items.length - 1;
        last = size - 1;
    }

    public void reSizeP() {
        if (first == items.length - 1 && last == 0) {
            first = 0;
            last =  items.length - 1;
        } else if (first < items.length - 1 || last >= 0) {
            last = last - 1;
            first = first + 1;
        }
    }

    public void copyHelp(T[] temp) {
        System.arraycopy(items, first, temp, 0, size - 1 - first);
        int lastC = size - 1 - (size - 1 - first);
        System.arraycopy(items, last + 1 - lastC, temp, size - 1 - first, lastC);
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
            if (first > items.length - 1) {
                first = 0;
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
            if (last < 0) {
                last = items.length - 1;
            }
            T temp = items[last];
            items[last] = null;
            return temp;
        }


    }

   public T get(int index) {
       if (index == items.length - 1 && items[index] == null) {
           return items[0];
       } else if (index == 0 && items[index] == null) {
           return items[items.length - 1];
       }
       return items[index];
   }


   /**public static void main(String[] args) {
       ArrayDeque ArrayDeque = new ArrayDeque();
       ArrayDeque.addFirst(0);
       ArrayDeque.get(0);
   }*/

}
