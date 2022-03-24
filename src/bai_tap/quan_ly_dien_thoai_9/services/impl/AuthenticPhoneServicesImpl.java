package bai_tap.quan_ly_dien_thoai_9.services.impl;

import bai_tap.quan_ly_dien_thoai_9.models.Phone;
import bai_tap.quan_ly_dien_thoai_9.services.IService;
import bai_tap.quan_ly_dien_thoai_9.utils.NotFoundProductException;
import bai_tap.quan_ly_dien_thoai_9.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class AuthenticPhoneServicesImpl implements IService<Phone> {

    private static final String AUTHENTICATE_PHONE_FILE_PATH = "src/bai_tap/quan_ly_dien_thoai_9/data/authenticate_phone.csv";
    private static List<Phone> authenticatePhoneList = new ArrayList<>();

    static {
        authenticatePhoneList = ReadWriteCSVFile.readAuthenticatePhoneListFromCSVFile(AUTHENTICATE_PHONE_FILE_PATH);

    }

    private final String TITLE_OF_CSV = "phoneID,phoneName,price,quantity,manufacture";

    @Override
    public int findGoodID() {
        if (authenticatePhoneList.size() == 0) {
            return 1;
        } else {
            return authenticatePhoneList.get(authenticatePhoneList.size() - 1).getPhoneID() + 1;
        }
    }

    @Override
    public void add(Phone phone) {
        authenticatePhoneList.add(phone);
        ReadWriteCSVFile.writeListToCSVFile(authenticatePhoneList, AUTHENTICATE_PHONE_FILE_PATH, TITLE_OF_CSV);
        System.out.println(phone);
        System.out.println("✔ Add successfullty");
    }

    @Override
    public void display() {
        System.out.println("=====AUTHENTICATE PHONE LIST=====");
        if (authenticatePhoneList.size() != 0) {
            int index = 0;
            for (Phone phone : authenticatePhoneList) {
                System.out.printf("[%d] - %s\n", index++, phone);
            }
        } else {
            System.out.println("!!!AUTHENTICATE PHONE LIST IS EMPTY!!!");
        }
    }

    @Override
    public void remove(Phone phone) {
        authenticatePhoneList.remove(phone);
        ReadWriteCSVFile.writeListToCSVFile(authenticatePhoneList, AUTHENTICATE_PHONE_FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Remove Successfully");
    }

    @Override
    public Phone findPhoneByID(int ID) throws NotFoundProductException {
        if (authenticatePhoneList.size() != 0) {
            for (Phone phone : authenticatePhoneList) {
                if (ID == phone.getPhoneID()) {
                    return phone;
                }
            }
            throw new NotFoundProductException();
        } else {
            throw new NotFoundProductException();
        }
    }

    @Override
    public void displayPhoneByKeyword(String keywords) {
        boolean isFound = false;
        if (authenticatePhoneList.size() != 0) {
            for (Phone phone : authenticatePhoneList) {
                if ((phone.getPhoneID() + "").contains(keywords)
                    || phone.getPhoneName().toLowerCase().contains(keywords.toLowerCase())) {
                    isFound = true;
                    System.out.println(phone);
                }
            }
            if (!isFound) {
                System.out.println("Not found " + keywords + " in authenticate Patient list");
            }
        } else {
            System.out.println("Not found " + keywords + " in authenticate Patient list");
        }
    }
}
