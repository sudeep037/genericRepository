package excelWorking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hamcrest.core.IsInstanceOf;

import com.github.javafaker.Faker;

public class writeExcelData {

	public static void main(String[] args) throws Throwable {
		
	Faker faker = new Faker();
	FileInputStream fis = new FileInputStream("./src/test/resources/excelData.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("Sheet3");
	
	// Creating Object array 
	
	Object [][] arr = {
			{faker.name().fullName(),faker.internet().emailAddress()},
			{faker.name().fullName(),faker.internet().emailAddress()},
			{faker.name().fullName(),faker.internet().emailAddress()}
	};
	
	int rowCount = 0;
	
	for(Object [] datas:arr)
	{
		Row row = sheet.createRow(rowCount++);
		int colCount = 0;
		for(Object value:datas)
		{
			Cell cell = row.createCell(colCount++);
			if(value instanceof String)
				cell.setCellValue((String)value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		}
	}
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/excelData.xlsx");
	book.write(fos);
	fos.close();
	
	System.out.println("Successfully written");
	
	}
}
