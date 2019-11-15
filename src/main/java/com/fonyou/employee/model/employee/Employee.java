package com.fonyou.employee.model.employee;

import com.fonyou.employee.util.ActiveTimeUtil;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private String firstname;
    private String lastname;
    private Date dateStart;
    private Date dateEnd;
    private float baseSalary;

    public float calculateSalary(short month, short year) throws ParseException {
        ActiveTimeUtil activeTime = new ActiveTimeUtil(dateStart, dateEnd, month, year);
        return this.baseSalary / 30 * activeTime.calculateTotalDays();
    }

}
