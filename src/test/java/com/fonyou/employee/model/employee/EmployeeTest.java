package com.fonyou.employee.model.employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeTest {

    private Employee employee;

    @Before
    public void setup(){
        employee = new Employee();
    }

    @Test
    public void calculateDaysWorkedInitMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        int totalDaysWorked = employee.calculateDaysWorked(9, 2018);
        Assert.assertEquals(15, totalDaysWorked);
    }

    @Test
    public void calculateDaysWorkedSecondMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        int totalDaysWorked = employee.calculateDaysWorked(10, 2018);
        Assert.assertEquals(30, totalDaysWorked);
    }

    @Test
    public void calculateDaysWorkedStartAndEndSameMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,9,25));
        int totalDaysWorked = employee.calculateDaysWorked(9, 2018);
        Assert.assertEquals(10, totalDaysWorked);
    }

    @Test
    public void calculateDaysWorkedNoWorkedTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,9,25));
        int totalDaysWorked = employee.calculateDaysWorked(10, 2018);
        Assert.assertEquals(0, totalDaysWorked);
    }

    @Test
    public void calculateDaysWorkedEndAndQueryEqualTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,10,1));
        int totalDaysWorked = employee.calculateDaysWorked(10, 2018);
        Assert.assertEquals(1, totalDaysWorked);
    }

    @Test
    public void calculateDaysWorkedStartAndQuerySameMonthOtherYearTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        int totalDaysWorked = employee.calculateDaysWorked(9, 2019);
        Assert.assertEquals(30, totalDaysWorked);
    }

    @Test
    public void calculateSalaryInitMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(9, 2018);
        Assert.assertEquals(600000, salary, 0);
    }

    @Test
    public void calculateSalarySecondMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(10, 2018);
        Assert.assertEquals(1200000, salary, 0);
    }

    @Test
    public void calculateSalaryStartAndEndSameMonthTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,9,25));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(9, 2018);
        Assert.assertEquals(400000, salary, 0);
    }

    @Test
    public void calculateSalaryNoWorkedTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,9,25));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(10, 2018);
        Assert.assertEquals(0, salary, 0);
    }

    @Test
    public void calculateSalaryEndAndQueryEqualTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setDateEnd(LocalDate.of(2018,10,1));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(10, 2018);
        Assert.assertEquals(40000.00, salary, 0);
    }

    @Test
    public void calculateSalaryStartAndQuerySameMonthOtherYearTest() {
        employee.setDateStart(LocalDate.of(2018,9,15));
        employee.setBaseSalary(1200000);
        float salary = employee.calculateSalary(9, 2019);
        Assert.assertEquals(1200000.00, salary, 0);
    }


}
