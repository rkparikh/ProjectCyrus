package com.rd.project.cyrus.extra;

import java.util.Scanner;

import com.rd.project.cyrus.common.FieldsMap;
import com.rd.project.cyrus.common.RegisterJACOBDLL;

import autoitx4java.AutoItX;

public class EnterFullForm {

	public static void main(String[] args) throws Exception {
		RegisterJACOBDLL.registerDLLs();

		String mainScreenName = "I-Biz Infosys Pvt. Ltd.";
		int delay = 100;

		AutoItX x = new AutoItX();
		x.winActivate(mainScreenName);
		x.winWaitActive(mainScreenName);
		String shortForm;
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while (i != -1) {
			System.out.println("Please Enter the short form :");
			shortForm = scanner.nextLine();
			if ("-1".equals(shortForm)) {
				i = -1;
			} else {
				String fullForm = FieldsMap.FULL_FORMS.get(shortForm
						.toUpperCase());
				x.winActivate(mainScreenName);
				x.winWaitActive(mainScreenName);
				x.send(fullForm);
				Thread.sleep(delay);
			}
		}
		System.exit(1);
	}

}
