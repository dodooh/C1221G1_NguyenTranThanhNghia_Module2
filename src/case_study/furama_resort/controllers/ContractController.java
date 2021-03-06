package case_study.furama_resort.controllers;


import static case_study.furama_resort.controllers.CustomerController.CONFIRM_CASE;
import static case_study.furama_resort.controllers.FuramaController.INVALID_INDEX_WARNING;
import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Contract;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.services.impl.BookingServiceImpl;
import case_study.furama_resort.services.impl.ContractServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;
import java.util.LinkedList;
import java.util.Queue;

public class ContractController {

    private static ContractController instance;
    private final BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
    private final ContractServiceImpl contractService = ContractServiceImpl.getInstance();

    private ContractController() {
    }

    public static ContractController getInstance() {
        if (instance == null) {
            instance = new ContractController();
        }
        return instance;
    }

    public void create() {
        //  Queue<Booking> bookingQueue = new LinkedList<>(bookingSet);
        Queue<Booking> bookingQueue = new LinkedList<>(bookingService.sendBooking());
        // Tao moi contract cho moi booking
        Booking booking;
        while (!bookingQueue.isEmpty()) {
            booking = bookingQueue.poll();
            if (booking.getFacility() instanceof Room
                || booking.isSignedContract()) { // Chi tao contract voi Villa va House
                continue;
            }
            Customer customer = booking.getCustomer();
            System.out.println("Create Contract For " + booking);
            int contractNumber = Integer.parseInt(
                inputValidData("Contract Number ", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
            double deposit = Double.parseDouble(inputValidData("Deposit", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
            double totalCost = Double.parseDouble(
                inputValidData("Total Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
            contractService.add(new Contract(contractNumber, booking, deposit, totalCost, customer));
            bookingService.updateAllBookingsStatus(booking);
        }
        System.out.println("???All Bookings Has Been Created Contract");
    }

    public void display() {
        contractService.displayList();
    }

    public void edit() {
        System.out.println("----------CONTRACT EDITING MODE-----------");
        display();
        Contract contractFound;
        do {
            int contractNumber = Integer.parseInt(
                inputValidData("Contract Number", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
            contractFound = contractService.findContractByContractNumber(contractNumber);
            if (contractFound == null) {
                System.out.println("!!!CONTRACT NUMBER NOT FOUND!!!");
            } else {
                break;
            }
        } while (true);
        int index = ContractServiceImpl.contractList.indexOf(contractFound);
        Contract clonedContract = new Contract(contractFound);
        editingExecution(clonedContract);
        System.out.print("Confirm editing (y/n)? ");
        if (CONFIRM_CASE.equals(scanner.nextLine())) {
            contractService.edit(index, clonedContract);
        } else {
            System.out.println("Exit editing mode...");
        }
    }

    private void editingExecution(Contract contract) {
        System.out.println(contract);
        String menu = "[1] - Contract Number,\n"
            + "[2] - Deposit,\n"
            + "[3] - Total Cost,\n";
        do {
            System.out.println(menu);
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int contractNumber = Integer.parseInt(
                        inputValidData("New Contract Number ", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
                    contract.setContractNumber(contractNumber);
                    break;
                case 2:
                    double deposit = Double.parseDouble(
                        inputValidData("New Deposit", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
                    contract.setDeposit(deposit);
                    break;
                case 3:
                    double totalCost = Double.parseDouble(
                        inputValidData("New Total Money", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
                    contract.setTotalCost(totalCost);
                    break;
                default:
                    System.out.println(INVALID_INDEX_WARNING);
            }
            System.out.println(contract);
            System.out.print("Keep Editing?(y/n)? ");
            String s = scanner.nextLine();
            if (!CONFIRM_CASE.equalsIgnoreCase(s)) {
                break;
            }
        } while (true);
    }
}
