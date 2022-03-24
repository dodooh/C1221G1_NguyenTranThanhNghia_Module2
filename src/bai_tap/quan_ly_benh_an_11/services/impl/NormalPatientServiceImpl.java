package bai_tap.quan_ly_benh_an_11.services.impl;

import bai_tap.quan_ly_benh_an_11.models.Patient;
import bai_tap.quan_ly_benh_an_11.services.IService;
import bai_tap.quan_ly_benh_an_11.utils.NotFoundMedicalRecordException;
import bai_tap.quan_ly_benh_an_11.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NormalPatientServiceImpl implements IService<Patient> {

    private static final String NORMAL_PATIENT_FILE_PATH = "src/bai_tap/quan_ly_benh_an_11/data/normal_patient.csv";
    private static List<Patient> normalPatientList = new ArrayList<>();

    static {
        try {
            normalPatientList = ReadWriteCSVFile.readNormalPatientListFromCSVFile(NORMAL_PATIENT_FILE_PATH);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    private final String TITLE_OF_CSV = "phoneID,phoneName,price,quantity,manufacture";

    @Override
    public int findGoodID() {
        if (normalPatientList.size() == 0) {
            return 1;
        } else {
            return normalPatientList.get(normalPatientList.size() - 1).getSerial() + 1;
        }
    }

    @Override
    public void add(Patient patient) {
        normalPatientList.add(patient);
        ReadWriteCSVFile.writeListToCSVFile(normalPatientList, NORMAL_PATIENT_FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Add successfully");
    }

    @Override
    public void display() {
        System.out.println("=====NORMAL PATIENT LIST=====");
        if (normalPatientList.size() != 0) {
            System.out.printf(" %-2s | %-6s | %-6s | %-20s | %-10s | %-10s | %-20s | %-10s \n",
                "STT",
                "recordID",
                "patientID",
                "patientName",
                "dayIn",
                "dayOut",
                "reason",
                "totalCost"
            );
            for (Patient patient : normalPatientList) {
                System.out.println(patient.toTableFormat());
            }
        } else {
            System.out.println("!!!NORMAL PATIENT LIST IS EMPTY!!!");
        }
    }

    @Override
    public void remove(Patient patient) {
        normalPatientList.remove(patient);
        ReadWriteCSVFile.writeListToCSVFile(normalPatientList, NORMAL_PATIENT_FILE_PATH, TITLE_OF_CSV);
        System.out.println(patient);
        System.out.println("✔ Remove Successfully");
    }

    @Override
    public Patient findPatientByID(String ID) throws NotFoundMedicalRecordException {
        if (normalPatientList.size() != 0) {
            for (Patient patient : normalPatientList) {
                if (ID.equals(patient.getPatientID())) {
                    return patient;
                }
            }
        }
        throw new NotFoundMedicalRecordException("not found");
    }

    @Override
    public void displayPatientByKeyword(String keywords) {
        boolean isFound = false;
        if (normalPatientList.size() != 0) {
            for (Patient phone : normalPatientList) {
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
