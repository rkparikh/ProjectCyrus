package com.rd.project.cyrus.common;

import java.util.LinkedHashMap;
import java.util.Map;
import static com.rd.project.cyrus.common.Constants.*;

public class FieldsMap {

	public static Map<String, String> SMALL_FORM_DATA_TEMPLATE = new LinkedHashMap<String, String>();
	static {
		SMALL_FORM_DATA_TEMPLATE.put("Image File", "");
		SMALL_FORM_DATA_TEMPLATE.put("Form No", "");
		SMALL_FORM_DATA_TEMPLATE.put("Company Name", "");
		SMALL_FORM_DATA_TEMPLATE.put("Nation", "");
		SMALL_FORM_DATA_TEMPLATE.put("Address", "");
		SMALL_FORM_DATA_TEMPLATE.put("Listing Date", "");
		SMALL_FORM_DATA_TEMPLATE.put("Sedol", "");
		SMALL_FORM_DATA_TEMPLATE.put("Recorder", "");
		SMALL_FORM_DATA_TEMPLATE.put("Website", "");
		SMALL_FORM_DATA_TEMPLATE.put("Fund Name", "");
		SMALL_FORM_DATA_TEMPLATE.put("Market Capital", "");
		SMALL_FORM_DATA_TEMPLATE.put("Employees", "");
		SMALL_FORM_DATA_TEMPLATE.put("PEG", "");
		SMALL_FORM_DATA_TEMPLATE.put("Chairman", "");
		SMALL_FORM_DATA_TEMPLATE.put("Currency", "");

		SMALL_FORM_DATA_TEMPLATE.put("REST", "");
	}

