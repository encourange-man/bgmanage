package com.machen.bgmanager.entry;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author machen
 * @date 2019-04-01 22:33
 */
@Data
public class Employee {

	private Integer id;
    private String lastName;

    private String email;
    /**
     * 1 male, 0 female
     */
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender,
                    Department department) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
