package SDET53;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		// Reading data 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\OragnizationExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
		int Rowcount = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		for(int i = 0; i<=Rowcount; i++) // indicates row
		{
			for(int j = 0; j<=lastCell; j++)
			{
			String value = sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.print(value+"---->");
			}
			System.out.println();
		}
		
	}
}

