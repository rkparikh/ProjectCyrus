package com.rd.project.cyrus.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {

	private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat formatNew = new SimpleDateFormat(
			"dd# MMMMM,yyyy");

	public static String getFormatedDate(final String strDate)
			throws ParseException {
		Date date = format.parse(strDate);
		String formatedDate = formatNew.format(date);
		return formatedDate.replaceAll("#", getDayOfMonthSuffix(Integer
				.parseInt(formatedDate.split("#")[0])));
	}

	public static String getDayOfMonthSuffix(final int n) {
		if (n < 1 || n > 31) {
			throw new RuntimeException("Invalid Date");
		}
		if (n >= 11 && n <= 13) {
			return "th";
		}
		switch (n % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}

	public static String getReplacedString(final String dataStr,
			final boolean putDoubleSpaceAfterComma) {
		String result = dataStr;
		// 1. Remove all additional Spaces after and from the string
		result = result.trim().replaceAll("\\s+", " ");
		// 2. Remove all spaces before and after -
		result = result.replaceAll("[ ]*-[ ]*", "-");
		// 3. put double space after comma whenever it appears
		if (putDoubleSpaceAfterComma == true) {
			result = result.replace(", ", ",");
			result = result.replace(",", ",  ");
		}
		// 4. Replace short form with full form
		if (!result.toLowerCase().contains("SAUDI".toLowerCase())) {
			for (String shortForm : FieldsMap.FULL_FORMS.keySet()) {
				result = result.replace(shortForm,
						FieldsMap.FULL_FORMS.get(shortForm));
			}
		}

		return result;
	}

	public static String removeAllSpaces(final String dataStr) {
		return dataStr.replaceAll("\\s*", "");
	}

	public static void main(String[] args) throws ParseException {
		String date = getReplacedString("CHF CHF CHF", true);
		System.out.println(date);
	}

}
