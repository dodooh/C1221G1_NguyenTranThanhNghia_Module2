package case_study.furama_resort.services;

import case_study.furama_resort.models.Contract;

public interface IContactService extends IService<Contract>  {

    void edit(Contract contract);
}
