package ss16_text_file.thuc_hanh.tim_gia_tri_lon_nhat_va_in_ra_file;

import java.util.List;

public class FindMaxValue {

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/ss16_text_file/thuc_hanh/tim_gia_tri_lon_nhat_va_in_ra_file/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/ss16_text_file/thuc_hanh/tim_gia_tri_lon_nhat_va_in_ra_file/result.txt", maxValue);
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }
}
