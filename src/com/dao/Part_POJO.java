package com.dao;
public class Part_POJO {
	public String PART_NO;
	public String HDD_VALUE;
	public String YEAR_LIMITATION;
	public String getPartNo() {
		return PART_NO;
	}
	public String getCapacity() {
		if (HDD_VALUE == null) {
			HDD_VALUE = "";
		}
		return HDD_VALUE;
	}
	public String getYear() {
		if (YEAR_LIMITATION == null) {
			YEAR_LIMITATION = "";
		}
		return YEAR_LIMITATION;
	}
}
