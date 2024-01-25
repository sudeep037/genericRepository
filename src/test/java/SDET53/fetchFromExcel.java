package SDET53;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchFromExcel {

	
	public static void main(String[] args)throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\OragnizationExcelData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		boolean status = false;
		
		for(int r = 0; r<=rows; r++)
		{			
			for(int c = 0; c <=cols; c++)
			{
				String values = sheet.getRow(r).getCell(0).toString();
				 if(values.contentEquals("Cognizant"))
				 {
					 status = true;
					 System.out.println(sheet.getRow(r).getCell(c+1).toString());
					 break;
				 }
				 else {
					 status = false;
					 System.out.println("Invalid data");
				 }
			}
			
		}
		
	}
}
