package chap04;

import java.lang.reflect.Array;

public class GenericQueue<E> {

    private int max;
    private int front;
    private int rear;
    private int num;
    private E[] que;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public static class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public GenericQueue(Class<E> klass, int capacity) {
        this.clear();
        this.max = capacity;

        try {
            this.que = (E[]) Array.newInstance(klass, this.max);
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public E enque(E x) throws IntQueue.OverflowIntQueueException {
        if (this.isFull()) {
            throw new IntQueue.OverflowIntQueueException();
        }
        this.que[this.rear++] = x;
        this.num++;
        if (this.rear == this.max) {
            this.rear = 0;
        }
        return x;
    }

    public E deque() throws IntQueue.EmptyIntQueueException {
        if (this.isEmpty()) {
            throw new IntQueue.EmptyIntQueueException();
        }
        E x = this.que[this.front++];
        this.num--;
        if (this.front == this.max) {
            this.front = 0;
        }
        return x;
    }

    public E peek() throws IntQueue.EmptyIntQueueException {
        if (this.isEmpty()) {
            throw new IntQueue.EmptyIntQueueException();
        }
        return this.que[this.front];
    }

    public int indexOf(E x) {
        int idx;
        for (int i = 0 ; i < this.que.length ; i++) {
            idx = (this.front + i) % this.max;
            if (this.que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public int search(E x) {
        int idx = this.indexOf(x);
        if (idx < 0) {
            return 0;
        }
        int i = (this.front + idx) % this.max;
        return i;
    }

    public void clear() {
        this.num = this.front = this.rear = 0;
    }

    public int capacity() {
        return this.max;
    }

    public int size() {
        return this.num;
    }

    public boolean isEmpty() {
        return this.num <= 0;
    }

    public boolean isFull() {
        return this.num >= this.max;
    }

    public void dump() {
        if (this.isEmpty()) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0 ; i < this.num ; i++) {
                System.out.print(this.que[(this.front + i) % this.max] + " ");
            }
            System.out.println();
        }
    }

}
