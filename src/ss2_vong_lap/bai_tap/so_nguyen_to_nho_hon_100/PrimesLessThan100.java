package ss2_vong_lap.bai_tap.so_nguyen_to_nho_hon_100;

public class PrimesLessThan100 {

    public static void main(String[] args) {
        int n = 2;
        while (n < 100) {
            boolean flag = true;
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf("%d - ",n);
            }
            n++;
        }

    }
}
