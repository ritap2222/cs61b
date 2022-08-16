public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size = 0;
    private T initial;

    public LinkedListDeque() {
        sentinel = new TNode(sentinel, initial, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public class TNode {
        TNode prev;
        T item;
        TNode next;

        private TNode(TNode t1, T m, TNode t2) {
            prev = t1;
            item = m;
            next = t2;
        }
    }

    public void addFirst(T item) {
        size = size + 1;
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(T item) {
        size = size + 1;
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (size < 0) {
            return 0;
        } else {
            return size;
        }
    }

    public T removeLast() {
        TNode rL = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return rL.item;
    }

    public T removeFirst() {
        TNode rF = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return rF.item;
    }

    public T get(int index) {
        TNode temp;
        temp = sentinel.next;
        while (index != 0) {
            temp = temp.next;
            index = index - 1;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return this.sentinel.next.item;
        } else {
            this.sentinel = this.sentinel.next;
            return this.getRecursive(index - 1);
        }
    }

    public void printDeque() {
        TNode pp;
        pp = sentinel.next;
        while (size != 0) {
            System.out.print(pp.item);
            System.out.print(" ");
            pp = pp.next;
            size = size - 1;
        }
    }
}
