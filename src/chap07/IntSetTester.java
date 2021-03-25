package chap07;


public class IntSetTester {

    public static void main(String[] args) {

        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(20);
        IntSet s3 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);

        s3.copyFrom(s2);

        System.out.println("s1.contains(15) == " + s1.contains(15));
        System.out.println("s2.contains(25) == " + s2.contains(25));
        System.out.println("s1.equalTo(s2) == " + s1.equalTo(s2));
        System.out.println("s2.equalTo(s3) == " + s2.equalTo(s3));

        s3.unionOf(s1, s2);
        System.out.println("unionOf(s1, s2) == " + s3);

    }

}
