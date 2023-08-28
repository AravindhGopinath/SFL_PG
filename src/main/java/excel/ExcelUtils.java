package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtils {

	static ReadExcel reader;

	static String Excel_Path = "/home/administrator/Downloads/301 Redirection Code-20230524T054821Z-001/301 Redirection Code/PaymentGateway/src/main/java/excel/PG_Automation_TestData.xlsx";

	public static ArrayList<Object[]> nbDataFromexcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			String Excel_Name = Excel_Path;
			reader = new ReadExcel(Excel_Name);
			System.out.println(Excel_Name);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) {
			String INDEX = reader.getCellData("Sheet1", "INDEX", rowNum);
			String NB_Sub_FlowType = reader.getCellData("Sheet1", "NB_Sub_FlowType", rowNum);
			String Bank_name = reader.getCellData("Sheet1", "Bank_name", rowNum);
			String Bank_suggestion = reader.getCellData("Sheet1", "Bank_suggestion", rowNum);
			String Payment = reader.getCellData("Sheet1", "Payment", rowNum);

			Object[] ob = { INDEX, NB_Sub_FlowType, Bank_name, Bank_suggestion, Payment };

			myData.add(ob);
		}
		return myData;

	}

	public static ArrayList<Object[]> dcDataFromexcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			String Excel_Name = Excel_Path;
			reader = new ReadExcel(Excel_Name);
			System.out.println(Excel_Name);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet2"); rowNum++) {
			String INDEX = reader.getCellData("Sheet2", "INDEX", rowNum);
			String VISA_DCNumber = reader.getCellData("Sheet2", "VISA_DCNumber", rowNum);
			String ValidTill = reader.getCellData("Sheet2", "ValidTill", rowNum);
			String CVV_No = reader.getCellData("Sheet2", "CVV_No", rowNum);
			String Payment = reader.getCellData("Sheet2", "Payment", rowNum);

			Object[] ob = { INDEX, VISA_DCNumber, ValidTill, CVV_No, Payment };

			myData.add(ob);
		}
		return myData;

	}

	public static ArrayList<Object[]> upiDataFromexcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			String Excel_Name = Excel_Path;
			reader = new ReadExcel(Excel_Name);
			System.out.println(Excel_Name);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet3"); rowNum++) {
			String INDEX = reader.getCellData("Sheet3", "INDEX", rowNum);
			String UPI_id = reader.getCellData("Sheet3", "UPI_id", rowNum);
			String UPI_Bank_name = reader.getCellData("Sheet3", "UPI_Bank_name", rowNum);
			String Payment = reader.getCellData("Sheet3", "Payment", rowNum);

			Object[] ob = { INDEX, UPI_id, UPI_Bank_name, Payment };

			myData.add(ob);
		}
		return myData;

	}

	public static void writeinexcel(String value, int INDEX) throws Exception {
		Thread.sleep(2000);
		File fis = new File(Excel_Path);
//        String arr[]="https://www.google.com";
//        ArrayList<String> cars = new ArrayList<String>(fis);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(2);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();
	}

	public static void writeinexcel2(String value, int INDEX) throws Exception {
		Thread.sleep(2000);
		File fis = new File(Excel_Path);
//        String arr[]="https://www.google.com";
//        ArrayList<String> cars = new ArrayList<String>(fis);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(3);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();
	}

	public static void writeinexcelForReasons(String value, int INDEX) throws Exception {
		Thread.sleep(2000);
		File fis = new File(Excel_Path);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(46);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();
	}

}
