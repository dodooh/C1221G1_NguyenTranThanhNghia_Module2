package bai_tap.quan_ly_benh_an_11.services.impl;

import bai_tap.quan_ly_benh_an_11.models.Patient;
import bai_tap.quan_ly_benh_an_11.services.IService;
import bai_tap.quan_ly_benh_an_11.utils.NotFoundMedicalRecordException;
import bai_tap.quan_ly_benh_an_11.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VIPPatientServicesImpl implements IService<Patient> {

    private static final String VIP_PATIENT_FILE_PATH = "src/bai_tap/quan_ly_benh_an_11/data/vip_patient.csv";
    private static List<Patient> vipPatientList = new ArrayList<>();

    static {
        try {
            vipPatientList = ReadWriteCSVFile.readVIPPatientListFromCSVFile(VIP_PATIENT_FILE_PATH);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    private final String TITLE_OF_CSV = "phoneID,phoneName,price,quantity,manufacture";

    @Override
    public int findGoodID() {
        if (vipPatientList.size() == 0) {
            return 1;
        } else {
            return vipPatientList.get(vipPatientList.size() - 1).getSerial() + 1;
        }
    }

    @Override
    public void add(Patient phone) {
        vipPatientList.add(phone);
        ReadWriteCSVFile.writeListToCSVFile(vipPatientList, VIP_PATIENT_FILE_PATH, TITLE_OF_CSV);
        System.out.println(phone);
        System.out.println("✔ Add successfully");
    }

    @Override
    public void display() {
        System.out.println("=====VIP PATIENT LIST=====");
        if (vipPatientList.size() != 0) {
            System.out.printf(" %-2s | %-6s | %-6s | %-20s | %-10s | %-10s | %-20s | %-8s | %-10s |\n",
                "STT",
                "recordID",
                "patientID",
                "patientName",
                "dayIn",
                "dayOut",
                "reason",
                "VIP",
                "dayExpired"
            );
            for (Patient patient : vipPatientList) {
                System.out.println(patient.toTableFormat());
            }
        } else {
            System.out.println("!!!VIP PATIENT LIST IS EMPTY!!!");
        }
    }

    @Override
    public void remove(Patient phone) {
        vipPatientList.remove(phone);
        ReadWriteCSVFile.writeListToCSVFile(vipPatientList, VIP_PATIENT_FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Remove Successfully");
    }

    @Override
    public Patient findPatientByID(String ID) throws NotFoundMedicalRecordException {
        if (vipPatientList.size() != 0) {
            for (Patient patient : vipPatientList) {
                if (ID.equals(patient.getPatientID())) {
                    return patient;
                }
            }
        }
        throw new NotFoundMedicalRecordException("Not OFund");
    }


    @Override
    public void displayPatientByKeyword(String keywords) {
        boolean isFound = false;
        if (vipPatientList.size() != 0) {
            for (Patient phone : vipPatientList) {
                if (phone.getPatientName().toLowerCase().contains(keywords.toLowerCase())
                    || phone.getPatientID().toLowerCase().contains(keywords.toLowerCase())) {
                    isFound = true;
                    System.out.println(phone);
                }
            }
            if (!isFound) {
                System.out.println("Not found " + keywords + " in hand Patient list");
            }
        } else {
            System.out.println("Not found " + keywords + " in han Patient list");
        }
    }
}
