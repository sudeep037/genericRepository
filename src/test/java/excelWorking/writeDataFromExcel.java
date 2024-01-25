package excelWorking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class writeDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		Faker faker = new Faker();
		FileInputStream fis = new FileInputStream("./src/test/resources/excelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		
		Object [][] trainersData = {
				{"Name","Country"},
				{faker.name().fullName(),faker.address().country()},
				{faker.name().fullName(),faker.address().country()},
				{faker.name().fullName(),faker.address().country()}
		};
		
		int rowCount = 0;
		
		for(Object data []:trainersData)
		{
			Row row = sheet.createRow(rowCount++);
			int colCount = 0;
			for(Object value:data)
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
		wb.write(fos);
		fos.close();
		
		System.out.println("Data written successfully");
	}
}
