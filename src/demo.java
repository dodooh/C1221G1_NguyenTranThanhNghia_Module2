public class demo {

    public static void main(String[] args) {
        float a = 5;
        method(a);
        int c = 6, b = 9;
        long d = 9;
        byte e = 1;
        int[] ar = {1,2,3};
        c = method(ar);
        method(b,c,(int)d,e);
    }

    static void method() {
    }

    static int method(int ...x) {
        for(int j : x) {
            System.out.println(j);
            return 1;
        }
        return 0;
    }

//    static void method(float x) {
//        System.out.println("float");
//    }

    static void method(double y) {
        System.out.println("double");
    }
}
