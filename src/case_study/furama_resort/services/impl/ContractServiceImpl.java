package case_study.furama_resort.services.impl;

import static case_study.furama_resort.utils.ReadWriteCSVFile.readContractListFromCSVFile;
import static case_study.furama_resort.utils.ReadWriteCSVFile.writeListToCSVFile;

import case_study.furama_resort.models.Contract;
import case_study.furama_resort.services.IContactService;
import case_study.furama_resort.utils.ParseObjectException;
import java.util.ArrayList;
import java.util.List;

public class ContractServiceImpl implements IContactService {

    private static final String CONTRACT_FILE_PATH = "src/case_study/furama_resort/data/contract.csv";
    public static List<Contract> contractList = new ArrayList<>();
    private static ContractServiceImpl instance;

    static {
        try {
            contractList = readContractListFromCSVFile(CONTRACT_FILE_PATH);
        } catch (ParseObjectException e) {
            System.out.println(e.getMessage());
        }
    }

    private ContractServiceImpl() {
    }

    public static ContractServiceImpl getInstance() {
        if (instance == null) {
            instance = new ContractServiceImpl();
        }
        return instance;
    }

    @Override
    public void edit(int index, Contract newContract) {
        contractList.set(index, newContract);
        writeListToCSVFile(contractList, CONTRACT_FILE_PATH);
        System.out.println("✓Edit Successfully");

    }

    @Override
    public void displayList() {
        System.out.println("============Contract Set============");
        if (contractList.size() != 0) {
            for (Contract contract : contractList) {
                System.out.println(contract);
            }
        } else {
            System.out.println("!!!CONTRACT LIST IS EMPTY!!!");
        }
    }

    @Override
    public void add(Contract contract) {
        contractList.add(contract);
        writeListToCSVFile(contractList, CONTRACT_FILE_PATH);
        System.out.println("✓Add Contract Successfully");
    }

    public Contract findContractByContractNumber(int contractNumber) {
        for (Contract contract : contractList) {
            if (contract.getContractNumber() == contractNumber) {
                return contract;
            }
        }
        return null;
    }
}
