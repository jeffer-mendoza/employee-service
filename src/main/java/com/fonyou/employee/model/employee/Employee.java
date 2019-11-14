package com.fonyou.employee.model.employee;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID  = -1294753673093696694L;

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private Date dateStart;
    private Date dateEnd;
    private float baseSalary;

}