	public static final Map<String, Field> SMALL_FORM_FIELDS = new LinkedHashMap<String, Field>();
	static {
		// Section 1
		SMALL_FORM_FIELDS.put("Form Number", new Field("Form Number",
				"[NAME:TextBox1]", VALUE_PLACE_HOLDER, 1));
		SMALL_FORM_FIELDS.put("Company Code", new Field("Company Code",
				"[NAME:TextBox2]", "<B>" + NOT_MENTIONED + "<B>"));
		SMALL_FORM_FIELDS.put("Company Name", new Field("Company Name",
				"[NAME:TextBox3]", "<R>" + VALUE_PLACE_HOLDER + "<R>", 2));
		SMALL_FORM_FIELDS.put("Country", new Field("Country",
				"[NAME:TextBox6]", VALUE_PLACE_HOLDER, 3));
		SMALL_FORM_FIELDS.put("Company Address", new Field("Company Address",
				"[NAME:TextBox5]", VALUE_PLACE_HOLDER, 4));
		SMALL_FORM_FIELDS.put("Listing Date", new Field("Listing Date",
				"[NAME:TextBox20]", VALUE_PLACE_HOLDER, 5));
		SMALL_FORM_FIELDS.put("SEDOL", new Field("SEDOL", "[NAME:TextBox9]",
				VALUE_PLACE_HOLDER, 6));
		SMALL_FORM_FIELDS.put("Recorder", new Field("Recorder",
				"[NAME:TextBox7]", VALUE_PLACE_HOLDER, 7));
		SMALL_FORM_FIELDS.put("Website", new Field("Website",
				"[NAME:TextBox11]", "<I><U>" + VALUE_PLACE_HOLDER, 8));
		SMALL_FORM_FIELDS.put("Market Turnover", new Field("Market Turnover",
				"[NAME:TextBox12]", NOT_MENTIONED));

		// Section 2
		SMALL_FORM_FIELDS.put("Board Lot", new Field("Board Lot",
				"[NAME:TextBox16]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Classification", new Field("Classification",
				"[NAME:TextBox10]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Fund Name", new Field("Fund Name",
				"[NAME:TextBox4]", VALUE_PLACE_HOLDER, 9));
		SMALL_FORM_FIELDS.put("Authorised Share", new Field("Authorised Share",
				"[NAME:TextBox29]", "<R><B>" + NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Market Capital", new Field("Market Capital",
				"[NAME:TextBox18]", "<R>" + VALUE_PLACE_HOLDER + "<R>", 10));
		SMALL_FORM_FIELDS.put("Place of Share Register", new Field(
				"Place of Share Register", "[NAME:TextBox13]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Company's Profile", new Field(
				"Company's Profile", "[NAME:TextBox8]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Negotiator", new Field("Negotiator",
				"[NAME:TextBox14]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Outstanding Shares", new Field(
				"Outstanding Shares", "[NAME:TextBox15]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("No. of Employees", new Field("No. of Employees",
				"[NAME:TextBox30]", VALUE_PLACE_HOLDER, 11));

		// Section 3
		SMALL_FORM_FIELDS.put("PEG/Par Value", new Field("PEG/Par Value",
				"[NAME:TextBox21]", VALUE_PLACE_HOLDER, 12));
		SMALL_FORM_FIELDS.put("Chairman", new Field("Chairman",
				"[NAME:TextBox27]", VALUE_PLACE_HOLDER, 13));
		SMALL_FORM_FIELDS.put("Issued Shares", new Field("Issued Shares",
				"[NAME:TextBox28]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Currency", new Field("Currency",
				"[NAME:TextBox19]", VALUE_PLACE_HOLDER, 14));
		SMALL_FORM_FIELDS.put("Sub Classification", new Field(
				"Sub Classification", "[NAME:TextBox17]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Trading Pattern", new Field("Trading Pattern",
				"[NAME:TextBox23]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("PE Ratio", new Field("PE Ratio",
				"[NAME:TextBox25]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Councellor", new Field("Councellor",
				"[NAME:TextBox24]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("ISD Status", new Field("ISD Status",
				"[NAME:TextBox22]", NOT_MENTIONED));
		SMALL_FORM_FIELDS.put("Consultant", new Field("Consultant",
				"[NAME:TextBox26]", NOT_MENTIONED));
	}

	public static final Map<String, String> FULL_FORMS = new LinkedHashMap<String, String>();
	static {
		FULL_FORMS.put("Ltd.", "Limited");
		FULL_FORMS.put("Inc.", "Incorporation");
		FULL_FORMS.put("Co.", "Company");
		FULL_FORMS.put("Corp.", "Corporation");
		FULL_FORMS.put("&", "and");
		FULL_FORMS.put("AUD", "Australian Dollar");
		FULL_FORMS.put("BMD", "Bermuda Dollar");
		FULL_FORMS.put("CAD", "Canadian Dollar");
		FULL_FORMS.put("CD", "Canadian Dollar");
		FULL_FORMS.put("CHF", "Confederazione Helvetica (Swiss) Franc");
		FULL_FORMS.put("EUA", "Employee’s Union Association");
		FULL_FORMS.put("EUR", "Euro");
		FULL_FORMS.put("GBP", "Great Britain Pound");
		FULL_FORMS.put("GB", "Great Britain");
		FULL_FORMS.put("HKD", "Hong Kong Dollar");
		FULL_FORMS.put("HK", "Hong Kong");
		FULL_FORMS.put("INR", "Indian Rupee");
		FULL_FORMS.put("NIS", "New Israel Shekel");
		FULL_FORMS.put("NZD", "New Zealand Dollar");
		FULL_FORMS.put("PRC", "People’s Republic of China");
		FULL_FORMS.put("PS", "Pounds Sterling");
		FULL_FORMS.put("RMB", "Ren Min Bi");
		FULL_FORMS.put("TD", "Taiwanese Dollar");
		FULL_FORMS.put("USD", "Unites States Dollar");
		FULL_FORMS.put("USA", "Unites States of America");
		FULL_FORMS.put("ZAR", "South African Rand");
	}

}
