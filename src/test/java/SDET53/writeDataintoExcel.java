package SDET53;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.github.javafaker.Faker;

public class writeDataintoExcel {

	public static void main(String[] args) throws Throwable {
		
		Cell cell = null;
		Row row = null;
		Faker faker = new Faker();
		String name = faker.name().fullName();
		System.out.println(name);
		String company = faker.company().buzzword();
		System.out.println(company);
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
       org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
       
        row.setRowNum(4);
        int colCount = 2;
        
       
       for(int r = 0; r<=sheet.getLastRowNum(); r++)
       {
    	       row = sheet.createRow(r);
    	   for(int c = 0; c<=colCount; c++)
    	   {
    		     cell = row.createCell(c);
    		   if(colCount == 0)
    		   {
    		      cell.setCellValue(name);
    		   }
    		   else if(colCount>0)
    		   {
    			  cell.setCellValue(company);
    		   }
    	   }
       }
       
       FileOutputStream fos = new FileOutputStream(".\\src\\main\\resources\\testData.xlsx");
       workbook.write(fos);
       System.out.println("Data entered successfully");
	}
}
