package chap04;


public class IntStack {
    private int max;
    private int ptr;
    private int[] stk;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {

        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {

        }
    }

    public IntStack(int capacity) {
        this.ptr = 0;
        this.max = capacity;
        try {
            this.stk = new int[this.max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (this.ptr >= this.max) {
            throw new OverflowIntStackException();
        }
        return this.stk[this.ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (this.ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return this.stk[--this.ptr];
    }

    public int peek() throws EmptyIntStackException {
        if (this.ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return this.stk[this.ptr - 1];
    }

    public int indexOf(int x) {
        for (int i = this.stk.length - 1 ; i > -1 ; i--) {
            if (this.stk[i] == x)
                return i;
        }
        return -1;
    }

    public void clear() {
        this.ptr = 0;
    }

    public int capacity() {
        return this.max;
    }

    public int size() {
        return this.ptr;
    }

    public boolean isEmpty() {
        return this.ptr <= 0;
    }

    public boolean isFull() {
        return this.ptr >= this.max;
    }

    public void dump() {
        if (this.ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0 ; i < this.ptr ; i++) {
                System.out.print(this.stk[i] + " ");
            }
            System.out.println();
        }
    }

}
