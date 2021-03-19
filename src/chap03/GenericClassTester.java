package chap03;

public class GenericClassTester {

    static class GenericClass<T> {
        private T xyz;

        GenericClass(T t) {
            this.xyz = t;
        }

        T getXyz() {
            return this.xyz;
        }
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<String>("abc");
        GenericClass<Integer> i = new GenericClass<Integer>(1);

        System.out.println("s.getXyz() == " + s.getXyz());
        System.out.println("i.getXyz() == " + i.getXyz());
    }

}
