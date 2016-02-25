package com.rd.project.cyrus.extra;

import java.util.Date;

import com.rd.project.cyrus.common.Field;
import com.rd.project.cyrus.common.FieldsMap;
import com.rd.project.cyrus.common.RegisterJACOBDLL;

import autoitx4java.AutoItX;

public class PreFillFormNew {
	public static void main(String[] args) throws Exception {
		RegisterJACOBDLL.registerDLLs();
		String mainScreenName = "I-Biz Infosys Pvt. Ltd.";
		int totalForms = 10;
		int delay = 50;
		int saveDelay = 500;

		AutoItX x = new AutoItX();
		x.winActivate(mainScreenName);
		x.winWaitActive(mainScreenName);
		Thread.sleep(delay);
		System.out.println("All Start=" + new Date());
		for (int i = 1; i <= totalForms; i++) {
			// Click New Form
			x.controlClick(mainScreenName, "", "[NAME:btnNewform]");
			Thread.sleep(delay);
			for (Field field : FieldsMap.SMALL_FORM_FIELDS.values()) {
				if ("Form Number".equals(field.getFieldName())) {
					x.ControlSetText(mainScreenName, "", field.getFieldId(),
							"Form Number " + i);
				} else {
//					x.controlSend(mainScreenName, "", field.getFieldId(),
//							field.getFieldValue());
					x.ControlSetText(mainScreenName, "", field.getFieldId(),
							field.getFieldValue());
				}

			}
			x.controlClick(mainScreenName, "", "[NAME:btnSave]");
			Thread.sleep(saveDelay);
		}
		System.out.println("All Finish=" + new Date());
		System.exit(1);
	}
}
