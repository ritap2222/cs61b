public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size = 0;

    private T initial;

    public LinkedListDeque(T item) {

        sentinel = new TNode(sentinel, initial, sentinel);
        sentinel.next = new TNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
    }

    public LinkedListDeque() {

        sentinel = new TNode(sentinel, initial, sentinel);
        sentinel.prev = sentinel;
    }

    public class TNode {
        TNode prev;
        T item;
        TNode next;

        public TNode(TNode t1, T m, TNode t2) {
            prev = t1;
            item = m;
            next = t2;
        }

        public T getRecursive(int index) {
            if (index == 0) {
                return sentinel.next.item;
            } else {
                sentinel = sentinel.next;
                return sentinel.getRecursive(index - 1);
            }
        }
    }



    public void addFirst(T item) {
        size = size + 1;
        sentinel.next = new TNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
    }
    public void addLast(T item) {
        size = size + 1;
        sentinel.prev = new TNode(sentinel.prev.prev, item, sentinel);
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
        return size;
    }
    public T removeLast() {
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return sentinel.next.item;
    }
    public T removeFirst() {
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return sentinel.next.item;
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



    public void printDeque() {
        TNode pp;
        pp = sentinel.next;
        while (size != 0) {
            System.out.print(pp.item);
            pp = pp.next;
            size = size - 1;
        }
    }
}
