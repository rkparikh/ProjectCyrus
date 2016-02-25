package com.rd.project.cyrus;

import static com.rd.project.cyrus.common.Constants.MAIN_SCREEN_NAME;
import static com.rd.project.cyrus.common.Constants.NEW_FORM_BUTTTON_ID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

import autoitx4java.AutoItX;

import com.rd.project.cyrus.common.Constants;
import com.rd.project.cyrus.common.Field;
import com.rd.project.cyrus.common.FieldsMap;
import com.rd.project.cyrus.common.RegisterJACOBDLL;

public class FinalFillForm {
	public static void main(String[] args) throws Exception {
		RegisterJACOBDLL.registerDLLs();

		int totalForms = 1200;
		int delay = 50;
		int saveDelay = 500;

		AutoItX x = new AutoItX();
		x.winActivate(MAIN_SCREEN_NAME);
		x.winWaitActive(MAIN_SCREEN_NAME);
		Thread.sleep(delay);

		System.out.println("All Start=" + new Date());

		BufferedReader br = new BufferedReader(new FileReader(
				Constants.OUTPUT_TEXT_FILE_PATH));
		String currentFormDataStr = null;
		int i = 0;
		while ((currentFormDataStr = br.readLine()) != null) {
			i++;
			if (i > totalForms) {
				break;
			}
			// x.controlClick(MAIN_SCREEN_NAME, "", NEXT_BUTTTON_ID);
			x.controlClick(MAIN_SCREEN_NAME, "", NEW_FORM_BUTTTON_ID);
			Thread.sleep(delay);

			String[] dataArr = currentFormDataStr.split("@");
			for (Field field : FieldsMap.SMALL_FORM_FIELDS.values()) {

				String fieldValue = field.getFieldValue();

				if (field.getIndexInArr() != -1) {
					if (dataArr[field.getIndexInArr()].isEmpty()) {
						fieldValue = fieldValue.replace(
								Constants.VALUE_PLACE_HOLDER,
								Constants.NOT_MENTIONED);
					} else {
						fieldValue = fieldValue.replace(
								Constants.VALUE_PLACE_HOLDER,
								dataArr[field.getIndexInArr()]);
					}
				}
				x.ControlSetText(MAIN_SCREEN_NAME, "", field.getFieldId(),
						fieldValue);
			}
			Thread.sleep(delay);

			x.controlClick(MAIN_SCREEN_NAME, "", "[NAME:btnSave]");
			Thread.sleep(saveDelay);
		}
		System.out.println("All Finish=" + new Date());
		System.exit(1);
	}
}
