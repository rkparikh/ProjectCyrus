package com.rd.project.cyrus;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rd.project.cyrus.common.Constants;
import com.rd.project.cyrus.common.Utils;

public class PrepareFinalFileFromExcel {
	public static void main(String[] args) throws Exception {
		StringBuffer buffer = new StringBuffer();

		FileInputStream fis = new FileInputStream(
				Constants.INPUT_EXCEL_FILE_PATH);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();
		// Skip Header
		rowIterator.next();
		Cell cell = null;
		// int rowCnt = 1;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			// rowCnt++;
			// if (rowCnt <= 70) {
			// continue;
			// }
			// Image Name
			for (int i = 1; i <= 15; i++) {
				cell = row.getCell(i);
				if (cell != null) {
					String data = cell.getStringCellValue().trim();
					if (i == 6) { // Listing Date
						data = Utils.getFormatedDate(data);
					}
					if (i == 11 || i == 12) { // No. Of Employees and Market
												// Capital
						data = Utils.getReplacedString(data, false);
					} else {
						data = Utils.getReplacedString(data, true);
						if (i == 9) { // Web site
							data = Utils.removeAllSpaces(data);
						}
					}
					buffer.append(data);
				}
				buffer.append("@");
			}
			buffer.append("\n");
		}
		// System.out.println(buffer.toString());
		FileWriter fileWriter = new FileWriter(Constants.OUTPUT_TEXT_FILE_PATH);
		fileWriter.write(buffer.toString());
		fileWriter.flush();
		fileWriter.close();

	}
}
