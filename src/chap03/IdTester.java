package chap03;

class Id {
    private static int counter = 0;
    private final int id;

    public Id() {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}

public class IdTester {

    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a.id == " + a.getId());
        System.out.println("b.id == " + b.getId());

        System.out.println("Id.getCounter() == " + Id.getCounter());
    }

}
