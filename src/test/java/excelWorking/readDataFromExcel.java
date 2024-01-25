package excelWorking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 
		FileInputStream fis = new FileInputStream("./src/test/resources/excelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Iterator<Row> iterator = sheet.iterator();
		while(iterator.hasNext())
		{
			Row row = iterator.next();
			Iterator<Cell> cell = row.cellIterator();
			while(cell.hasNext())
			{
				Cell cellData = cell.next();
				switch(cellData.getCellType())
				{
				case STRING : System.out.print(cellData.getStringCellValue()); break;
				case NUMERIC:System.out.print(cellData.getNumericCellValue()); break;
				case BOOLEAN:System.out.print(cellData.getBooleanCellValue()); break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
}
