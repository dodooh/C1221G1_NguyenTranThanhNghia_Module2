package ss17_binary_file_serialization.bai_tap.quan_li_san_pham_dung_binary_file;

import java.io.Serializable;

public class Product implements Serializable {

    private String productID;
    private String productName;
    private String company;
    private double price;

    public Product(String productID, String productName, String company, double price) {
        this.productID = productID;
        this.productName = productName;
        this.company = company;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
            "productID='" + productID + '\'' +
            ", productName='" + productName + '\'' +
            ", company='" + company + '\'' +
            ", price=" + price +
            '}';
    }
}
