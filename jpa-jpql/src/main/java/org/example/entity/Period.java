package org.example.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Embeddable
public class Period {

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    public boolean isWork (Date date) {
        // startDate <= date <= endDate 확인
        return (startDate == null || !date.before(startDate)) &&
                (endDate == null || !date.after(endDate));
    }
}
