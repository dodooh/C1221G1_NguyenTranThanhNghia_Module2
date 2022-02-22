package demo.test_frog_static;
class Frog {
    private static int frogCount = 0;
    static int getCount() {
        return frogCount;
    }
    public Frog() {
        frogCount += 1;
    }
}
public class TestFrog {

    public static void main(String[] args) {
        new Frog();
        new Frog();
        new Frog();
        System.out.println("from static " + Frog.getCount());
        new Frog();
        new TestFrog().go();
        Frog f = new Frog();
        System.out.println("use ref var " + f.getCount());
    }
    void go() {
        System.out.println("from ins " + Frog.getCount());
    }
}
