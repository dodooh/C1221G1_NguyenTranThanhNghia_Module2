package ss12_map_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManagerUsingArrayList {
    private Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1001,"diamond",249.47));
        products.add(new Product(1002,"beast",526.25));
        products.add(new Product(1003,"towel",404.41));
        products.add(new Product(1004,"shield",711.37));
        products.add(new Product(1005,"shelf",687.72));
    }

    void displayMainMenu() {
        int productID;
        Product foundProduct;
        String productName;
        boolean flag = true;
        do {
            System.out.println("========CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM SỬ DỤNG ARRAYLIST=========");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    System.out.print("Nhập vào ID của sản phẩm: ");
                    productID = Integer.parseInt(scanner.nextLine());
                    foundProduct = findById(productID);
                    if (foundProduct != null) {
                        editProduct(foundProduct);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm này!!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập vào ID của sản phẩm: ");
                    productID = Integer.parseInt(scanner.nextLine());
                    foundProduct = findById(productID);
                    if (foundProduct != null) {
                        removeProduct(foundProduct);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm này!!");
                    }
                    break;
                case 4:
                    displayListProducts(products);
                    break;
                case 5:
                    System.out.print("Nhập vào tên của sản phẩm: ");
                    productName = scanner.nextLine();
                    findByName(productName);
                    break;
                case 6:
                    sortByPrice();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    void addNewProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product newProduct = new Product(productId, productName, price);
        products.add(newProduct);
        System.out.println("Đã thêm sản phẩm mới");
        System.out.println(newProduct);
    }

    void removeProduct(Product product) {
        System.out.println(product);
        System.out.println("Bạn có muốn xóa sản phẩm này? \n"
            + "1. Đồng ý\n"
            + "2. Hủy\n");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            products.remove(product);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Đã hủy thao tác. Quay về menu chính");
        }
    }

    void editProduct(Product product) {
        System.out.println(product);
        System.out.println("Chọn thông tin muốn sửa\n"
            + "1. Mã Sản Phẩm\n"
            + "2. Tên Sản Phẩm\n"
            + "3. Giá Sản Phẩm\n"
            + "4. Exit");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                int newProductId = Integer.parseInt(scanner.nextLine());
                product.setProductId(newProductId);
                break;
            case 2:
                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                String productName = scanner.nextLine();
                product.setProductName(productName);
                break;
            case 3:
                System.out.println("Nhập giá sản phẩm muốn sửa:: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                product.setPrice(newPrice);
                break;
            default:
                System.out.println("Đã hủy thao tác. Quay về menu chính");
                return;
        }
        System.out.println("Đã sửa thành công!");
        System.out.println(product);

    }

    Product findById(int idToFind) {
        for (Product product : products) {
            if (idToFind == product.getProductId()) {
                return product;
            }
        }
        return null;
    }

    void findByName(String productName){
        ArrayList<Product> productsSameName = new ArrayList<>();
        for (Product product: products ) {
            if(product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                productsSameName.add(product);
            }
        }
        displayListProducts(productsSameName);
    }

    void sortByPrice() {
        System.out.println("Chọn kiểu sắp xếp \n"
            + "1. Tăng dần\n"
            + "2. Giảm dần\n");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            Collections.sort(products, new Comparator<Product>(){
                @Override
                public int compare(Product p1, Product p2) {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
            });
        } else {
            Collections.sort(products, new Comparator<Product>(){
                @Override
                public int compare(Product p1, Product p2) {
                    return Double.compare(p2.getPrice(), p1.getPrice());
                }
            });
        }
        displayListProducts(products);
    }

    void displayListProducts(ArrayList<Product> productsList) {
        if (productsList.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm nào");
            return;
        }
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : productsList) {
            System.out.println(product);
        }
    }
}
