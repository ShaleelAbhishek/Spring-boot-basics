package com.allocation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Integer empId;
    private String alloName;
    private String startDate;
    private String endDate;

    public Allocation(Integer id, Integer empId, String name, String startDate, String endDate) {
        this.id = id;
        this.empId = empId;
        this.alloName = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Allocation() {
    }

    /***************************************************************************/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getAlloName() {
        return alloName;
    }

    public void setAlloName(String alloName) {
        this.alloName = alloName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}