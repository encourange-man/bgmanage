package com.machen.bgmanager.entry;

import lombok.Data;

/**
 *
 * @author machen
 * @date 2019-04-01 22:33
 */
@Data
public class Department {

	private Integer id;
	private String departmentName;

	public Department(int i, String string) {
		this.id = i;
		this.departmentName = string;
	}
}
