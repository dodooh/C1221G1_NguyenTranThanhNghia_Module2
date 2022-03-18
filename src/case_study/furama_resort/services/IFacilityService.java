package case_study.furama_resort.services;

import case_study.furama_resort.models.Facility;

public interface IFacilityService extends IService<Facility> {
    Facility getFacilityByID(String ID);
}
