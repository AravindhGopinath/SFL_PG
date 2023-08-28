package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {

	static ReadExcel reader;

	static String Excel_Path = "/home/administrator/Downloads/301 Redirection Code-20230524T054821Z-001/301 Redirection Code/PaymentGateway/src/main/java/excel/PG_Test_Data.xlsx";

	public static ArrayList<Object[]> getDataFromexcel() {
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
			String Flow_Type = reader.getCellData("Sheet1", "Flow_Type", rowNum);
			String NB_Sub_FlowType = reader.getCellData("Sheet1", "NB_Sub_FlowType", rowNum);
			String Bank_name = reader.getCellData("Sheet1", "Bank_name", rowNum);
			String VISA_DCNumber = reader.getCellData("Sheet1", "VISA_DCNumber", rowNum);
			String ValidTill = reader.getCellData("Sheet1", "ValidTill", rowNum);
			String CVV_No = reader.getCellData("Sheet1", "CVV_No", rowNum);
			String UPI_id = reader.getCellData("Sheet1", "UPI_id", rowNum);
			String UPI_Bank_name = reader.getCellData("Sheet1", "UPI_Bank_name", rowNum);
			String Payment = reader.getCellData("Sheet1", "Payment", rowNum);

			Object[] ob = { INDEX, Flow_Type, NB_Sub_FlowType, Bank_name,

					VISA_DCNumber, ValidTill, CVV_No, UPI_id, UPI_Bank_name, Payment };

			myData.add(ob);
		}
		return myData;

	}

	public static void writeinexcel(String value, int INDEX) throws Exception {
		Thread.sleep(1500);
		File fis = new File(Excel_Path);
//        String arr[]="https://www.google.com";
//        ArrayList<String> cars = new ArrayList<String>(fis);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(10);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();
	}

	public static void writeinexcel2(String value, int INDEX) throws Exception {
		Thread.sleep(1500);
		File fis = new File(Excel_Path);
//        String arr[]="https://www.google.com";
//        ArrayList<String> cars = new ArrayList<String>(fis);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(10);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();
	}

	public static void writeinexcelForReasons(String value, int INDEX) throws Exception {
		Thread.sleep(1500);
		File fis = new File(Excel_Path);
		FileInputStream excelloc = new FileInputStream(fis);
		XSSFWorkbook wb = new XSSFWorkbook(excelloc);
		XSSFSheet s = wb.getSheetAt(0);
		XSSFRow row = s.getRow(INDEX);
		XSSFCell c = row.createCell(11);
		c.setCellValue(value);
		FileOutputStream out = new FileOutputStream(fis);
		wb.write(out);
		out.close();

	}

}
