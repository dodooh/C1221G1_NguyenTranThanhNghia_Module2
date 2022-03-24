package bai_tap.quan_ly_dien_thoai_9.services.impl;

import bai_tap.quan_ly_dien_thoai_9.models.Phone;
import bai_tap.quan_ly_dien_thoai_9.services.IService;
import bai_tap.quan_ly_dien_thoai_9.utils.NotFoundProductException;
import bai_tap.quan_ly_dien_thoai_9.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class HandPhoneServiceImpl implements IService<Phone> {

    private static final String HAND_PHONE_FILE_PATH = "src/bai_tap/quan_ly_dien_thoai_9/data/hand_phone.csv";
    private static List<Phone> handPhoneList = new ArrayList<>();

    static {
        handPhoneList = ReadWriteCSVFile.readHandPhoneListFromCSVFile(HAND_PHONE_FILE_PATH);
    }

    private final String TITLE_OF_CSV = "phoneID,phoneName,price,quantity,manufacture";

    @Override
    public int findGoodID() {
        if (handPhoneList.size() == 0) {
            return 1;
        } else {
            return handPhoneList.get(handPhoneList.size() - 1).getPhoneID() + 1;
        }
    }

    @Override
    public void add(Phone phone) {
        handPhoneList.add(phone);
        ReadWriteCSVFile.writeListToCSVFile(handPhoneList, HAND_PHONE_FILE_PATH, TITLE_OF_CSV);
        System.out.println("✔ Add successfully");
    }

    @Override
    public void display() {
        System.out.println("=====HAND PHONE LIST=====");
        if (handPhoneList.size() != 0) {
            int index = 0;
            for (Phone phone : handPhoneList) {
                System.out.printf("[%d] - %s\n", index++, phone);
            }
        } else {
            System.out.println("!!!HAND PHONE LIST IS EMPTY!!!");
        }
    }

    @Override
    public void remove(Phone phone) {
        handPhoneList.remove(phone);
        ReadWriteCSVFile.writeListToCSVFile(handPhoneList, HAND_PHONE_FILE_PATH, TITLE_OF_CSV);
        System.out.println(phone);
        System.out.println("✔ Remove Successfully");
    }

    @Override
    public Phone findPhoneByID(int ID) throws NotFoundProductException {
        if (handPhoneList.size() != 0) {
            for (Phone phone : handPhoneList) {
                if (ID == phone.getPhoneID()) {
                    return phone;
                }
            }
        }
        throw new NotFoundProductException();
    }

    @Override
    public void displayPhoneByKeyword(String keywords) {
        boolean isFound = false;
        if (handPhoneList.size() != 0) {
            for (Phone phone : handPhoneList) {
                if ((phone.getPhoneID() + "").contains(keywords)
                    || phone.getPhoneName().toLowerCase().contains(keywords.toLowerCase())) {
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
