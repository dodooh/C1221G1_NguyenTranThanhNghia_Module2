package ss17_binary_file_serialization.bai_tap.quan_li_san_pham_dung_binary_file;

import static ss17_binary_file_serialization.bai_tap.quan_li_san_pham_dung_binary_file.ReadAndWriteFile.readProductListFromFile;
import static ss17_binary_file_serialization.bai_tap.quan_li_san_pham_dung_binary_file.ReadAndWriteFile.writeProductListToFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static final String filePath = "src/ss17_binary_file_serialization/bai_tap/quan_li_san_pham_dung_binary_file/Product.dat";
    static Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    static {
        productList = readProductListFromFile(filePath);
    }

    void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("========PRODUCT MANAGEMENT=========");
            System.out.println("1. Add new product");
            System.out.println("2. Show product list");
            System.out.println("3. Search Product");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    showProductList(readProductListFromFile(filePath));
                    break;
                case 3:
                    showSearchProductMenu();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    void showProductList(List<Product> list) {
        if (list.size() != 0) {
            for (Product p : list) {
                System.out.println(p);
            }
        } else {
            System.out.println("No Product Found");
        }
    }

    void addNewProduct() {
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Company: ");
        String company = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product newProduct = new Product(productID, productName, company, price);
        productList.add(newProduct);
        writeProductListToFile(filePath, productList);
    }

    void showSearchProductMenu() {
        System.out.println("========SEARCH PRODUCT=========");
        System.out.println("1. Search By ID");
        System.out.println("2. Search By Name");
        System.out.println("3. Search By Company");
        System.out.println("4. Search By Price");
        System.out.println("5. Back");
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("--Search By ID Function--");
                System.out.print("Enter the ID: ");
                String ID = scanner.nextLine();
                showProductList(searchByID(productList, ID));
                break;
            case 2:
                System.out.println("--Search By Name Function--");
                System.out.print("Enter the name: ");
                String name = scanner.nextLine();
                showProductList(searchByName(productList, name));
                break;
            case 3:
                System.out.println("--Search By Company Function--");
                System.out.print("Enter the company name: ");
                String company = scanner.nextLine();
                showProductList(searchByCompany(productList, company));
                break;
            case 4:
                System.out.println("--Search By price Function--");
                System.out.print("Enter the price: ");
                double price = Double.parseDouble(scanner.nextLine());
                showProductList(searchByPrice(productList, price));
                break;
        }
    }

    List<Product> filterProduct(List<Product> productList, ProductPredicate pp) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (pp.test(product)) {
                result.add(product);
            }
        }
        return result;
    }

    private List<Product> searchByName(List<Product> productList, String name) {
        return filterProduct(productList, product -> product.getProductName().toLowerCase().contains(name.toLowerCase()));
    }

    private List<Product> searchByID(List<Product> productList, String ID) {
        return filterProduct(productList, product -> product.getProductID().equalsIgnoreCase(ID));
    }

    private List<Product> searchByCompany(List<Product> productList, String company) {
        return filterProduct(productList, product -> product.getCompany().equalsIgnoreCase(company));
    }

    private List<Product> searchByPrice(List<Product> productList, double price) {
        return filterProduct(productList, product -> product.getPrice() <= price);
    }
}
