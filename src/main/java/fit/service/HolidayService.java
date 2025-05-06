package fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import fit.restclient.HolidayClient;
import fit.dto.CountryDTO;
import fit.dto.HolidayDTO;
import model.Holiday;
import model.HolidayType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class HolidayService {

    @Inject
    EntityManager em;

    @Inject
    @RestClient
    HolidayClient holidayClient;

    public List<CountryDTO> getAvailableCountries() {
        return holidayClient.getAvailableCountries();
    }

    @Transactional
    public List<Holiday> getNextPublicHolidays(String countryCode) {
        List<HolidayDTO> holidayDTOs = holidayClient.getNextPublicHolidays(countryCode);
        List<Holiday> holidays = new ArrayList<>();

        for (HolidayDTO dto : holidayDTOs) {
            LocalDate holidayDate = LocalDate.parse(dto.getDate());

            List<Holiday> existingHolidays = em.createQuery("SELECT h FROM Holiday h WHERE h.date = :date AND h.countryCode = :countryCode", Holiday.class)
                .setParameter("date", holidayDate)
                .setParameter("countryCode", countryCode)
                .getResultList();

            if (!existingHolidays.isEmpty()) {
                holidays.add(existingHolidays.get(0));
                continue; 
            }

          
            Holiday holiday = new Holiday();
            holiday.setDate(holidayDate);
            holiday.setLocalName(dto.getLocalName());
            holiday.setName(dto.getName());
            holiday.setCountryCode(dto.getCountryCode());
            holiday.setFixed(dto.getFixed());
            holiday.setGlobal(dto.getGlobal());
            holiday.setYear(holidayDate.getYear());

            List<HolidayType> types = new ArrayList<>();
            for (String type : dto.getTypes()) {
                HolidayType holidayType = new HolidayType();
                holidayType.setType(type);
                holidayType.setHoliday(holiday);
                types.add(holidayType);
            }
            holiday.setTypes(types);

            em.merge(holiday); 
            holidays.add(holiday);
        }

        return holidays;
    }
}