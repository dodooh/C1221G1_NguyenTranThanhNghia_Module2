package case_study.furama_resort.controllers;

import static case_study.furama_resort.controllers.FuramaController.INVALID_INDEX_WARNING;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidEndDateTime;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidStartDateTime;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

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
import java.util.List;

public class BookingController {

    public static final String LIST_IS_EMPTY = "!!!LIST IS EMPTY!!!";
    private static BookingController instance;
    private final CustomerController customerController = CustomerController.getInstance();
    private final FacilityController facilityController = FacilityController.getInstance();
    private final IBookingService bookingService = BookingServiceImpl.getInstance();

    private BookingController() {
    }

    public static BookingController getInstance() {
        if (instance == null) {
            instance = new BookingController();
        }
        return instance;
    }

    public void create() {
        int bookingID = BookingServiceImpl.bookingSet.size() + 1;
        Date startDate = inputValidStartDateTime();
        Date endDate = inputValidEndDateTime(startDate);
        Customer customerID = inputValidCustomerID();
        Facility facility = inputValidFacility();
        bookingService.add(new Booking(bookingID, startDate, endDate, customerID, facility));
    }

    public void display() {
        bookingService.displaySet();
    }

    private Facility inputValidFacility() {
        int facilityChoice;
        facilityController.display();
        do {
            try {
                facilityChoice = Integer.parseInt(
                    inputValidData("Your Choice [0]. House\t[1]. Villa\t[2].Room: ", ValidatorInputLibrary.ONE_NUMBER));
                switch (facilityChoice) {
                    case 0:
                        if (HouseServiceImpl.houseList.size() != 0) {
                            return getFacilityFromList(HouseServiceImpl.houseList);
                        } else {
                            System.out.println(LIST_IS_EMPTY);
                        }
                        break;
                    case 1:
                        if (VillaServiceImpl.villaList.size() != 0) {
                            return getFacilityFromList(VillaServiceImpl.villaList);
                        } else {
                            System.out.println(LIST_IS_EMPTY);
                        }
                        break;
                    case 2:
                        if (RoomServiceImpl.roomList.size() != 0) {
                            return getFacilityFromList(RoomServiceImpl.roomList);
                        } else {
                            System.out.println(LIST_IS_EMPTY);
                        }
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
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
            System.out.print("Enter Customer ID: ");
            userInput = scanner.nextLine();
            for (Person customer : CustomerServiceImpl.customerList) {
                if (userInput.equals(((Customer) customer).getCustomerID())) {
                    return ((Customer) customer);
                }
            }
            System.out.println("!!!ID NOT FOUND. CAREFULLY REVIEW!!!");
        } while (true);
    }

    private Facility getFacilityFromList(List<Facility> list) {
        int choice;
        String title = String.format("Your choice 0-%d:", (list.size() - 1));
        do {
            choice = Integer.parseInt(inputValidData(title, ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
            if (choice < 0 || choice >= list.size()) {
                System.out.println(INVALID_INDEX_WARNING);
            } else {
                return list.get(choice);
            }
        } while (true);
    }
}
