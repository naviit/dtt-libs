package com.dtt.common.util;

public class StringUtils {

	public static boolean isEmpty(String...args) {
		for (String ele : args) {
			if(ele == null || ele.trim().isEmpty()) return true;
		}
		return false;
	}

	public static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

}
