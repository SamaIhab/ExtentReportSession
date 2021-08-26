package ExtentReportSession.ExtentReportSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	File src;
	FileInputStream myFile;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
    DataFormatter df;
	int rowCount;
	int columnCount;
	
	//method to initialize the path, file, and sheet name of excel file
	public void openFile() {
		
		
		try {
			
			src= new File("ReadLocators.xlsx");
			myFile= new FileInputStream(src);
			wb= new XSSFWorkbook(myFile);
			sheet1= wb.getSheetAt(0);
			df= new DataFormatter();
			rowCount=  sheet1.getPhysicalNumberOfRows();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			
		}catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		
			
		
	}
	
	//method to close the sheet and file of excel
	
	public void closeFile() {
		
		try {
			wb.close();
			myFile.close();
		} catch (IOException e) {
			System.out.println("Could not close");
			e.printStackTrace();
		}
	}
	
	//method to get row numbers in the excel sheet
	
	public int getRowCount() {
		return rowCount;
	}
	
	//method to read the integer cell and the string cell 
	public String readExcelCell(int row, int column) {
		
		String cellData= df.formatCellValue(sheet1.getRow(row).getCell(column));
		return cellData;
	
	}

}
