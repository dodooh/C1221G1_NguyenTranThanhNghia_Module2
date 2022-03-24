package bai_tap.quan_ly_benh_an_11.controllers;

import static bai_tap.quan_ly_benh_an_11.controllers.MainController.INVALID_INDEX_WARNING;
import static bai_tap.quan_ly_benh_an_11.controllers.MainController.NUMBER_FORMAT_WARNING;
import static bai_tap.quan_ly_benh_an_11.controllers.MainController.YOUR_CHOICE;
import static bai_tap.quan_ly_benh_an_11.controllers.MainController.scanner;
import static bai_tap.quan_ly_benh_an_11.utils.ReadInputFromKeyBoard.inputValidData;
import static bai_tap.quan_ly_benh_an_11.utils.ReadInputFromKeyBoard.inputValidDateTime;
import static bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.quan_ly_benh_an_11.models.NormalPatient;
import bai_tap.quan_ly_benh_an_11.models.Patient;
import bai_tap.quan_ly_benh_an_11.models.VIPPatient;
import bai_tap.quan_ly_benh_an_11.models.enums.VIPType;
import bai_tap.quan_ly_benh_an_11.services.IService;

import bai_tap.quan_ly_benh_an_11.services.impl.NormalPatientServiceImpl;
import bai_tap.quan_ly_benh_an_11.services.impl.VIPPatientServicesImpl;
import bai_tap.quan_ly_benh_an_11.utils.EnumUtils;
import bai_tap.quan_ly_benh_an_11.utils.NotFoundMedicalRecordException;
import bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary;
import java.text.ParseException;
import java.util.Date;

public class PatientController {

    private final IService<Patient> vipPatientService = new VIPPatientServicesImpl();
    private final IService<Patient> normalPatientService = new NormalPatientServiceImpl();
    private String recordID;
    private String patientID;
    private String patientName;
    private Date dateIn;
    private Date dateOut;
    private String reason;

    public void add() {
        int menuChoice;
        boolean flag = true;
        do {
            try {
                System.out.println("===ADD NEW PATIENT===\n" + "[1] - Vip Patient\n" + "[2] - Normal Patient\n" + "[0] - Back");
                System.out.print(YOUR_CHOICE);
                menuChoice = Integer.parseInt(bai_tap.quan_ly_ngan_hang_8.controllers.MainController.scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        addNewVIPPatient();
                        break;
                    case 2:
                        addNewNormalPatient();
                        break;
                    case 0:
                        System.out.println("Return...");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (flag);
    }

    private void addNewNormalPatient() {
        inputCommonProperties();
        double cost = Double.parseDouble(inputValidData("Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        normalPatientService.add(
            new NormalPatient(normalPatientService.findGoodID(), recordID, patientID, patientName, dateIn, dateOut, reason, cost));

    }

    private void addNewVIPPatient() {
        Date FROM_DATE = new Date("01/01/1900");
        inputCommonProperties();
        VIPType vipType = getVipTypeFromInput();
        Date dayExpired = inputValidDateTime("Day Expire ", FROM_DATE);

        vipPatientService.add(new VIPPatient(vipPatientService.findGoodID(),
            recordID, patientID, patientName, dateIn, dateOut, reason, vipType, dayExpired));
    }

    private void inputCommonProperties() {
        Date todayDate = null;
        try {
            todayDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        recordID = inputValidData("Record ID (BA-###)", ValidatorInputLibrary.BA_ID);
        patientID = inputValidData("Patient ID (BN-###)", ValidatorInputLibrary.BN_ID);
        patientName = inputValidData("Patient Name", ValidatorInputLibrary.STANDARD_NAME);
        dateIn = inputValidDateTime("Day In", todayDate);
        dateOut = inputValidDateTime("Day Out", dateIn);
        reason = inputValidData("Reason", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
    }

    private VIPType getVipTypeFromInput() {
        int choice;
        System.out.println("Enter VIP Type");
        EnumUtils.displayMenu(VIPType.class);
        System.out.println();
        do {
            String title = String.format("Your choice 0-%d:", (VIPType.values().length - 1));
            choice = Integer.parseInt(inputValidData(title, ValidatorInputLibrary.ONE_NUMBER));
            if (choice < 0 || choice >= VIPType.values().length) {
                System.out.print(INVALID_INDEX_WARNING);
            } else {
                return VIPType.values()[choice];
            }
        } while (true);
    }


    public void display() {
        vipPatientService.display();
        normalPatientService.display();
    }

    public void remove() {
        int menuChoice;
        boolean flag = true;
        do {
            try {
                System.out.println("===REMOVE PHONE===\n" + "[1] - Authenticate Patient\n" + "[2] - Hand Patient\n" + "[0] - Back");
                System.out.print(YOUR_CHOICE);
                menuChoice = Integer.parseInt(scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        removePhone(vipPatientService);
                        break;
                    case 2:
                        removePhone(normalPatientService);
                        break;
                    case 0:
                        System.out.println("Return...");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (flag);
    }

    public void removePhone(IService<Patient> service) {
        service.display();
        String ID;
        Patient foundPhone;
        do {
            ID = inputValidData("Patient ID to remove", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
            try {
                foundPhone = service.findPatientByID(ID);
                System.out.printf("FOUND: %s\n", foundPhone);
                System.out.print("Do you want to remove (YES/NO)? ");
                if ("YES".equalsIgnoreCase(scanner.nextLine())) {
                    service.remove(foundPhone);
                    service.display();
                }
                break;
            } catch (NotFoundMedicalRecordException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void search() {
        System.out.println("Enter Account-Name or Account-Code to Find");
        String input = scanner.nextLine();
        vipPatientService.displayPatientByKeyword(input);
        normalPatientService.displayPatientByKeyword(input);
    }
}
