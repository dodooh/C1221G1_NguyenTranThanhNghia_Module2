package case_study.furama_resort.services;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Facility;
import case_study.furama_resort.services.IService;
import java.util.Set;

public interface IBookingService {
    void displaySet(Set<Booking> set);
    void add(Booking facility);
}
