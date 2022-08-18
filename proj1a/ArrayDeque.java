public class ArrayDeque<type> {
    private type[] items;
    private int size;
    private int prev;
    private int next;


    public ArrayDeque() {
        items = (type[]) new Object[8];
        size = 0;
        prev = 0;
        next = 0;
    }

    /**addFirst will change prev*/
    public void addFirst(type m) {
        if (size == 0) {
            items[0] = m;
            next = 1;
            prev = items.length - 1;
            size = size + 1;
        } else {
            size = size + 1;
            items[prev] = m;
            prev = prev - 1;
            if (prev < 0) {
                prev = items.length + prev;
            }
        }
    }

    /**addLast will change next*/
    public void addLast(type m) {
        if (size == 0) {
            items[items.length - 1] = m;
            next = 0;
            prev = items.length - 2;
            size = size + 1;
        } else {
            size = size + 1;
            items[next] = m;
            next = next + 1;
            if (next > items.length) {
                next = next - items.length;
            }
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < items.length; i ++) {
            System.out.print(items[i]);
            System.out.print(" ");
        }
    }

    public type removeFirst() {
        type tempf = items[prev];
        items[prev] = null;
        prev = prev - 1;
        size = size - 1;
        return tempf;
    }

    public type removeLast() {
        type templ = items[next];
        items[next] = null;
        next = next + 1;
        size = size - 1;
        return templ;
    }

    public type get(int index) {
        return items[index - 1];
    }
}
