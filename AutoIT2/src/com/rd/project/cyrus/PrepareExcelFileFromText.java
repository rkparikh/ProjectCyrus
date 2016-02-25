package com.rd.project.cyrus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rd.project.cyrus.common.Constants;
import com.rd.project.cyrus.common.FieldsMap;

public class PrepareExcelFileFromText {
	public static void main(String[] args) throws Exception {

		Map<String, Map<String, String>> allFormData = new LinkedHashMap<String, Map<String, String>>();

		File parent = new File(Constants.INPUT_TEXT_FILES_FOLDER_PATH);
		for (File file : parent.listFiles()) {
			Map<String, String> data = new LinkedHashMap<String, String>(
					FieldsMap.SMALL_FORM_DATA_TEMPLATE);
			String line = "";

			data.put("Image File", file.getName());

			BufferedReader reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				line = line.replaceAll("  ", " ");
				if (line.contains("Form No")) {
					String newValue = line.replaceAll("Form No.", "")
							.replaceAll(":", "").trim();
					data.put("Form No", newValue);
				} else if (line.contains("Chairman")) {
					String newValue = line.replaceAll("Chairman", "")
							.replaceAll(":", "").trim();
					data.put("Chairman", newValue);
				} else if (line.contains("Website")
						|| line.contains("Webs ite")) {
					String newValue = line.replaceAll("Website", "")
							.replaceAll("Webs ite", "").replaceAll(":", "")
							.trim();
					data.put("Website", newValue);
				} else if (line.contains("Nation")) {
					String newValue = line.replaceAll("Nation", "")
							.replaceAll(":", "").trim();
					data.put("Nation", newValue);
				} else if (line.contains("Recorder")) {
					String newValue = line.replaceAll("Recorder", "")
							.replaceAll(":", "").trim();
					data.put("Recorder", newValue);
				} else if (line.contains("PEG")) {
					String newValue = line.replaceAll("PEG", "")
							.replaceAll(":", "").trim();
					data.put("PEG", newValue);
				} else if (line.contains("Sedol")) {
					String newValue = line.replaceAll("Sedol", "")
							.replaceAll(":", "").trim();
					data.put("Sedol", newValue);
				} else if (line.contains("Currency")) {
					String newValue = line.replaceAll("Currency Traded In", "")
							.replaceAll(":", "").trim();
					data.put("Currency", newValue);
				} else if (line.contains("Listing")) {
					String newValue = line.replaceAll("Listing Date", "")
							.replaceAll(":", "").trim();
					data.put("Listing Date", newValue);
				} else if (line.contains("Employees")) {
					String newValue = line.replaceAll("No. OF Employees", "")
							.replaceAll("No. Of Employees", "")
							.replaceAll(":", "").trim();
					data.put("Employees", newValue);
				} else if (line.contains("Capital")) {
					String newValue = line.replaceAll("Market Capital", "")
							.replaceAll(":", "").trim();
					data.put("Market Capital", newValue);
				} else {
					if (data.containsKey("REST")) {
						data.put("REST", data.get("REST") + line);
					} else {
						data.put("REST", line);
					}
				}
			}
			allFormData.put(file.getName(), data);
		}

		// Write Data To Excel File
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Data");
		XSSFRow row;
		int rowid = 0;
		row = spreadsheet.createRow(rowid++);
		int cellid = 0;
		for (String header : FieldsMap.SMALL_FORM_DATA_TEMPLATE.keySet()) {
			Cell cell = row.createCell(cellid++);
			cell.setCellValue((String) header);
		}
		for (Map<String, String> data : allFormData.values()) {
			row = spreadsheet.createRow(rowid++);
			cellid = 0;
			for (String value : data.values()) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) value);
			}
		}

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(
				Constants.OUTPUT_EXCEL_FILE_PATH);
		workbook.write(out);
		out.flush();
		out.close();
		workbook.close();
		System.out.println(Constants.OUTPUT_EXCEL_FILE_PATH
				+ " written successfully");

	}
}
