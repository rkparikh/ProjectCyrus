package com.rd.project.cyrus.extra;

import static com.rd.project.cyrus.common.Constants.MAIN_SCREEN_NAME;
import static com.rd.project.cyrus.common.Constants.NEXT_BUTTTON_ID;
import static com.rd.project.cyrus.common.Constants.PREVIOUS_BUTTTON_ID;
import autoitx4java.AutoItX;

import com.rd.project.cyrus.common.RegisterJACOBDLL;

public class GoToForm {
	public static void main(String[] args) throws InterruptedException {
		RegisterJACOBDLL.registerDLLs();

		int delay = 100;
		int uptoForm = 1;
		int startFrom = 1200;

		AutoItX x = new AutoItX();
		Thread.sleep(delay);
		x.winActivate(MAIN_SCREEN_NAME);
		x.winWaitActive(MAIN_SCREEN_NAME);
		Thread.sleep(delay);

		// First Go to last form
		x.controlClick(MAIN_SCREEN_NAME, "", NEXT_BUTTTON_ID);
		Thread.sleep(delay);
		for (int i = startFrom; i > uptoForm; i--) {
			x.controlClick(MAIN_SCREEN_NAME, "", PREVIOUS_BUTTTON_ID);
			Thread.sleep(delay);
		}
		System.exit(1);
	}
}
