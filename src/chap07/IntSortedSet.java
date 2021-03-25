package chap07;


public class IntSortedSet {

    private int max;
    private int num;
    private int[] set;

    public IntSortedSet(int capacity) {

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

    public boolean retain(IntSortedSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            ret = ret || this.remove(s.set[i]);
        }
        return ret;
    }

    // todo: 정렬 적용
    public boolean add(int x) {
        int idx;
        if (this.num >= this.max || (idx = this.indexOf(x)) > -1) {
            return false;
        } else {
//            set[num++] = x; // 기존 처리
            idx = -(idx + 1);
            num++;
            for (int i = num - 1; i > idx; i--)
                set[i] = set[i - 1];
            set[idx] = x;
            return true;
        }
    }

    public boolean add(IntSortedSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            if (this.num >= this.max) {
                this.max++;
            }
            ret = ret || this.add(s.set[i]);
        }
        return ret;
    }

    // todo: 정렬 적용
    public boolean remove(int x) {
        int idx;

        if (this.num <= 0 || (idx = this.indexOf(x)) == -1) {
            return false;
        } else {
//            set[idx] = set[--num];    // 기존 처리
            num--;
            for (int i = idx; i < num; i++) // set[idx]를 삭제하고
                set[i] = set[i + 1]; // 그 다음 요소를 한 칸 앞으로 옮김
            return true;
        }
    }

    public boolean remove(IntSortedSet s) {
        boolean ret = false;
        for (int i = 0 ; i < s.num ; i++) {
            ret = ret || this.remove(s.set[i]);
        }
        return ret;
    }

    public void copyTo(IntSortedSet s) {
        int n = Math.min(s.max, this.num);

        for (int i = 0 ; i < n ; i++) {
            s.set[i] = this.set[i];
        }
        s.num = n;
    }

    public void copyFrom(IntSortedSet s) {
        int n = Math.min(this.max, s.num);

        for (int i = 0 ; i < n ; i++) {
            this.set[i] = s.set[i];
        }
        this.num = n;
    }

    public boolean equalTo(IntSortedSet s) {
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

    public void unionOf(IntSortedSet s1, IntSortedSet s2) {
        this.copyFrom(s1);
        for (int i = 0 ; i < s2.num ; i++) {
            this.add(s2.set[i]);
        }
    }

    public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
        this.copyFrom(s1);
        for (int i = 0 ; i < s2.num ; i++) {
            if (!this.contains(s2.set[i])) {
                this.remove(s2.set[i]);
            }
        }
    }

    public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
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

    public boolean isSubsetOf(IntSortedSet s) {
        for (int i = 0 ; i < this.num ; i++) {
            if (!s.contains(this.set[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isProperSubsetOf(IntSortedSet s) {
        return this.isSubsetOf(s) && !s.isSubsetOf(this);
    }

    public void clear() {
        this.num = 0;
    }

}
