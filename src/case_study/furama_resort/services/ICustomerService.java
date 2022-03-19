package case_study.furama_resort.services;

import case_study.furama_resort.models.Customer;

public interface ICustomerService extends IPeopleService {

    Customer getCustomerByID(String id);
}
