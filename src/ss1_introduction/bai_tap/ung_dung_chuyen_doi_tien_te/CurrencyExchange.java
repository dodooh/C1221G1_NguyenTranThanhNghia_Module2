package ss1_introduction.bai_tap.ung_dung_chuyen_doi_tien_te;

import java.util.Scanner;

public class CurrencyExchange {

    public static void main(String[] args) {
        final int RATE = 23000;
        System.out.println("Enter the USD: ");
        Scanner scanner  = new Scanner(System.in);
        double usd = scanner.nextDouble();
        double vnd = usd * RATE;
        System.out.printf("%.2f USD => %.2f VND", usd, vnd);
    }
}
