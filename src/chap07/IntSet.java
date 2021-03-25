package chap07;


public class IntSet {

    private int max;
    private int num;
    private int[] set;

    public IntSet(int capacity) {

        this.max = capacity;
        try {
            this.set = new int[this.max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
        this.clear();

    }

    public int capacity() {
        return this.max;
    }

    public int size() {
        return this.num;
    }

    public int indexOf(int x) {
        for (int i = 0 ; i < this.set.length ; i++) {
            if (this.set[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int x) {
        return this.indexOf(x) > -1;
    }

    public boolean retain(IntSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            ret = ret || this.remove(s.set[i]);
        }
        return ret;
    }

    public boolean add(int x) {
        if (this.num >= this.max || this.contains(x)) {
            return false;
        } else {
            set[num++] = x;
            return true;
        }
    }

    public boolean add(IntSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            if (this.num >= this.max) {
                this.max++;
            }
            ret = ret || this.add(s.set[i]);
        }
        return ret;
    }

    public boolean remove(int x) {
        int idx;

        if (this.num <= 0 || (idx = this.indexOf(x)) == -1) {
            return false;
        } else {
            set[idx] = set[--num];
            return true;
        }
    }

    public boolean remove(IntSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            ret = ret || this.remove(s.set[i]);
        }
        return ret;
    }

    public void copyTo(IntSet s) {
        int n = Math.min(s.max, this.num);

        for (int i = 0 ; i < n ; i++) {
            s.set[i] = this.set[i];
        }
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = Math.min(this.max, s.num);

        for (int i = 0 ; i < n ; i++) {
            this.set[i] = s.set[i];
        }
        this.num = n;
    }

    public boolean equalTo(IntSet s) {
        if (this.num != s.num) {
            return false;
        }

        for (int i = 0 ; i < this.num ; i++) {
            int j = 0;
            for ( ; j < s.num ; j++) {
                if (this.set[i] == s.set[j]) {
                    break;
                }
            }
            if (j == s.num) {
                return false;
            }
        }

        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        this.copyFrom(s1);
        for (int i = 0 ; i < s2.num ; i++) {
            this.add(s2.set[i]);
        }
    }

    public void intersectionOf(IntSet s1, IntSet s2) {
        this.copyFrom(s1);
        for (int i = 0 ; i < s2.num ; i++) {
            if (!this.contains(s2.set[i])) {
                this.remove(s2.set[i]);
            }
        }
    }

    public void differenceOf(IntSet s1, IntSet s2) {
        this.copyFrom(s1);
        for (int i = 0 ; i < s2.num ; i++) {
            if (this.contains(s2.set[i])) {
                this.remove(s2.set[i]);
            }
        }
    }

    public String toString() {
        StringBuilder temp = new StringBuilder("{ ");
        for (int i = 0 ; i < this.num ; i++) {
            temp.append(this.set[i]).append(" ");
        }
        temp.append("}");
        return temp.toString();
    }

    public boolean isEmpty() {
        return this.num <= 0;
    }

    public boolean isFull() {
        return this.num >= this.max;
    }

    public boolean isSubsetOf(IntSet s) {
        for (int i = 0 ; i < this.num ; i++) {
            if (!s.contains(this.set[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isProperSubsetOf(IntSet s) {
        return this.isSubsetOf(s) && !s.isSubsetOf(this);
    }

    public void clear() {
        this.num = 0;
    }

}
