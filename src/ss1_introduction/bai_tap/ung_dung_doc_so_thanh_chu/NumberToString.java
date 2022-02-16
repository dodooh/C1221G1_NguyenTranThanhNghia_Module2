package ss1_introduction.bai_tap.ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class NumberToString {

    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 999 || number < 0) {
            System.out.println("Out of ability");
        } else {
            int hundreds = number / 100;
            int tens = (number % 100) / 10;
            int ones = number % 10;
            String result = "";
            if (number == 0) {
                result = "zero";
            } else if (hundreds != 0) {
                switch (hundreds) {
                    case 1:
                        result += "one hundred ";
                        break;
                    case 2:
                        result += "two hundred ";
                        break;
                    case 3:
                        result += "three hundred ";
                        break;
                    case 4:
                        result += "four hundred ";
                        break;
                    case 5:
                        result += "five hundred ";
                        break;
                    case 6:
                        result += "six hundred ";
                        break;
                    case 7:
                        result += "seven hundred ";
                        break;
                    case 8:
                        result += "eight hundred ";
                        break;
                    case 9:
                        result += "nine hundred ";
                        break;
                    default:
                        break;

                }
                if (tens != 0 || ones != 0) {
                    result += "and ";
                }
            }
            if (tens == 1) {
                switch (ones) {
                    case 0:
                        result += "ten";
                        break;
                    case 1:
                        result += "eleven";
                        break;
                    case 2:
                        result += "twelve";
                        break;
                    case 3:
                        result += "thirteen";
                        break;
                    case 4:
                        result += "fourteen";
                        break;
                    case 5:
                        result += "fifteen";
                        break;
                    case 6:
                        result += "sixteen";
                        break;
                    case 7:
                        result += "seventeen";
                        break;
                    case 8:
                        result += "eighteen";
                        break;
                    case 9:
                        result += "nineteen";
                        break;
                }
            } else {
                switch (tens) {
                    case 2:
                        result += "twenty ";
                        break;
                    case 3:
                        result += "thirty ";
                        break;
                    case 4:
                        result += "forty ";
                        break;
                    case 5:
                        result += "fifty ";
                        break;
                    case 6:
                        result += "sixty ";
                        break;
                    case 7:
                        result += "seventy ";
                        break;
                    case 8:
                        result += "eighty ";
                        break;
                    case 9:
                        result += "ninety ";
                        break;
                    default:
                        break;
                }
                switch (ones) {
                    case 1:
                        result += "one";
                        break;
                    case 2:
                        result += "two";
                        break;
                    case 3:
                        result += "three";
                        break;
                    case 4:
                        result += "four";
                        break;
                    case 5:
                        result += "five";
                        break;
                    case 6:
                        result += "six";
                        break;
                    case 7:
                        result += "seven";
                        break;
                    case 8:
                        result += "eight";
                        break;
                    case 9:
                        result += "nine";
                        break;
                    default:
                        break;
                }
            }
            System.out.println(result);
        }
    }
}
