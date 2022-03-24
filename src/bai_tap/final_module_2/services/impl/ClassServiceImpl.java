package bai_tap.final_module_2.services.impl;

import bai_tap.final_module_2.models.Class;
import bai_tap.final_module_2.models.Person;
import bai_tap.final_module_2.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl {

    private static final String CLASS_FILE_PATH = "src/bai_tap/final_module_2/data/batchs.csv";
    private static List<Class> classList = new ArrayList<>();

    static {
        classList = ReadWriteCSVFile.readClassListFromCSVFile(CLASS_FILE_PATH);
    }

    public static String getClassNameByClassID(String classID) {
        for (Class cl : classList) {
            if (classID.equals(cl.getClassID())) {
                return cl.getClassName();
            }
        }
        return "";
    }

    public List<Class> getClassList() {
        return classList;
    }
}
