package com.hastaakshar.builder.util;

import java.util.UUID;

public class BuilderUtil {

	public static final String HASTAAKSHAR_HOME = "HASTAAKSHAR_HOME";

	public static String genrateUUID() {
		return UUID.randomUUID().toString();
	}

	public static String toCamelCase(String string) {
		String[] parts = string.split(" ");
		StringBuffer camelCaseString = new StringBuffer("");
		for (String part : parts) {
			if (part != null && part.trim().length() > 0)
				camelCaseString = camelCaseString.append(toProperCase(part));
			else
				camelCaseString = camelCaseString.append(part);
		}
		return camelCaseString.toString();
	}

	static String toProperCase(String string) {
		String temp = string.trim();
		String spaces = "";
		if (temp.length() != string.length()) {
			int startCharIndex = string.charAt(temp.indexOf(0));
			spaces = string.substring(0, startCharIndex);
		}
		temp = temp.substring(0, 1).toUpperCase() + spaces + temp.substring(1).toLowerCase();
		return temp;

	}

}
