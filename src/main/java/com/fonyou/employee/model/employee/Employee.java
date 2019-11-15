package com.fonyou.employee.model.employee;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID  = -1294753673093696694L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="firstname", length = 255)
    private String firstname;
    @Column(name="lastname", length = 255)
    private String lastname;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "date_end")
    private LocalDate dateEnd;
    @Column(name = "base_salary", scale=2)
    private float baseSalary;

    /**
     * Determine salary of month
     * @param month final
     * @param year final
     * @return float
     */
    public float calculateSalary(final int month, final int year){
        return (baseSalary / 30) * calculateDaysWorked(month, year);
    }

    /**
     * Determina total days worked in the month
     * @param month final
     * @param year final
     * @return int
     */
    public int calculateDaysWorked(final int month, final int year) {
        LocalDate queryDate = LocalDate.of(year, month, 1);
        if(dateEnd != null && queryDate.isAfter(dateEnd)){
            return 0;
        }
        int daysWorked = isSameMonth(dateStart, queryDate) ? dateStart.getDayOfMonth() : 0;
        if (isSameMonth(dateEnd, queryDate)) {
            daysWorked = dateEnd.getDayOfMonth() - daysWorked;
        } else {
            daysWorked = 30 - daysWorked;
        }
        return daysWorked;
    }

    /**
     * Determina if a month is same by their year and month value
     *
     * @param date LocalDate
     * @param dateCompared LocalDate
     * @return boolean
     */
    private boolean isSameMonth(final LocalDate date, final LocalDate dateCompared) {
        return date != null
                && date.getMonthValue() == dateCompared.getMonthValue()
                && date.getYear() == dateCompared.getYear();
    }

}
