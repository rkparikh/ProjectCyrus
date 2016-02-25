package com.rd.project.cyrus.extra;

import static com.rd.project.cyrus.common.Constants.MAIN_SCREEN_NAME;
import static com.rd.project.cyrus.common.Constants.NEXT_BUTTTON_ID;
import static com.rd.project.cyrus.common.Constants.PREVIOUS_BUTTTON_ID;
import autoitx4java.AutoItX;

import com.rd.project.cyrus.common.FieldsMap;
import com.rd.project.cyrus.common.RegisterJACOBDLL;

public class GoToFormNumber {
	public static void main(String[] args) throws InterruptedException {
		RegisterJACOBDLL.registerDLLs();

		int delay = 10;
		int uptoForm = -2;
		int startFrom = 1200;
		String formNo = "HvAMYji";

		AutoItX x = new AutoItX();
		Thread.sleep(delay);
		x.winActivate(MAIN_SCREEN_NAME);
		x.winWaitActive(MAIN_SCREEN_NAME);
		Thread.sleep(delay);

		// First Go to last form
		x.controlClick(MAIN_SCREEN_NAME, "", NEXT_BUTTTON_ID);
		Thread.sleep(delay);
		StringBuffer buffer = new StringBuffer();
		for (int i = startFrom; i > uptoForm; i--) {
			x.controlClick(MAIN_SCREEN_NAME, "", PREVIOUS_BUTTTON_ID);
			String currentForm = x
					.controlGetText(MAIN_SCREEN_NAME, "",
							FieldsMap.SMALL_FORM_FIELDS.get("Form Number")
									.getFieldId());
			buffer.append(currentForm).append(",");
			if (currentForm.equals(formNo)) {
				System.out.println(i);
				break;
			}
			Thread.sleep(delay);
		}
		System.out.println(buffer.toString());
		System.exit(1);
	}
}
