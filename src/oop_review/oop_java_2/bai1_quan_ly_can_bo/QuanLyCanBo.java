package oop_review.oop_java_2.bai1_quan_ly_can_bo;


import java.util.Arrays;
import java.util.Scanner;

public class QuanLyCanBo {

    static CanBo[] canBos = new CanBo[20];

    static {
        canBos[0] = new CongNhan("Nguyễn Văn A", 1995, true, "Quảng Nam", 5);
        canBos[1] = new CongNhan("Nguyễn Văn B", 1996, true, "Quảng Ngãi", 6);
        canBos[2] = new KySu("Nguyễn Thị C", 1992, false, "Quảng Bình", "Hóa dầu");
        canBos[3] = new KySu("Nguyễn Văn D", 1990, true, "Quảng Trị", "Điện");
        canBos[4] = new NhanVienPhucVu("Nguyễn Thị E", 1996, false, "Đà Nẵng", "Tạp Vụ");
        canBos[5] = new NhanVienPhucVu("Nguyễn Văn F", 1993, true, "Huế", "Đầu bếp");
    }

    Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        boolean flag = true;
        do {
            System.out.println("========CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ=========");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Sắp xếp theo tên");
            System.out.println("4. Hiển thị thông tin về danh sách cán bộ");
            System.out.println("5. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    themMoiCanBo();
                    break;
                case 2:
                    timKiemTheoTen();
                    break;
                case 3:
                    sapXepTheoTen();
                    break;
                case 4:
                    hienThiDanhSachCanBo();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void sapXepTheoTen() {
        ComparatorCanBo comparatorCanBo = new ComparatorCanBo();
        Arrays.sort(canBos, comparatorCanBo);
        hienThiDanhSachCanBo();
    }

    private void themMoiCanBo() {
        // Menu
        System.out.println("Chọn chức vị: ");
        System.out.println("1. Thêm kỹ sư ");
        System.out.println("2. Thêm công nhân ");
        System.out.println("3. Thêm nhân viên phục vụ ");
        System.out.println("4. Quay lại");
        System.out.println("Nhập lựa chọn: ");

        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1 || choice == 2 || choice == 3) {
            // Nhập thông tin Cán bộ
            System.out.println("Nhập tên: ");
            String hoTen = scanner.nextLine();
            System.out.println("Nhập năm sinh");
            int namSinh = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập giới tính:\n1. Nam\n2. Nữ");
            int gioiTinh = Integer.parseInt(scanner.nextLine());
            boolean isMale = gioiTinh == 1;
            System.out.println("Nhập địa chỉ: ");
            String diaChi = scanner.nextLine();
            // Nhập thông tin riêng
            CanBo tempCanBo = null;
            switch (choice) {
                case 1:
                    System.out.println("Nhập ngành đào tạo: ");
                    String nganh = scanner.nextLine();
                    tempCanBo = new KySu(hoTen, namSinh, isMale, diaChi, nganh);
                    break;
                case 2:
                    System.out.println("Nhập cấp bậc [1-7]: ");
                    int bac = Integer.parseInt(scanner.nextLine());
                    bac = (bac <= 0 || bac > 7) ? 1 : bac;
                    tempCanBo = new CongNhan(hoTen, namSinh, isMale, diaChi, bac);
                    break;
                case 3:
                    System.out.println("Nhập công việc: ");
                    String congViec = scanner.nextLine();
                    tempCanBo = new NhanVienPhucVu(hoTen, namSinh, isMale, diaChi, congViec);
                    break;
            }
            int i = 0;
            while (canBos[i] != null) {
                i++;
            }
            canBos[i] = tempCanBo;
        } else {
            System.out.println("Quay lại menu chính");
        }
    }

    private void timKiemTheoTen() {
        System.out.println("Nhập tên cần tìm kiếm: ");
        String findName = scanner.nextLine();
        int i = 0;
        while (canBos[i] != null) {
            if (canBos[i].getHoTen().contains(findName)) {
                System.out.println(canBos[i]);
            }
            i++;
        }

    }

    private void hienThiDanhSachCanBo() {
        for (CanBo canBo : canBos) {
            if (canBo != null) {
                System.out.println(canBo);
            } else {
                break;
            }
        }
    }

}
