package case_study.furama_resort.controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidEndDateTime;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidStartDateTime;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.IBookingController;
import case_study.furama_resort.controllers.IFacilityController;
import case_study.furama_resort.controllers.IPeopleController;
import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Facility;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.IBookingService;
import case_study.furama_resort.services.impl.BookingServiceImpl;
import case_study.furama_resort.services.impl.CustomerServiceImpl;
import case_study.furama_resort.services.impl.HouseServiceImpl;
import case_study.furama_resort.services.impl.RoomServiceImpl;
import case_study.furama_resort.services.impl.VillaServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;
import java.util.Date;

public class BookingControllerImpl implements IBookingController {

    IPeopleController customerController = CustomerControllerImpl.getInstance();
    IFacilityController facilityController = FacilityControllerImpl.getInstance();
    IBookingService bookingService = BookingServiceImpl.getInstance();


    @Override
    public void create() {
        String bookingID = inputValidData("Booking ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        Date startDate = inputValidStartDateTime();
        Date endDate = inputValidEndDateTime(startDate);
        Customer customerID = inputValidCustomerID();
        Facility facility = inputValidFacility();
        bookingService.add(new Booking(bookingID, startDate, endDate, customerID, facility));
    }

    @Override
    public void display() {
        bookingService.displaySet(BookingServiceImpl.bookingTreeSet);
    }

    private Facility inputValidFacility() {
        int choice;
        facilityController.display();
        do {
            try {
                System.out.print("Enter your choice [1]. House\t[2]. Villa\t[3].Room: ");
                int facilityChoice = Integer.parseInt(scanner.nextLine());
                switch (facilityChoice) {
                    case 1:
                        if (HouseServiceImpl.houseList.size() != 0) {
                            System.out.print("Enter the index: ");
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice < 0 || choice >= HouseServiceImpl.houseList.size()) {
                                System.out.println("!!!ENTER A VALID HOUSE PLEASE!!!");
                            } else {
                                return HouseServiceImpl.houseList.get(choice);
                            }
                        } else {
                            System.out.println("!!!LIST IS EMPTY!!!");
                        }
                        break;
                    case 3:
                        if (RoomServiceImpl.roomList.size() != 0) {
                            System.out.print("Enter the index: ");
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice < 0 || choice >= RoomServiceImpl.roomList.size()) {
                                System.out.println("!!!ENTER A VALID ROOM PLEASE!!!");
                            } else {
                                return RoomServiceImpl.roomList.get(choice);
                            }
                        } else {
                            System.out.println("!!!LIST IS EMPTY!!!");
                        }
                        break;
                    case 2:
                        if (VillaServiceImpl.villaList.size() != 0) {
                            System.out.print("Enter the index: ");
                            choice = Integer.parseInt(scanner.nextLine());
                            if (choice < 0 || choice >= VillaServiceImpl.villaList.size()) {
                                System.out.println("!!!ENTER A VALID VILLA PLEASE!!!");
                            } else {
                                return VillaServiceImpl.villaList.get(choice);
                            }
                        } else {
                            System.out.println("!!!LIST IS EMPTY!!!");
                        }
                        break;
                    default:
                        System.out.println("!!!ENTER A VALID VILLA PLEASE!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    private Customer inputValidCustomerID() {
        String userInput;
        customerController.display();
        do {
            System.out.println("Enter Customer ID");
            userInput = scanner.nextLine();
            for (Person customer : CustomerServiceImpl.customerList) {
                if (userInput.equals(((Customer) customer).getCustomerID())) {
                    return ((Customer) customer);
                }
            }
            System.out.println("!!!Not Found In List!!! Carefully Review");
        } while (true);
    }
}
