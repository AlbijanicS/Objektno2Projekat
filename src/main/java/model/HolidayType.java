package model;

import jakarta.persistence.*;

@Entity
public class HolidayType {

    @Id
    @SequenceGenerator(name = "holiday_type_sequence", sequenceName = "holiday_type_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_type_sequence")
    private Long id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    private Holiday holiday;

    public HolidayType() {
        super();
    }

    public HolidayType(Long id, String type, Holiday holiday) {
        super();
        this.id = id;
        this.type = type;
        this.holiday = holiday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}