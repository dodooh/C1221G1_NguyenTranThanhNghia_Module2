package oop_review.oop_java_1.nhap_xuat_thong_tin_xe;

public class VehicleTest {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]{
            new Vehicle("43A-212.56", 201, 50000000),
            new Vehicle("43B-453.88", 105, 10000000),
            new Vehicle("43C-678.56", 85, 30000000),
            new Vehicle("43C-012.34", 160, 80000000)
        };
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.println("Thuế: " + String.format("%,.0f", vehicle.tinhThue()));
        }
    }
}
