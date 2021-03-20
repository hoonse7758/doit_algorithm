package chap04;


public class IntQueue {

    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public static class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int capacity) {
        this.clear();
        this.max = capacity;

        try {
            this.que = new int[this.max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (this.isFull()) {
            throw new OverflowIntQueueException();
        }
        this.que[this.rear++] = x;
        this.num++;
        if (this.rear == this.max) {
            this.rear = 0;
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (this.isEmpty()) {
            throw new EmptyIntQueueException();
        }
        int x = this.que[this.front++];
        this.num--;
        if (this.front == this.max) {
            this.front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (this.isEmpty()) {
            throw new EmptyIntQueueException();
        }
        return this.que[this.front];
    }

    public int indexOf(int x) {
        int idx = -1;
        for (int i = 0 ; i < this.que.length ; i++) {
            idx = (this.front + i) % this.max;
            if (this.que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public int search(int x) {
        int idx = this.indexOf(x);
        if (idx < 0) {
            return 0;
        }
        int i = (this.front + idx) % this.max;
        return this.que[i];
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
